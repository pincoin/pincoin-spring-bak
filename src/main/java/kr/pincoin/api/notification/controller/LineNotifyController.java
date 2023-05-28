package kr.pincoin.api.notification.controller;

import jakarta.validation.Valid;
import kr.pincoin.api.home.exception.ApiException;
import kr.pincoin.api.notification.dto.LineNotifyRequest;
import kr.pincoin.api.notification.dto.LineNotifyResponse;
import kr.pincoin.api.notification.service.LineNotifyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/line-notify")
@CrossOrigin("*")
@Slf4j
public class LineNotifyController {
    private final LineNotifyService lineNotifyService;

    public LineNotifyController(LineNotifyService lineNotifyService) {
        this.lineNotifyService = lineNotifyService;
    }

    @PostMapping("/send")
    @PreAuthorize("isAuthenticated() and @identity.isSuperuser()")
    public ResponseEntity<LineNotifyResponse>
    send(@Valid @RequestBody LineNotifyRequest request) {
        return lineNotifyService.send(request)
                .map(response -> ResponseEntity.ok().body(response))
                .orElseThrow(() -> new ApiException(HttpStatus.NOT_FOUND,
                                                    "라인 메신저 통보 실패",
                                                    List.of("관리자에게 문의하시기 바랍니다.")));
    }
}

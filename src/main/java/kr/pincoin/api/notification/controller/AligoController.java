package kr.pincoin.api.notification.controller;

import jakarta.validation.Valid;
import kr.pincoin.api.home.exception.ApiException;
import kr.pincoin.api.notification.dto.AligoSendRequest;
import kr.pincoin.api.notification.dto.AligoSendResponse;
import kr.pincoin.api.notification.service.AligoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aligo")
@CrossOrigin("*")
@Slf4j
public class AligoController {
    private final AligoService aligoService;

    public AligoController(AligoService aligoService) {
        this.aligoService = aligoService;
    }

    @PostMapping("/send")
    @PreAuthorize("isAuthenticated() and @identity.isSuperuser()")
    public ResponseEntity<AligoSendResponse>
    send(@Valid @RequestBody AligoSendRequest request) {
        return aligoService.sendSms(request)
                .map(response -> ResponseEntity.ok().body(response))
                .orElseThrow(() -> new ApiException(HttpStatus.NOT_FOUND,
                                                    "문자 전송 실패",
                                                    List.of("관리자에게 문의하시기 바랍니다.")));
    }
}

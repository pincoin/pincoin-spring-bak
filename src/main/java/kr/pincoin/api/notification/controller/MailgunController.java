package kr.pincoin.api.notification.controller;

import jakarta.validation.Valid;
import kr.pincoin.api.home.exception.ApiException;
import kr.pincoin.api.notification.dto.MailgunSendRequest;
import kr.pincoin.api.notification.dto.MailgunSendResponse;
import kr.pincoin.api.notification.service.MailgunService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mailgun")
@CrossOrigin("*")
@Slf4j
public class MailgunController {
    private final MailgunService mailgunService;

    public MailgunController(MailgunService mailgunService) {
        this.mailgunService = mailgunService;
    }

    @PostMapping("/send")
    @PreAuthorize("isAuthenticated() and @identity.isSuperuser()")
    public ResponseEntity<MailgunSendResponse>
    send(@Valid @RequestBody MailgunSendRequest request) {
        return mailgunService.send(request)
                .map(response -> ResponseEntity.ok().body(response))
                .orElseThrow(() -> new ApiException(HttpStatus.NOT_FOUND,
                                                    "이메일 발송 실패",
                                                    List.of("관리자에게 문의하시기 바랍니다.")));
    }
}

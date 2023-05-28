package kr.pincoin.api.payment.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/callbacks")
@CrossOrigin("*")
@Slf4j
public class CallbackController {
    /**
     * 콜백 - 계좌이체
     */
    @PostMapping("/transfer")
    public ResponseEntity<String>
    transferCallback() {
        return null;
    }

    /**
     * 콜백 - 빌게이트
     */
    @PostMapping("/billgate")
    public ResponseEntity<String>
    billgateCallback() {
        return null;
    }

    /**
     * 콜백 - 페이팔
     */
    @PostMapping("/paypal")
    public ResponseEntity<String>
    paypalCallback() {
        return null;
    }
}

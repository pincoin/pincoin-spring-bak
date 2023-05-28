package kr.pincoin.api.notification.service;

import kr.pincoin.api.notification.dto.LineNotifyResponse;
import kr.pincoin.api.notification.dto.LineNotifyResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Optional;

@Service
@Slf4j
public class LineNotifyService {
    @Value("${line-notify.token}")
    private String token;

    private final WebClient webClient;

    public LineNotifyService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://notify-api.line.me/api").build(); // 운영
    }

    @Transactional
    public Optional<LineNotifyResponse> send(String message) {
        MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();

        formData.add("message", message);

        LineNotifyResult result = webClient.post()
                .uri("/notify")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .headers(header -> header.setBearerAuth(token))
                .accept(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromFormData(formData))
                .retrieve()
                .bodyToMono(LineNotifyResult.class)
                .block();

        if (result != null) {
            if (result.getStatus().equals("200")) {
                return Optional.of(new LineNotifyResponse(result.getStatus(), result.getMessage()));
            }

            log.warn("라인 통보 전송실패: {} {}", result.getStatus(), result.getMessage());
        }

        return Optional.empty();
    }
}

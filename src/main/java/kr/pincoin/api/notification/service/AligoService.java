package kr.pincoin.api.notification.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import kr.pincoin.api.notification.dto.AligoSendRequest;
import kr.pincoin.api.notification.dto.AligoSendResponse;
import kr.pincoin.api.notification.dto.AligoSendResult;
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
public class AligoService {
    @Value("${aligo.api-key}")
    private String apiKey;

    @Value("${aligo.user-id}")
    private String userId;

    @Value("${aligo.sender}")
    private String sender;

    private final WebClient webClient;

    public AligoService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://apis.aligo.in").build(); // 운영
    }

    @Transactional
    public Optional<AligoSendResponse> sendSms(AligoSendRequest request) {
        MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();

        formData.add("key", apiKey);
        formData.add("user_id", userId);
        formData.add("sender", sender);
        formData.add("receiver", request.getPhone());
        formData.add("msg", request.getMessage());

        // 주의사항:
        // api 주소 끝에 반드시 "/"를 붙여줘야 한다. 그렇지 않으면 301 리다이렉트
        // accept 헤더가 application/json이 아니라 text/html이므로 문자열로 받아서 json 파싱

        String jsonString = webClient.post()
                .uri("/send/")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .accept(MediaType.TEXT_HTML)
                .body(BodyInserters.fromFormData(formData))
                .retrieve()
                .bodyToMono(String.class)
                .block();

        ObjectMapper mapper = new ObjectMapper();
        try {
            AligoSendResult result = mapper.readValue(jsonString, AligoSendResult.class);

            if (result.getResultCode().equals("1") && result.getMessage().equals("success")) {
                return Optional.of(new AligoSendResponse(result.getResultCode(),
                                                         result.getMessage(),
                                                         result.getMsgId(),
                                                         result.getSuccessCnt(),
                                                         result.getErrorCnt(),
                                                         result.getMsgType()));
            }

            log.warn("sms 전송실패: {} {}", result.getResultCode(), result.getMessage());

        } catch (JsonProcessingException ignored) {
        }

        return Optional.empty();
    }
}

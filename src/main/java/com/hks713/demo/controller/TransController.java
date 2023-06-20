package com.hks713.demo.controller;

import com.google.gson.Gson;
import com.hks713.demo.controller.dto.TransRequestDto;
import com.hks713.demo.controller.dto.TransResultDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@RestController
public class TransController {

    private static TransResultDto sendTransRequest(TransRequestDto dto, String url) {
        RestTemplate restTemplate = new RestTemplate();
        Gson gson = new Gson();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        String jsonPayload = gson.toJson(dto);

        RequestEntity<String> requestEntity = RequestEntity
                .post(URI.create(url))
                .headers(headers)
                .body(jsonPayload);

        ResponseEntity<String> response = restTemplate.exchange(requestEntity, String.class);

        if (response.getStatusCode().is2xxSuccessful()) {
            String responseBody = response.getBody();
            TransResultDto resultDto = gson.fromJson(responseBody, TransResultDto.class);
            resultDto.setStatus(response.getStatusCodeValue());
            return resultDto;
        } else {
            System.out.println("요청이 실패했습니다. 응답 코드: " + response.getStatusCode());
            return null;
        }
    }
}

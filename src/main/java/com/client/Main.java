package com.client;

import com.controller.model.JsonResponse;
import com.controller.model.UserAuthenticationData;
import com.repository.entity.Book;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserAuthenticationData userAuthenticationData = new UserAuthenticationData();
        userAuthenticationData.setLogin("user");
        userAuthenticationData.setPassword("user");
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<JsonResponse> response = restTemplate.postForEntity(RecuestUrl.URL_LOGIN,
                userAuthenticationData, JsonResponse.class);
        String token = response.getHeaders().getFirst("X-Auth-Token");

        if (token != null) {
            HttpHeaders headers = new HttpHeaders();
            headers.add("X-Auth-Token", token);
            HttpEntity<String> header = new HttpEntity<>(headers);
            ResponseEntity<Book> booksResponseEntity = restTemplate
                    .exchange(RecuestUrl.URL_BOOKS_ID, HttpMethod.GET, header, Book.class);
            System.out.println(booksResponseEntity.getBody() + "\n");
            ResponseEntity<List<Book>> listResponseEntity =
                    restTemplate.exchange(RecuestUrl.URL_BOOKS, HttpMethod.GET, header,
                            new ParameterizedTypeReference<List<Book>>() {
                            });
            System.out.println(listResponseEntity.getBody());
        }
    }

}

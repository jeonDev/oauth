package com.main.oauth.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class GithubOAuthClient {

    private final WebClient webClient;
    private final String accessTokenApiUri;
    private final String userInfoApiUri;

    public GithubOAuthClient(WebClient webClient,
                             @Value("${github.oauth-access-token}") String accessTokenApiUri,
                             @Value("${github.oauth-api-user}") String userInfoApiUri) {
        this.webClient = webClient;
        this.accessTokenApiUri = accessTokenApiUri;
        this.userInfoApiUri = userInfoApiUri;
    }

    public <T, O> O accessTokenApiCall(T request, Class<O> oClass) {
        ResponseEntity<O> responseEntity = webClient.post()
                .uri(accessTokenApiUri)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .bodyValue(request)
                .retrieve()
                .toEntity(oClass)
                .block();

        assert responseEntity != null;
        return responseEntity.getBody();
    }

    public <O> O getUserInfoApiCall(String authorization, Class<O> oClass) {
        ResponseEntity<O> responseEntity = webClient.get()
                .uri(userInfoApiUri)
                .accept(MediaType.APPLICATION_JSON)
                .headers(httpHeaders ->
                        httpHeaders.add("Authorization", authorization)
                )
                .retrieve()
                .toEntity(oClass)
                .block();

        assert responseEntity != null;
        return responseEntity.getBody();
    }
}

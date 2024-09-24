package com.main.oauth.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.main.oauth.config.properties.GithubKeyProperties;
import com.main.oauth.service.dto.GithubAccessTokenRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class GithubOauthService implements OAuthClientService {

    private final WebClient githubWebClient;
    private final GithubKeyProperties githubKeyProperties;

    public GithubOauthService(WebClient githubWebClient,
                              GithubKeyProperties githubKeyProperties
    ) {
        this.githubWebClient = githubWebClient;
        this.githubKeyProperties = githubKeyProperties;
    }

    @Override
    public String getAccessToken(String code) {

        GithubAccessTokenRequest request = GithubAccessTokenRequest.builder()
                .clientId(githubKeyProperties.getClientId())
                .clientSecretKey(githubKeyProperties.getClientSecretKey())
                .code(code)
                .build();

        ResponseEntity<String> responseEntity = githubWebClient.post()
                .uri("/login/oauth/access_token")
                .bodyValue(request)
                .retrieve()
                .toEntity(String.class)
                .block();

        assert responseEntity != null;

        return responseEntity.getBody();
    }
}

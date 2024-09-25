package com.main.oauth.service;

import com.main.oauth.config.properties.GithubKeyProperties;
import com.main.oauth.service.dto.AccessTokenResponse;
import com.main.oauth.service.dto.GithubAccessTokenRequest;
import com.main.oauth.service.dto.GithubAccessTokenResponse;
import org.springframework.http.MediaType;
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
    public AccessTokenResponse getAccessToken(String code) {

        GithubAccessTokenRequest request = GithubAccessTokenRequest.builder()
                .clientId(githubKeyProperties.getClientId())
                .clientSecret(githubKeyProperties.getClientSecret())
                .code(code)
                .build();

        ResponseEntity<GithubAccessTokenResponse> responseEntity = githubWebClient.post()
                .uri("/login/oauth/access_token")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .bodyValue(request)
                .retrieve()
                .toEntity(GithubAccessTokenResponse.class)
                .block();

        assert responseEntity != null;

        return responseEntity.getBody();
    }
}

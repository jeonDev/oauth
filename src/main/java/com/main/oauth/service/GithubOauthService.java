package com.main.oauth.service;

import com.main.oauth.client.GithubOAuthClient;
import com.main.oauth.config.properties.GithubKeyProperties;
import com.main.oauth.service.dto.AccessTokenResponse;
import com.main.oauth.service.dto.GithubAccessTokenRequest;
import com.main.oauth.service.dto.GithubAccessTokenResponse;
import com.main.oauth.service.dto.OAuthUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class GithubOauthService implements OAuthClientService {

    private final GithubOAuthClient githubOAuthClient;
    private final GithubKeyProperties githubKeyProperties;

    public GithubOauthService(GithubOAuthClient githubOAuthClient,
                              GithubKeyProperties githubKeyProperties
    ) {
        this.githubOAuthClient = githubOAuthClient;
        this.githubKeyProperties = githubKeyProperties;
    }

    @Override
    public AccessTokenResponse getAccessToken(String code) {

        GithubAccessTokenRequest request = GithubAccessTokenRequest.builder()
                .clientId(githubKeyProperties.getClientId())
                .clientSecret(githubKeyProperties.getClientSecret())
                .code(code)
                .build();

        return githubOAuthClient.accessTokenApiCall(request,
                GithubAccessTokenResponse.class);
    }

    @Override
    public OAuthUser getUserInfo(String authorization) {
        return githubOAuthClient.getUserInfoApiCall(authorization, OAuthUser.class);
    }
}

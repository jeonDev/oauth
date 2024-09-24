package com.main.oauth.service;

import org.springframework.stereotype.Service;

@Service
public class GithubOauthService implements OAuthClientService {

    @Override
    public String getAccessToken(String code) {
        // TODO: Access Token 요청
        return null;
    }
}

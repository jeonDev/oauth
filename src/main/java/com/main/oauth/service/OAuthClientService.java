package com.main.oauth.service;

public interface OAuthClientService {

    String getAccessToken(String code);
}

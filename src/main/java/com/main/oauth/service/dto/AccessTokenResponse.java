package com.main.oauth.service.dto;

public interface AccessTokenResponse {
    String getAccessToken();
    String getTokenType();
    String getScope();
}

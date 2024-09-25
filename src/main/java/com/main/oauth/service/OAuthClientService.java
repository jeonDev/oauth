package com.main.oauth.service;

import com.main.oauth.service.dto.AccessTokenResponse;

public interface OAuthClientService {

    AccessTokenResponse getAccessToken(String code);
}

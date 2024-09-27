package com.main.oauth.service;

import com.main.oauth.service.dto.AccessTokenResponse;
import com.main.oauth.service.dto.OAuthUser;

public interface OAuthClientService {

    AccessTokenResponse getAccessToken(String code);
    OAuthUser getUserInfo(String authorization);
}

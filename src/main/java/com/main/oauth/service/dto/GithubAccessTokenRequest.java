package com.main.oauth.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class GithubAccessTokenRequest {
    private String clientId;
    private String clientSecretKey;
    private String code;
}

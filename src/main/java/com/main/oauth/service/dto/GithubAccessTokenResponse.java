package com.main.oauth.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GithubAccessTokenResponse implements AccessTokenResponse {
    @JsonProperty("access_token")
    private String accessToken;
    @JsonProperty("token_type")
    private String tokenType;
    @JsonProperty("scope")
    private String scope;


    @Override
    public String getAccessToken() {
        return this.accessToken;
    }

    @Override
    public String getTokenType() {
        return this.tokenType;
    }

    @Override
    public String getScope() {
        return this.scope;
    }
}

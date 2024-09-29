package com.main.oauth.endpoint;

import com.main.oauth.service.OAuthClientService;
import com.main.oauth.service.dto.AccessTokenResponse;
import com.main.oauth.service.dto.OAuthUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class OauthController {

    private final OAuthClientService githubOauthService;

    public OauthController(OAuthClientService githubOauthService) {
        this.githubOauthService = githubOauthService;
    }

    @GetMapping("/v1/oauth/github/callback")
    public ResponseEntity<AccessTokenResponse> githubOauth(@RequestParam("code") String code) {
        log.info("callback code : {}", code);

        AccessTokenResponse response = githubOauthService.getAccessToken(code);
        log.info(response.getAccessToken());

        return ResponseEntity.ok(response);
    }

    @GetMapping("/v1/oauth/github/userInfo")
    public ResponseEntity<OAuthUser> getGithubOAuthUserInfo(@RequestHeader("Authorization") String authorization) {
        log.info("Github OAuth Authorization : {}", authorization);

        OAuthUser response = githubOauthService.getUserInfo(authorization);
        return ResponseEntity.ok(response);
    }
}

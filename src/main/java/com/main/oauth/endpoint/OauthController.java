package com.main.oauth.endpoint;

import com.main.oauth.service.OAuthClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class OauthController {

    private final OAuthClientService githubOauthService;

    public OauthController(OAuthClientService githubOauthService) {
        this.githubOauthService = githubOauthService;
    }

    @GetMapping("/oauth/github/callback")
    public void githubOauth(@RequestParam("code") String code) {
        log.info("callback code : {}", code);

        String accessToken = githubOauthService.getAccessToken(code);
        log.info(accessToken);
        return;
    }
}

package com.main.oauth.endpoint;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class OauthController {

    @GetMapping("/oauth/github/callback")
    public void githubOauth(@RequestParam("code") String code) {
        log.info("callback code : {}", code);
        return;
    }
}

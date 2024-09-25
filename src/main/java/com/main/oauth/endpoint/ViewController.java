package com.main.oauth.endpoint;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping("/view/home")
    public String home() {
        return "/index.html";
    }

    @GetMapping("/oauth/github/callback")
    public String githubCallback() {
        return "/githubOauthCallback.html";
    }
}

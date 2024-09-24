package com.main.oauth.config.properties;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Getter
@PropertySource("classpath:/properties/github-key.yml")
@Component
public class GithubKeyProperties {
    @Value("${client_id}")
    private String clientId;
    @Value("${client_secret_key}")
    private String clientSecretKey;
}

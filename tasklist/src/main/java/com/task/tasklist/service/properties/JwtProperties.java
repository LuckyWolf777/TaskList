package com.task.tasklist.service.properties;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Data
//@ConfigurationProperties (prefix = "security.jwt")
public class JwtProperties {
//    private String secret;
//    private long access;
//    private long refresh;


    @Value("${security.jwt.secret}")
    private String secret;

    @Value("${security.jwt.access}")
    private long access;

    @Value("${security.jwt.refresh}")
    private long refresh;

    // Геттеры и сеттеры
}




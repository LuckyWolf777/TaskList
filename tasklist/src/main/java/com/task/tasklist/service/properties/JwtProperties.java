package com.task.tasklist.service.properties;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
public class JwtProperties {

    @Value("${security.jwt.secret}")
    private String secret;
    @Value("${security.jwt.access}")
    private long access;
    @Value("${security.jwt.refresh}")
    private long refresh;

}
package com.task.tasklist.service;

import com.task.tasklist.web.dto.auth.JwtRequest;
import com.task.tasklist.web.dto.auth.JwtResponse;

public interface AuthService {

    JwtResponse login (JwtRequest loginRequest);
    JwtResponse refresh(String refreshToken);
}
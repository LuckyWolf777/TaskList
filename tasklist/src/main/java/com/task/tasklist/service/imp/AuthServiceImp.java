package com.task.tasklist.service.imp;

import com.task.tasklist.service.AuthService;
import com.task.tasklist.web.dto.auth.JwtRequest;
import com.task.tasklist.web.dto.auth.JwtResponse;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImp implements AuthService {

    @Override
    public JwtResponse login(JwtRequest loginRequest) {
        return null;
    }

    @Override
    public JwtResponse refresh(String refreshToken) {
        return null;
    }
}

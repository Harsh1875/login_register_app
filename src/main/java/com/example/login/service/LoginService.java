package com.example.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.login.exchange.LoginRequest;
import com.example.login.repositoryservice.RepoService;

@Service
public class LoginService {

    @Autowired
    private RepoService repoService;

    public String validateUesrLogin(LoginRequest loginRequest) {

        String response = repoService.validateUesrLogin(loginRequest);

        return response;
    }
    
}

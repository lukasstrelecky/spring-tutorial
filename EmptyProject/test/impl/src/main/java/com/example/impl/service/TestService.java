package com.example.impl.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    @Value("${environment.name}")
    private String environmentName;

    public TestService() {
    }

    public String getEnvironment() {
        return environmentName;
    }
}

package com.example.impl.controller;

import com.example.impl.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TestController {

    @Autowired
    private ApiService apiService;

    public TestController(ApiService apiService) {
        this.apiService = apiService;
    }

    @GetMapping(path = "/web-client/data", produces = "application/json")
    public String getDataFromRemoteApi() {
        return apiService.getDataFromRemoteApi();
    }
}

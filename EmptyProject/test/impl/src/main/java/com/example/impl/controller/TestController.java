package com.example.impl.controller;

import com.example.impl.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "/${ENDPOINT}")
public class TestController {

    @Autowired
    private TestService testService;

    public TestController(TestService testService) {
        this.testService = testService;
    }

    @GetMapping(path = "/environment", produces = "application/json")
    public String getEnvironment() {
        return testService.getEnvironment();
    }
}

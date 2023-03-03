package com.example.test.controller;

import com.example.test.mybatis.model.Person;
import com.example.test.service.TestService;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@CommonsLog
@RestController
public class TestController {

    @Autowired
    private TestService testService;

    public TestController(TestService testService) {
        this.testService = testService;
    }

    @GetMapping(path = "/person", produces = "application/json")
    public List<Person> findAllPerson() {
        return testService.findAllPerson();
    }
}

package com.example.test.service;

import com.example.test.mybatis.PersonMapper;
import com.example.test.mybatis.model.Person;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {

    private final SqlSessionFactory testSessionFactory;

    public TestService(@Qualifier("TestSessionFactory") SqlSessionFactory testSessionFactory) {
        this.testSessionFactory = testSessionFactory;
    }

    public List<Person> findAllPerson() {
        try (SqlSession session = testSessionFactory.openSession()) {
            return session.getMapper(PersonMapper.class).findAllPerson();
        }
    }
}

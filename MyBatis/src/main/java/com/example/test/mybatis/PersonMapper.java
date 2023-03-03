package com.example.test.mybatis;

import com.example.test.mybatis.model.Person;

import java.util.List;

public interface PersonMapper {

    List<Person> findAllPerson();
}

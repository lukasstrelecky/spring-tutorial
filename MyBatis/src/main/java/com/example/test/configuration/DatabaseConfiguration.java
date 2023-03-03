package com.example.test.configuration;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.example.test.mybatis", sqlSessionTemplateRef = "TestSessionTemplate")
public class DatabaseConfiguration extends PersistenceConfigBase {


    public DatabaseConfiguration(Environment env) {
        super(env, "db.test");
    }

    @Bean
    public DataSource TestDataSource() {
        return dataSource();
    }

    @Bean
    public SqlSessionFactory TestSessionFactory(@Qualifier("TestDataSource") DataSource dataSource) throws Exception {
        return sessionFactory(dataSource);
    }

    @Bean
    public SqlSessionTemplate TestSessionTemplate(@Qualifier("TestSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}


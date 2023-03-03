package com.example.test.configuration;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

public class PersistenceConfigBase {

    private final Environment env;
    private final String propPrefix;

    public PersistenceConfigBase(Environment env, String propPrefix) {
        this.env = env;
        this.propPrefix = propPrefix;
    }

    protected DataSource dataSource() {
        final DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl(env.getProperty(propPrefix + ".url"));
        dataSource.setSchema(env.getProperty(propPrefix + ".schema"));
        dataSource.setUsername(env.getProperty(propPrefix + ".username"));
        dataSource.setPassword(env.getProperty(propPrefix + ".password"));
        return dataSource;
    }


    protected SqlSessionFactory sessionFactory(DataSource dataSource) throws Exception {
        final SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        return bean.getObject();
    }


}


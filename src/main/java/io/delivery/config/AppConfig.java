package io.delivery.config;


import io.delivery.model.CreateTable;
import io.delivery.model.Delete;
import io.delivery.model.InsertInTable;
import io.delivery.model.UpdateTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.PreparedStatement;


@Configuration
@PropertySource(value = {"classpath:util.properties"})
public class AppConfig {
    @Autowired
    private Environment environment;

    @Bean
    public DriverManagerDataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getProperty("jdbc.postgressql.driverClass"));
        dataSource.setUrl(environment.getProperty("jdbc.postgressql.url"));
        dataSource.setUsername(environment.getProperty("jdbc.postgressql.username"));
        dataSource.setPassword(environment.getProperty("jdbc.postgressql.password"));
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource());
        return jdbcTemplate;
    }

    @Bean
    public CreateTable createTable() {
        return new CreateTable(jdbcTemplate());
    }

    @Bean
    public InsertInTable insertInTable() {
        return new InsertInTable(jdbcTemplate());
    }

    @Bean
    public UpdateTable updateTable() {
        return new UpdateTable(jdbcTemplate());
    }
    @Bean
    public Delete delete(){
        return new Delete(jdbcTemplate());
    }
}


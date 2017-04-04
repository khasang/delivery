package io.delivery.config;

import io.delivery.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@PropertySource(value = {"classpath:util.properties"})
public class AppConfig {
    @Autowired
    private Environment environment;

    @Bean
    public DriverManagerDataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getProperty("jdbc.postgresql.driverClass"));
        dataSource.setUrl(environment.getProperty("jdbc.postgresql.url"));
        dataSource.setUsername(environment.getProperty("jdbc.postgresql.username"));
        dataSource.setPassword(environment.getProperty("jdbc.postgresql.password"));
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource());
        return jdbcTemplate;
    }

    @Bean
    public TableCreator tableCreator(){
        return new TableCreator(jdbcTemplate());
    }

    @Bean
    public TableInserter tableInserter(){
        return new TableInserter(jdbcTemplate());
    }

    @Bean
    public TableUpdater tableUpdater(){
        return new TableUpdater(jdbcTemplate());
    }

    @Bean
    public TableDeleter tableDeleter(){
        return new TableDeleter(jdbcTemplate());
    }

    @Bean
    public Answer answer() {
        return new Answer();
    }

//    @Bean
//    public CreateTable createTable(){
//        return new CreateTableImpl("asd");
//    }
}

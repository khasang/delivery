package io.delivery.config;


import io.delivery.model.*;
import io.delivery.model.impl.TableCreatorImpl;
import io.delivery.service.CreateTable;
import io.delivery.service.impl.CreateTableimpl;
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
    public Answer answer(){
        return new Answer();
    }

    @Bean
    public TableCreator tableCreator() {
        return new TableCreatorImpl(jdbcTemplate());
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

    @Bean
    public CreateTable createTable(){
        return new CreateTableimpl("dfsdf");
    }


}


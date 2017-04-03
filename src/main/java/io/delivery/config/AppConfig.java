package io.delivery.config;

import io.delivery.model.*;
import io.delivery.model.impl.*;
import io.delivery.service.*;
import io.delivery.service.impl.*;
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
        return new TableCreatorImpl(jdbcTemplate());
    }

    @Bean
    public CreateTable createTable(){
        return new CreateTableImpl("asd");
    }

    @Bean
    public TableInsertor tableInsertor(){
        return new TableInsertorImpl(jdbcTemplate());
    }

    @Bean
    public InsertTable insertTable(){
        return new InsertTableImpl("abybe");
    }

    @Bean
    public TableUpdated tableUpdated(){
        return new TableUpdatedImpl(jdbcTemplate());
    }

    @Bean
    public UpdateTable updateTable(){
        return new UpdateTableImpl("asdr");
    }

    @Bean
    public TableDeleted tableDeleted(){
        return new TableDeletedImpl(jdbcTemplate());
    }

    @Bean
    public DeleteTable deleteTable(){
        return new DeleteTableImpl("abybe");
    }

    @Bean
    public TableInnerSelecter tableInnerSelecter(){
        return new TableInnerSelecterImpl(jdbcTemplate());
    }

    @Bean
    public InnerSelectTable innerSelectTable(){
        return new InnerSelectTableImpl ("abybe3");
    }

    @Bean
    public Answer answer(){
        return new Answer();
    }
}

package io.delivery.config;

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
    public CreateTable createTable(){
        return new CreateTableImpl(jdbcTemplate());
    }

    @Bean
    public InsertUser insertUser() {
        return new InsertUserImpl(jdbcTemplate());
    }

    @Bean
    public UpdateTable updateTable(){
        return new UpdateTableImpl(jdbcTemplate());
    }

    @Bean
    public SelectTable selectTable() {
        return new SelectTableImpl(jdbcTemplate());
    }

    @Bean
    public PreparedSQL preparedSQL() {
        return new PreparedSQLImpl(jdbcTemplate());
    }

    @Bean
    public DumpDB dumpDB() {
        return new DumpDbImpl();
    }

    @Bean
    public Test test() {
        return new TestImpl("test");
    }
}

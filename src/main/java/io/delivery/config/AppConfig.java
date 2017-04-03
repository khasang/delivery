package io.delivery.config;

import io.delivery.model.Company;
import io.delivery.service.CreateTable;
import io.delivery.service.InsertItem;
import io.delivery.service.Prepared;
import io.delivery.service.impl.CreateTableImpl;
import io.delivery.service.impl.InsertItemImpl;
import io.delivery.service.impl.PreparedImpl;
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
    public CreateTable createTable() {
        return new CreateTableImpl(jdbcTemplate());
    }

    @Bean
    public Company company() {
        Company company = new Company();
        company.setId(1);
        company.setName("Yandex");
        company.setSize(1000);
        return company;
    }

    @Bean
    public InsertItem insertItem() {
        return new InsertItemImpl(jdbcTemplate(), company());
    }

    @Bean
    public Prepared prepared() {
        return new PreparedImpl(jdbcTemplate(), company());
    }
}

package io.delivery.config;

import io.delivery.dao.CustomerDao;
import io.delivery.dao.DocumentDao;
import io.delivery.dao.impl.CustomerDaoImpl;
import io.delivery.dao.impl.DocumentDaoImpl;
import io.delivery.entity.Customer;
import io.delivery.entity.Document;
import io.delivery.model.Answer;
import io.delivery.model.TableCreator;
import io.delivery.model.impl.TableCreatorImpl;
import io.delivery.service.CreateTable;
import io.delivery.service.impl.CreateTableImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;

@Configuration
@PropertySource(value = {"classpath:util.properties"})
@PropertySource(value = {"classpath:auth.properties"})
public class AppConfig {
    @Autowired
    private Environment environment;

    @Bean
    public UserDetailsService userDetailsService() {
        JdbcDaoImpl jdbcImpl = new JdbcDaoImpl();
        jdbcImpl.setDataSource(dataSource());
        jdbcImpl.setUsersByUsernameQuery(environment.getRequiredProperty("usersByQuery"));
        jdbcImpl.setAuthoritiesByUsernameQuery(environment.getRequiredProperty("rolesByQuery"));
        return jdbcImpl;
    }

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
    public TableCreator tableCreator() {
        return new TableCreatorImpl(jdbcTemplate());
    }

    @Bean
    public CreateTable createTable() {
        return new CreateTableImpl("asd");
    }

    @Bean
    public Answer answer() {
        return new Answer();
    }

    @Bean
    DocumentDao documentDao() {
        return new DocumentDaoImpl(Document.class);
    }

    @Bean
    CustomerDao customerDao() {
        return new CustomerDaoImpl(Customer.class);
    }
}

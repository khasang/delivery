package io.delivery.config;

import io.delivery.dao.DocumentDao;
import io.delivery.dao.OrderDao;
import io.delivery.dao.impl.DocumentDaoImpl;
import io.delivery.dao.impl.OrderDaoImpl;
import io.delivery.entity.BasketUnit;
import io.delivery.entity.Document;
import io.delivery.entity.Order;
import io.delivery.model.Company;
import io.delivery.service.CreateTable;
import io.delivery.service.InsertItem;
import io.delivery.service.PgDump;
import io.delivery.service.Prepared;
import io.delivery.service.impl.CreateTableImpl;
import io.delivery.service.impl.InsertItemImpl;
import io.delivery.service.impl.PgDumpImpl;
import io.delivery.service.impl.PreparedImpl;
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
    public CreateTable createTable() {
        return new CreateTableImpl(jdbcTemplate());
    }

    @Bean
    public Company company() {
        Company company = new Company();
        company.setId(1);
        company.setName("Yandex" + (int) (Math.random()*10));
        company.setSize((int) (Math.random()*100));
        return company;
    }

    @Bean
    public InsertItem insertItem() {
        return new InsertItemImpl(jdbcTemplate());
    }

    @Bean
    public Prepared prepared() {
        return new PreparedImpl(jdbcTemplate(), company());
    }

    @Bean
    public PgDump pgDump() {
        return new PgDumpImpl(environment);
    }

    @Bean
    DocumentDao documentDao() {
        return new DocumentDaoImpl(Document.class);
    }

    @Bean
    OrderDao orderDao() {
        return new OrderDaoImpl(Order.class);
    }

    @Bean
    BasketUnit basketUnit() {
        return new BasketUnit();
    }
}


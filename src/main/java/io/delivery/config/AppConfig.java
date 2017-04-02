package io.delivery.config;

import io.delivery.model.TableCreator;
import io.delivery.service.QueryCreator;
import io.delivery.service.impl.PreparedStatementQuery;
import io.delivery.service.impl.QueryCreatorImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
    public Connection connection() {
        Connection connection = null;
        try {
            connection = dataSource().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    @Bean
    public PreparedStatement preparedStatement() {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection().prepareStatement("UPDATE comanies Set name = ? WHERE id = ?");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return preparedStatement;
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
    public QueryCreator queryCreator(){
        return new QueryCreatorImpl(jdbcTemplate());
    }

    @Bean
    public PreparedStatementQuery preparedStatementQuery(){
        return new PreparedStatementQuery(preparedStatement());
    }
}

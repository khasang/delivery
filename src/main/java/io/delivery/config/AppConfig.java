package io.delivery.config;

import io.delivery.model.TableCreator;
import io.delivery.model.TableDeletor;
import io.delivery.model.TableInsertor;
import io.delivery.model.TableUpdater;
import io.delivery.service.CreateTable;
import io.delivery.service.impl.CreateTableImpl;
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
    public CreateTable createTable(){
        return new CreateTableImpl("asd");
    }

    @Bean
    public TableInsertor tableInsertor(){ return new TableInsertor(jdbcTemplate()); }

    @Bean
    public TableUpdater tableUpdater(){ return new TableUpdater(jdbcTemplate()); }

    @Bean
    public TableDeletor tableDeletor(){ return new TableDeletor(jdbcTemplate()); }
}

package io.delivery.model.impl;

import io.delivery.model.CompanyDAO;
import io.delivery.service.DbBackup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Repository
public class CompanyDAOImpl implements CompanyDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public String createCompanyTable() {
        Resource companiesCreateTableScript = new ClassPathResource("Companies_CreateTable.sql");
        ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator(companiesCreateTableScript);

        databasePopulator.execute(jdbcTemplate.getDataSource());
        return "table created";
    }

    public String createCompany(String name) {
        return "created";
    }
}

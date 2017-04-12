package io.delivery.model.impl;

import io.delivery.model.CompanyDAO;
import io.delivery.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class CompanyDAOImpl implements CompanyDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private DocumentService documentService;

    @Autowired
    private DataSource dataSource;



    public String createDbTable() {
        Resource companiesCreateTableScript = new ClassPathResource("Companies_CreateTable.sql");
        ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator(companiesCreateTableScript);

        databasePopulator.execute(jdbcTemplate.getDataSource());
        return "table created";
    }

    public String createCompany(String name) {
        jdbcTemplate.update("INSERT INTO Companies (name) VALUES (?)", name);
        return "created";
    }

    public String deleteCompany(String name) {
        jdbcTemplate.update("DELETE FROM Companies WHERE name = ?", name);
        return "deleted";
    }

    public String updateCompany(String name, String newName) {
        jdbcTemplate.update("UPDATE Companies SET name = ? WHERE name = ?", newName, name);
        return "updated";
    }
}

package io.delivery.service.impl;

import io.delivery.model.Company;
import io.delivery.service.InsertItem;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertItemImpl implements InsertItem {
    private JdbcTemplate jdbcTemplate;
    private Company company;
    private String query;

    public InsertItemImpl(JdbcTemplate jdbcTemplate, Company company) {
        this.jdbcTemplate = jdbcTemplate;
        this.company = company;
    }

    public void setQuery(String query) {
        this.query = query;
    }


    @Override
    public String insertItem() {
        query = ("INSERT INTO companies " +
                "VALUES (1,'Google',2000);");
        jdbcTemplate.execute(query);
        return "Insert done";
    }
}

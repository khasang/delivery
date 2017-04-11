package io.delivery.service.impl;

import io.delivery.model.Company;
import io.delivery.service.InsertItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class InsertItemImpl implements InsertItem {
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private Company company;
    private String query;

    public InsertItemImpl() {
    }

    public InsertItemImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    @Override
    public String insertItem() {
        query = "INSERT INTO companies(name, size) VALUES" + "(\'" + company.getName() + "\'," + company.getSize() + ");";
        jdbcTemplate.execute(query);
        return "Insert done";
    }
}

package io.delivery.service.impl;

import io.delivery.service.CreateTable;
import org.springframework.jdbc.core.JdbcTemplate;

public class CreateTableImpl implements CreateTable {
    private JdbcTemplate jdbcTemplate;
    private String query;

    public CreateTableImpl() {
    }

    public CreateTableImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    @Override
    public String createCompany() {
        String preQuery = "DROP TABLE IF EXISTS companies";

        query = "CREATE TABLE companies (\n" +
                "    id int CONSTRAINT firstkey PRIMARY KEY,\n" +
                "    name varchar(255) NOT NULL,\n" +
                "    size integer NOT NULL\n" +
                ");";
        jdbcTemplate.execute(preQuery);
        jdbcTemplate.execute(query);
        return "table created";
    }
}

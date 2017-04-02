package io.delivery.model;

import org.springframework.jdbc.core.JdbcTemplate;

public class CreateTable {
    private JdbcTemplate jdbcTemplate;

    public CreateTable() {
    }

    public CreateTable(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public String createCompany() {
        String preQuery = "DROP TABLE IF EXISTS test";
        String query = "CREATE TABLE test (name varchar(80))";

        jdbcTemplate.execute(preQuery);
        jdbcTemplate.execute(query);
        return "table created";
    }
}

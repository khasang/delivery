package io.delivery.model;

import org.springframework.jdbc.core.JdbcTemplate;

public class InsertInTable {
    private JdbcTemplate jdbcTemplate;


    public InsertInTable() {
    }

    public InsertInTable(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public String createRow(){
        String query = "INSERT INTO companies VALUES (3, 'Yahoo')";
        jdbcTemplate.execute(query);
        return "insert done";
    }

}

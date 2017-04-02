package io.delivery.model;

import org.springframework.jdbc.core.JdbcTemplate;

public class TableDeleter {
    private JdbcTemplate jdbcTemplate;

    public TableDeleter() {
    }

    public TableDeleter(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public String deleteValue(){
        String query = ("DELETE FROM companies WHERE id = '1';");
        jdbcTemplate.execute(query);
        return "table deleted";
    }
}
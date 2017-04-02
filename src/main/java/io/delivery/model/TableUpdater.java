package io.delivery.model;

import org.springframework.jdbc.core.JdbcTemplate;

public class TableUpdater {
    private JdbcTemplate jdbcTemplate;

    public TableUpdater() {
    }

    public TableUpdater(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public String updateValue(){
        String query = ("UPDATE companies SET company = 'YAHOO' WHERE id = '1';");
        jdbcTemplate.execute(query);
        return "table updated";
    }
}
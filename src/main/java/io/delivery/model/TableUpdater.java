package io.delivery.model;

import org.springframework.jdbc.core.JdbcTemplate;

public class TableUpdater {
    private JdbcTemplate jdbcTemplate;

    public TableUpdater(){}

    public TableUpdater(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public String updateDataInTable(String query){
        jdbcTemplate.execute(query);
        return "Data updated";
    }
}

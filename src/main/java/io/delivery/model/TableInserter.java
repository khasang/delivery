package io.delivery.model;

import org.springframework.jdbc.core.JdbcTemplate;

public class TableInserter {
    private JdbcTemplate jdbcTemplate;

    public TableInserter() {
    }

    public TableInserter(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public String insertValue(){
        String query = ("INSERT INTO companies (id, company)VALUES ('1', 'GOOGLE');");
        jdbcTemplate.execute(query);
        return "table inserted";
    }
}
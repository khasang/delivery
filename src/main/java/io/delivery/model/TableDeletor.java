package io.delivery.model;

import org.springframework.jdbc.core.JdbcTemplate;

public class TableDeletor {
    private JdbcTemplate jdbcTemplate;

    public TableDeletor(){}

    public TableDeletor(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public String deleteExistingTable(){
        String query = "DROP TABLE IF EXISTS companies";
        jdbcTemplate.execute(query);
        return "companies DELETED";
    }
}

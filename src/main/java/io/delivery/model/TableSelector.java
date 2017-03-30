package io.delivery.model;

import org.springframework.jdbc.core.JdbcTemplate;

public class TableSelector {
    private JdbcTemplate jdbcTemplate;

    public TableSelector(){}

    public TableSelector(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate=jdbcTemplate;
    }

    public String selectDataFromTable(){
        String query = "SELECT * FROM users WHERE ID='6'";
        jdbcTemplate.execute(query);
        return "Data selected";
    }
}

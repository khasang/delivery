package io.delivery.model;


import org.springframework.jdbc.core.JdbcTemplate;

public class TableInsertor {
    private JdbcTemplate jdbcTemplate;

    public TableInsertor(){}

    public TableInsertor(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public String insertNewDataIntoTable(String query){
        jdbcTemplate.execute(query);
        return "Data inserted";
    }
}

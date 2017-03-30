package io.delivery.model;

import org.springframework.jdbc.core.JdbcTemplate;

public class TableUpdater {
    private JdbcTemplate jdbcTemplate;

    public TableUpdater(){}

    public TableUpdater(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public String updateDataInTable(){
        jdbcTemplate.execute("update companies set code='22222', title='Title_2', did='22' where code='11111'");
        return "Data updated";
    }
}

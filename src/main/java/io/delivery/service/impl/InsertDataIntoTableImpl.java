package io.delivery.service.impl;

import io.delivery.service.InsertDataIntoTable;
import org.springframework.jdbc.core.JdbcTemplate;

public class InsertDataIntoTableImpl implements InsertDataIntoTable {
    private JdbcTemplate jdbcTemplate;

    public InsertDataIntoTableImpl(){

    }

    public InsertDataIntoTableImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public String insertDataIntoTable(){
        String query = "insert into companies (1, Title_1, 10, , ok, )";
        jdbcTemplate.execute(query);
        return "Data inserted";
    }
}

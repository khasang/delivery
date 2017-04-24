package io.delivery.service.impl;

import io.delivery.service.UpdateTable;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Created by NortT on 01.04.2017.
 */
public class UpdateTableImpl implements UpdateTable {
    private JdbcTemplate jdbcTemplate;

    public UpdateTableImpl(){}

    public UpdateTableImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public String updateTable() {
        String query = "UPDATE users "+
                "SET company_name = 0 WHERE company_name<=10";

        jdbcTemplate.execute(query);

        return "Table was updated";
    }
}

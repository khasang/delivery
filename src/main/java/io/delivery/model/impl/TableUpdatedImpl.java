package io.delivery.model.impl;


import io.delivery.model.TableUpdated;
import org.springframework.jdbc.core.JdbcTemplate;

public class TableUpdatedImpl implements TableUpdated{
    private JdbcTemplate jdbcTemplate;

    public TableUpdatedImpl() {
    }

    public TableUpdatedImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public String updateCompany(){
        String query = ("UPDATE companies set title = 'Petya' WHERE did = 2");
        jdbcTemplate.execute(query);
        return "table updated";
    }


}

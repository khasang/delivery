package io.delivery.model.impl;

import io.delivery.model.TableDeleted;
import org.springframework.jdbc.core.JdbcTemplate;


public class TableDeletedImpl implements TableDeleted {
    private JdbcTemplate jdbcTemplate;

    public TableDeletedImpl() {
    }

    public TableDeletedImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public String deleteCompany(){
        String query = ("DELETE FROM companies WHERE did = 2");

        jdbcTemplate.execute(query);

        return "table deleted";
    }
}

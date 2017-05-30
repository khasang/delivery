package io.delivery.service.impl;

import io.delivery.service.SelectTable;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Created by NortT on 01.04.2017.
 */
public class SelectTableImpl implements SelectTable {
    private JdbcTemplate jdbcTemplate;

    public SelectTableImpl(){}

    public SelectTableImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public String selectTable() {
        String query = "SELECT id, name, CASE " +
                " WHEN ((id>=50) and (id<60)) THEN 'fifty'" +
                " WHEN ((id>=60) and (id<70)) THEN 'sixty'" +
                " WHEN ((id>=70) and (id<80)) THEN 'seventy'" +
                " END FROM Users "+
                " WHERE id > 50";
        jdbcTemplate.execute(query);
        return "Data were selected";
    }
}

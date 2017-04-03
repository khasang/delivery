package io.delivery.model.impl;

import io.delivery.model.TableInnerSelecter;
import org.springframework.jdbc.core.JdbcTemplate;


public class TableInnerSelecterImpl implements TableInnerSelecter{
    private JdbcTemplate jdbcTemplate;

    public TableInnerSelecterImpl() {
    }

    public TableInnerSelecterImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public String innerCompany(){
        String query = ("SELECT title FROM companies where did IN (SELECT  did FROM users where title ='Vasya')");

        jdbcTemplate.execute(query);

        return "table innerSelected";
    }
}

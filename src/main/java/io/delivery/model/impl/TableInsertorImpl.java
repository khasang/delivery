package io.delivery.model.impl;


import io.delivery.model.TableInsertor;
import org.springframework.jdbc.core.JdbcTemplate;

public class TableInsertorImpl implements TableInsertor{
    private JdbcTemplate jdbcTemplate;

    public TableInsertorImpl() {
    }

    public TableInsertorImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public String insertCompany(){
        String preQuery = ("INSERT INTO companies (code, title, did) VALUES (1, 'spider-man', 1)");
        String query = ("INSERT INTO companies (code, title, did) VALUES (2, 'Vasya', 2)");
        jdbcTemplate.execute(preQuery);
        jdbcTemplate.execute(query);

        return "table inserted";
    }
}

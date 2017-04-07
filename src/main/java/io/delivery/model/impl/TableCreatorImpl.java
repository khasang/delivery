package io.delivery.model.impl;

import io.delivery.model.TableCreator;
import org.springframework.jdbc.core.JdbcTemplate;

public class TableCreatorImpl  implements TableCreator{
    private JdbcTemplate jdbcTemplate;

    public TableCreatorImpl() {
    }

    public TableCreatorImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public String createCompany() {
        String preQuery = "DROP TABLE IF EXISTS companies";
        String query = ("CREATE TABLE companies (\n" +
                "    id         integer PRIMARY KEY,\n" +
                "    name       varchar(40) NOT NULL\n" +
                ");");
        jdbcTemplate.execute(preQuery);
        jdbcTemplate.execute(query);
        return "table created";
    }
}

package io.delivery.service.impl;

import io.delivery.service.CreateTable;
import org.springframework.jdbc.core.JdbcTemplate;

public class CreateTableimpl  implements CreateTable {
    private JdbcTemplate jdbcTemplate;
    private  String query;

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public CreateTableimpl(String query) {
        this.query = query;
    }

    public CreateTableimpl() {
    }

    @Override
    public String createCompany() {
        String preQuery = "DROP TABLE IF EXISTS companies";
        String query = ("CREATE TABLE companies (\n" +
                "    id         integer PRIMARY KEY,\n" +
                "    name       varchar(40) NOT NULL\n" +
                ");");
        jdbcTemplate.execute(preQuery);
        jdbcTemplate.execute(query);
        return query;
    }
}

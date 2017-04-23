package io.delivery.service.impl;

import io.delivery.model.Answer;
import io.delivery.service.CreateTable;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

public class CreateTableImpl implements CreateTable {
    private static final Logger LOG = Logger.getLogger(CreateTableImpl.class);

    @Autowired
    private Answer answer;

    private String query;

    public CreateTableImpl(String query) {
        this.query = query;
    }

    public CreateTableImpl() {
    }

    public String getQuery() {

    private JdbcTemplate jdbcTemplate;

    public CreateTableImpl(){
    }

    public CreateTableImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public String createCompany(){
        String preQuery = "DROP TABLE IF EXISTS companies";
        String query = ("CREATE TABLE companies (\n" +
                "    code        char(5) CONSTRAINT firstkey PRIMARY KEY,\n" +
                "    title       varchar(40) NOT NULL,\n" +
                "    did         integer NOT NULL,\n" +
                "    date_prod   date,\n" +
                "    kind        varchar(10),\n" +
                "    len         interval hour to minute\n" +
                ");");
        jdbcTemplate.execute(preQuery);
        jdbcTemplate.execute(query);
        return "table created";
    }
}

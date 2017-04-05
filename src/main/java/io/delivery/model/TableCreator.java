package io.delivery.model;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

public class TableCreator {
    private JdbcTemplate jdbcTemplate;
    private final static Logger LOG = Logger.getLogger(TableCreator.class);

    public TableCreator() {
    }

    public TableCreator(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public String createCompany(){
        String preQuery = "DROP TABLE IF EXISTS companies";

//        String query = ("CREATE TABLE companies (\n" +
//                "    code        char(5) CONSTRAINT firstkey PRIMARY KEY,\n" +
//                "    title       varchar(40) NOT NULL,\n" +
//                "    did         integer NOT NULL,\n" +
//                "    date_prod   date,\n" +
//                "    kind        varchar(10),\n" +
//                "    len         interval hour to minute\n" +
//                ");");

        String query = ("CREATE TABLE companies (\n" +
                "    id             char(5) CONSTRAINT firstkey PRIMARY KEY,\n" +
                "    company     varchar(40) NOT NULL\n" +
                ");");

        try {
            jdbcTemplate.execute(preQuery);
            jdbcTemplate.execute(query);
        } catch (DataAccessException e) {
            e.printStackTrace();
            LOG.error("ERROR: " + e.getMessage());
        }
        return "table created";
    }
}

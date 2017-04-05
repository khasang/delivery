package io.delivery.service.impl;

import io.delivery.service.TableDAO;
import org.springframework.jdbc.core.JdbcTemplate;


public class TableDAOImpl implements TableDAO {
    private JdbcTemplate jdbcTemplate;

    public TableDAOImpl() {
    }

    public TableDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public String createCompany() {
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

    @Override
    public String insertCompany() {
        String preQuery = ("INSERT INTO companies (code, title, did) VALUES (1, 'spider-man', 1)");
        String query = ("INSERT INTO companies (code, title, did) VALUES (2, 'Vasya', 2)");
        jdbcTemplate.execute(preQuery);
        jdbcTemplate.execute(query);

        return "table inserted";
    }

    @Override
    public String updateCompany() {
        String query = ("UPDATE companies set title = 'Petya' WHERE did = 2");
        jdbcTemplate.execute(query);

        return "table updated";
    }

    @Override
    public String deleteCompany() {
        String query = ("DELETE FROM companies WHERE did = 2");
        jdbcTemplate.execute(query);

        return "table deleted";
    }

    @Override
    public String userCompany() {
//        String query = ("DELETE FROM companies WHERE did = 2");
//        jdbcTemplate.execute(query);

        return "Welcome, user !";
    }
}

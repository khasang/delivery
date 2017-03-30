package io.delivery.service.impl;

import io.delivery.model.Company;
import io.delivery.service.DAO;
import org.springframework.jdbc.core.JdbcTemplate;

import java.io.IOException;
import java.sql.PreparedStatement;

public class CompanyDAO implements DAO {
    private Company company;
    private JdbcTemplate jdbcOperations;

    public CompanyDAO() {
    }

    public CompanyDAO(JdbcTemplate jdbcOperations, Company company) {
        this.jdbcOperations = jdbcOperations;
        this.company = company;
    }

    @Override
    public String createTable() {
        String preQuery = "DROP TABLE IF EXISTS companies";
        String query = ("CREATE TABLE companies (\n" +
                "    id        INT, \n" +
                "    title     varchar(40) NOT NULL,\n" +
                "    PRIMARY KEY (id)" +
                ");");
        jdbcOperations.execute(preQuery);
        jdbcOperations.execute(query);
        return "table created";
    }

    @Override
    public int insertValues() {
        String query = "INSERT INTO companies VALUES (?, ?);";
        return jdbcOperations.update(query, company.getId(), company.getTitle());
    }

    @Override
    public int update() {
        String query = "UPDATE companies SET title = 'DoDo' WHERE id = ?;";
        return jdbcOperations.update(con -> {
            PreparedStatement statement = con.prepareStatement(query);
            statement.setLong(1, company.getId());
            return statement;
        });
    }

    @Override
    public String delete() {
        String query = "DELETE FROM companies WHERE id = ?";
        jdbcOperations.update(query, company.getId());
        return "row was deleted";
    }

    @Override
    public void backup() {
        try {
            Runtime.getRuntime().exec("C:\\Program Files\\PostgreSQL\\9.5\\bin\\pg_dump.exe");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

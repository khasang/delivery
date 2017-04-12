package io.delivery.dao.impl;

import io.delivery.dao.CompanyDAO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.UUID;

@PropertySource(value = {"classpath:util.properties"})
public class CompanyDAOImpl implements CompanyDAO {

    private JdbcTemplate jdbcTemplate;

    @Value("${SQL.update}")
    private String queryUpdate;

    @Value("${SQL.insert}")
    private String queryInsert;

    @Value("${SQL.delete}")
    private String queryDelete;

    @Value("${SQL.drop}")
    String drop;

    @Value("${SQL.create}")
    String create;


    public CompanyDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public String createTable() {

        jdbcTemplate.execute(drop);
        jdbcTemplate.execute(create);
        return "table created";
    }

    @Override
    public String insertToTable() {

        return "Total rows affected: " + String.valueOf(jdbcTemplate.update(queryInsert,
                new Object[]{String.valueOf(UUID.randomUUID()).substring(0, 5), "Sela", 0}));
    }

    @Override
    public String deleteFromTable() {
        jdbcTemplate.execute(queryDelete);
        return "delete OK";
    }

    @Override
    public String updateTable() {
        return "Total rows affected " + String.valueOf(jdbcTemplate.update((Connection connection) -> {
            PreparedStatement preparedStatement = connection.prepareStatement(queryUpdate);
            preparedStatement.setString(1, "Sela");
            return preparedStatement;
        }));

    }

    @Override
    public String backUp() {

        int returnValue = -1;
        ProcessBuilder backUpProcess = new ProcessBuilder("pg_dump.exe",
                "--no-password",
                "--user=root",
                "--file=delivery.sql",
                "delivery");

        try {
            backUpProcess.start();
            returnValue = backUpProcess.start().waitFor();

        } catch (IOException e) {
            System.err.println("Wrong path to pg_dump or file not found");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return (returnValue == 0) ? "Dump OK" : "Return code:" + Integer.toString(returnValue);
    }
}

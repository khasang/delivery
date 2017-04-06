package io.delivery.service.impl;

import io.delivery.service.DBOperations;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.UUID;

public class DBOperationsImpl implements DBOperations{

//    private static final Logger LOG = Logger.getLogger(DBOperationsImpl.class);
    private JdbcTemplate jdbcTemplate;
    private String queryUpdate;
    private String queryInsert;
    private String queryDelete;
    private String pgdump;

    public DBOperationsImpl(JdbcTemplate jdbcTemplate,String queryUpdate, String queryInsert, String queryDelete, String pgdump) {
        this.jdbcTemplate = jdbcTemplate;
        this.queryUpdate = queryUpdate;
        this.queryInsert = queryInsert;
        this.queryDelete = queryDelete;
        this.pgdump = pgdump;
    }

    @Override
    public String createTable() {
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
    public String insertToTable() {

        return "Total rows affected: "+String.valueOf(jdbcTemplate.update(queryInsert,
                new Object[]{String.valueOf(UUID.randomUUID()).substring(0, 5), "Sela", 0}));
    }

    @Override
    public String deleteFromTable() {
        jdbcTemplate.execute(queryDelete);
        return "delete OK";
    }

    @Override
    public String updateTable() {
        return "Total rows affected "+String.valueOf( jdbcTemplate.update((Connection connection) -> {
            PreparedStatement preparedStatement = connection.prepareStatement(queryUpdate);
            preparedStatement.setString(1, "Sela");
            return preparedStatement;
        }));

    }

    @Override
    public String backUp() {
        Process backup = null;
//        LOG.info(backup);
        Runtime currentRuntime = Runtime.getRuntime();
        String[] cmdarray = new String[]{pgdump,"-f c:\\user\\home\\test.sql","delivery"};

        try  {
            backup = currentRuntime.exec(cmdarray);
        }
        catch (IOException e) {
            System.err.println("Wrong path to pg_dump or file not found");
        }

        return "Dump OK";
    }
}

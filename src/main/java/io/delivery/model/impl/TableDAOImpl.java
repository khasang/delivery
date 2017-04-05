package io.delivery.model.impl;

import io.delivery.model.TableDAO;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;

import java.io.IOException;

public class TableDAOImpl implements TableDAO{
    private static final Logger LOG = Logger.getLogger(TableDAOImpl.class);
    JdbcTemplate jdbcTemplate;

    public TableDAOImpl(){}

    public TableDAOImpl(JdbcTemplate jdbcTemplate){
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
    public String insertNewDataIntoTable() {
        jdbcTemplate.execute("insert into companies (code, title, did) values(11111, 'Title_1', 10)");
        return "Data inserted";
    }

    @Override
    public String updateDataInTable() {
        String preparedStatement = "update companies set code=?, title=?, did=? where code='11111'";
        jdbcTemplate.execute(preparedStatement, (PreparedStatementCallback<Object>) ps -> {
            ps.setInt(1, 22222);
            ps.setString(2, "UpdatedTitle");
            ps.setInt(3, 22);

            return ps.execute();
        });

        return "Data updated";
    }

    @Override
    public String selectDataFromTable() {
        String query = "SELECT * FROM users WHERE ID='6'";
        jdbcTemplate.execute(query);
        return "Data selected";
    }

    @Override
    public String deleteExistingTable() {
        String query = "DROP TABLE IF EXISTS companies";
        jdbcTemplate.execute(query);
        return "companies DELETED";
    }

    @Override
    public String backupTable() {
        String answer = null;
        Runtime runtime = Runtime.getRuntime();
        Process process;
        String cmd1 = "\"C:\\Program Files\\PostgreSQL\\9.5\\bin\\pg_dump.exe\" " +
                "-U root -w delivery > C:\\Users\\fixer\\PGDump\\delivery.backup";
//        String[] cmd = {
//                "\"C:\\Program Files\\PostgreSQL\\9.5\\bin\\pg_dump.exe\"",
//                "--host", "localhost",
//                "--port", "5432",
//                "--username", "root",
//                "--password", "root",
//                "--file", "C:\\Users\\fixer\\PGDump\\delivery.backup"
//        };
        try{
            process = runtime.exec(cmd1);
            process.waitFor();
            LOG.info("Backup dumped with request: " + cmd1);
            answer = "Backup dumped!";
        }catch (IOException | InterruptedException e){
            answer = "ERROR! Backup not dumped!";
            LOG.error("Problem with backupTable method with request: " + cmd1 + " " + e.getMessage());
        }
        return answer;
    }

}

package io.delivery.model.impl;

import io.delivery.model.TableDAO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;

public class TableDAOImpl implements TableDAO{
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
}

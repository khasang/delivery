package io.delivery.service.impl;

import io.delivery.service.QueryCreator;
import io.delivery.service.SetQuery;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;

import java.io.IOException;
import java.sql.PreparedStatement;

public class QueryCreatorImpl implements QueryCreator {

    private static final Logger LOG = Logger.getLogger(QueryCreatorImpl.class);
    private JdbcTemplate jdbcTemplate;
    private String query;


    public QueryCreatorImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public QueryCreatorImpl() {
    }

    @Override
    public String createQuery(SetQuery setQuery, String status) {
        setQuery(setQuery.getQuery());
        if (query != null) {
            try {
                jdbcTemplate.execute(query);
            } catch (Exception e) {
                LOG.error("Something going wrong" + e);
            }
        }
        return status;
    }

    public String updateQuery(String status) {
        jdbcTemplate.update(connection ->{
            setQuery("UPDATE comanies Set name = ? WHERE id = ?");
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, "Hello World");
            preparedStatement.setInt(2,2);
        return preparedStatement;
        });

        return status;
    }

    @Override
    public String pgDump() {
        String dump = "pg_dump -U root -w -c -f delivery.sql delivery";
        Process runtimeProcess;
        try {
            runtimeProcess = Runtime.getRuntime().exec(dump);
            int processComplete = runtimeProcess.waitFor();
            if (processComplete == 0) {
                return "Backup created.";
            } else {
                return "Could not create the backup";
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
}

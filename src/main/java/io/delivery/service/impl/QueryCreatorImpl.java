package io.delivery.service.impl;

import io.delivery.service.QueryCreator;
import io.delivery.service.SetQuery;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.PreparedStatement;

public class QueryCreatorImpl implements QueryCreator {

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
            jdbcTemplate.execute(query);
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
}

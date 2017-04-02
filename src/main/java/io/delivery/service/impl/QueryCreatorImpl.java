package io.delivery.service.impl;

import io.delivery.service.QueryCreator;
import io.delivery.service.SetQuery;
import org.springframework.jdbc.core.JdbcTemplate;

public class QueryCreatorImpl implements QueryCreator {

    private JdbcTemplate jdbcTemplate;
    private String preQuery;
    private String query;


    public QueryCreatorImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void setPreQuery(String query) {
        this.preQuery = query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public QueryCreatorImpl() {
    }

    @Override
    public String createQuery(SetQuery setQuery, String status) {
        setPreQuery(setQuery.getPreQuery());
        setQuery(setQuery.getQuery());
        if (preQuery != null) {
            jdbcTemplate.execute(preQuery);
        }
        if (query != null) {
            jdbcTemplate.execute(query);
        }
        return status;
    }
}

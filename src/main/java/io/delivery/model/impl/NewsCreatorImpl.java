package io.delivery.model.impl;

import io.delivery.model.NewsCreator;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;

public class NewsCreatorImpl implements NewsCreator{
    private static final Logger LOG = Logger.getLogger(TableCreatorImpl.class);
    private JdbcTemplate jdbcTemplate;

    public NewsCreatorImpl() {
    }

    public NewsCreatorImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public String createNews(){
        String preQuery = "DROP TABLE IF EXISTS news";
        String query = ("CREATE TABLE news (\n" +
                "    id             char(5) CONSTRAINT firstkey PRIMARY KEY,\n" +
                "    news     varchar(40) NOT NULL\n" +
                ");");
        try {
            jdbcTemplate.execute(preQuery);
            jdbcTemplate.execute(query);
        } catch (Exception e){
            LOG.error("something going wrong" + e);
        }
        return "table created";
    }
}

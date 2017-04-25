package io.delivery.model.impl;

import io.delivery.model.TableCreator;
import io.delivery.service.impl.CreateTableImpl;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component("tableCreator")
public class TableCreatorImpl implements TableCreator{
    private static final Logger LOG = Logger.getLogger(TableCreatorImpl.class);
    private JdbcTemplate jdbcTemplate;

    public TableCreatorImpl() {
    }

    public TableCreatorImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public String createCompany(){
        String preQuery = "DROP TABLE IF EXISTS companies";
        String query = ("CREATE TABLE companies (\n" +
                "    code        char(5) CONSTRAINT firstkey PRIMARY KEY,\n" +
                "    title       varchar(40) NOT NULL,\n" +
                "    did         integer NOT NULL,\n" +
                "    date_prod   date,\n" +
                "    kind        varchar(10),\n" +
                "    len         interval hour to minute\n" +
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

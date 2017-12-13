package io.delivery.service.impl;

import io.delivery.service.InsertUser;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Created by NortT on 01.04.2017.
 */
public class InsertUserImpl implements InsertUser {
    private JdbcTemplate jdbcTemplate;

    public InsertUserImpl(){}

    public InsertUserImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public String insertUser() {
        for (int i=71; i<=100; i++) {
            String query = "INSERT INTO Users (id, name, company_name)" +
                    "VALUES ("+i+", 'John N"+i+"', "+i+")";

            jdbcTemplate.execute(query);
        }
        return "A new user has been inserted";
    }
}

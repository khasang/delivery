package io.delivery.model;

import org.springframework.jdbc.core.JdbcTemplate;

public class Insert {
    private JdbcTemplate jdbcTemplate;

    public Insert() {
    }

    public Insert(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public String insert (){
        String query ="INSERT INTO companies VALUES (5, 'Yahoo')";
        jdbcTemplate.execute(query);
                return "insert done";
    }
}

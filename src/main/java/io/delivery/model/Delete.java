package io.delivery.model;

import org.springframework.jdbc.core.JdbcTemplate;

public class Delete {
    private JdbcTemplate jdbcTemplate;

    public Delete() {
    }

    public Delete(JdbcTemplate jdbcTemplate) {
            this.jdbcTemplate = jdbcTemplate;
    }

    public String deleteRows(){
        String query ="DELETE FROM companies WHERE id =3";
        jdbcTemplate.execute(query);
        return "delete done";
    }
}

package io.delivery.model;

import org.springframework.jdbc.core.JdbcTemplate;

public class UpdateTable {
    private JdbcTemplate jdbcTemplate;

    public UpdateTable() {
    }

    public UpdateTable(JdbcTemplate jdbcTemplate) {
            this.jdbcTemplate = jdbcTemplate;
    }

    public String updateRows (){
        String query = "UPDATE companies SET name = 'Dell' WHERE name = 'Yahoo'";
        jdbcTemplate.execute(query);
        return "update table";
    }

}

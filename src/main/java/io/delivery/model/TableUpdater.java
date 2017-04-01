package io.delivery.model;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;

public class TableUpdater {
    private JdbcTemplate jdbcTemplate;

    public TableUpdater(){}

    public TableUpdater(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public String updateDataInTable(){
        String preparedStatement = "update companies set code=?, title=?, did=? where code='11111'";
        jdbcTemplate.execute(preparedStatement, (PreparedStatementCallback<Object>) ps -> {
            ps.setInt(1, 22222);
            ps.setString(2, "UpdatedTitle");
            ps.setInt(3, 22);

            return ps.execute();
        });

        return "Data updated";
    }
}

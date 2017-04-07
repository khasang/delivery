package io.delivery.model;

import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateTable {
    private JdbcTemplate jdbcTemplate;

    public UpdateTable() {
    }

    public UpdateTable(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public String updateRows(String name, int id) {
        try {
            PreparedStatement preparedStatement = jdbcTemplate.getDataSource().
                    getConnection().prepareStatement("UPDATE companies SET name = ? WHERE id = ?");
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "update table";
    }
}

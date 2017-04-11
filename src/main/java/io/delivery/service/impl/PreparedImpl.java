package io.delivery.service.impl;

import io.delivery.model.Company;
import io.delivery.service.Prepared;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PreparedImpl implements Prepared {
    private JdbcTemplate jdbcTemplate;
    private Company company;

    public PreparedImpl() {
    }

    public PreparedImpl(JdbcTemplate jdbcTemplate, Company company) {
        this.jdbcTemplate = jdbcTemplate;
        this.company = company;
    }

    @Override
    public String update() {
        String query = ("UPDATE companies SET name=?, size=? WHERE id=?;");
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, company.getName());
                preparedStatement.setInt(2, company.getSize());
                preparedStatement.setInt(3, company.getId());
                return preparedStatement;
            }
        });

        return "Update done";
    }
}

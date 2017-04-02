package io.delivery.service.impl;

import io.delivery.model.Company;
import io.delivery.service.InsertItem;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertItemImpl implements InsertItem {
    private JdbcTemplate jdbcTemplate;
    private String query;

    public InsertItemImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public InsertItemImpl() {
    }

    public void setQuery(String query) {
        this.query = query;
    }

    @Override
    public String createItem(Company company) {
//        query = ("INSERT INTO companies " +
//                "VALUES (1,'Yandex',1500);");
        query = "INSERT INTO companies VALUES (?,?,?)";
        jdbcTemplate.execute(query, new PreparedStatementCallback<Integer>() {
            @Override
            public Integer doInPreparedStatement(PreparedStatement preparedStatement) throws SQLException, DataAccessException {
                preparedStatement.setInt(1, company.getId());
                preparedStatement.setString(2, company.getName());
                preparedStatement.setInt(3, company.getSize());
                return preparedStatement.executeUpdate();
            }
        });
        return "Item created";
    }
}

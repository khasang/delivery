package io.delivery.service.impl;

import io.delivery.entity.Company;
import io.delivery.service.InsertItem;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertItemImpl implements InsertItem {
    private JdbcTemplate jdbcTemplate;
    private Company company;
    private String query;

    public InsertItemImpl(JdbcTemplate jdbcTemplate, Company company) {
        this.jdbcTemplate = jdbcTemplate;
        this.company = company;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    @Override
    public String insertItem() {
        query = ("INSERT INTO companies(id, name, size) VALUES(?,?,?);");

        jdbcTemplate.update(connection -> {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, company.getId());
            preparedStatement.setString(2, company.getName());
            preparedStatement.setInt(3, company.getSize());
            return preparedStatement;
        });
        return "Insert done";
    }


//    @Override
//    public String insertItem() {
//        query = ("INSERT INTO companies " +
//                "VALUES (1,'Google',2000);");
//        jdbcTemplate.execute(query);
//        return "Insert done";
//    }


}

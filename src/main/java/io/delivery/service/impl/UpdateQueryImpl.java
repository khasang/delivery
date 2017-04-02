package io.delivery.service.impl;

import io.delivery.service.SetQuery;

import java.sql.PreparedStatement;

public class UpdateQueryImpl implements SetQuery {
    @Override
    public String getPreQuery() {
        return null;
    }

    @Override
    public String getQuery() {
        String query = "UPDATE comanies Set name = 'Yahoo' WHERE id = '3'";
        return query;
    }
}

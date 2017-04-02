package io.delivery.service.impl;

import io.delivery.service.SetQuery;

public class InsertQueryImpl implements SetQuery {
    @Override
    public String getPreQuery() {
        return null;
    }

    @Override
    public String getQuery() {
        String query = "INSERT INTO comanies" +
                " (id, name) VALUES ((SELECT MAX(id) FROM comanies)+1,'Bingo')";
        return query;
    }
}

package io.delivery.service.impl;

import io.delivery.service.SetQuery;

public class DeleteQueryImpl implements SetQuery {
    @Override
    public String getQuery() {
        String query ="DELETE FROM comanies WHERE id = '4'";
        return query;
    }
}

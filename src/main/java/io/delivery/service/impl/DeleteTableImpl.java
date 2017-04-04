package io.delivery.service.impl;

import io.delivery.service.SetQuery;

public class DeleteTableImpl implements SetQuery {
    @Override
    public String getQuery() {
        return "DROP TABLE IF EXISTS companies";
    }
}

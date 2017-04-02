package io.delivery.service.impl;

import io.delivery.service.SetQuery;

public class DeleteTableImpl implements SetQuery {
    @Override
    public String getPreQuery() {
        return "DROP TABLE IF EXISTS companies";
    }

    @Override
    public String getQuery() {
        return null;
    }
}

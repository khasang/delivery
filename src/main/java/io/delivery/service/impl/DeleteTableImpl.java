package io.delivery.service.impl;

import io.delivery.service.DeleteTable;

public class DeleteTableImpl implements DeleteTable {
    private String query;

    public DeleteTableImpl() {
    }

    public DeleteTableImpl(String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    @Override
    public String deleteCompany() {
        return query;
    }
}

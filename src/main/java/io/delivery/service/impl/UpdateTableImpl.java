package io.delivery.service.impl;

import io.delivery.service.UpdateTable;

public class UpdateTableImpl implements UpdateTable{
    private String query;

    public UpdateTableImpl() {
    }

    public UpdateTableImpl(String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    @Override
    public String updateCompany() {
        return query;
    }
}

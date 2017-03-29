package io.delivery.service.impl;

import io.delivery.service.CreateTable;

public class CreateTableImpl implements CreateTable {
    private String query;

    public CreateTableImpl(String query) {
        this.query = query;
    }

    public CreateTableImpl() {
    }

    public String getQuery() {

        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    @Override
    public String createCompany() {
        return query;
    }
}

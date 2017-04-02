package io.delivery.service.impl;


import io.delivery.service.InsertTable;

public class InsertTableImpl implements InsertTable{
    private String query;

    public InsertTableImpl() {
    }

    public InsertTableImpl(String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    @Override
    public String insertCompany() {
        return query;
    }

}

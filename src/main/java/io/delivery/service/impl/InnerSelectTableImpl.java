package io.delivery.service.impl;


import io.delivery.service.InnerSelectTable;

public class InnerSelectTableImpl implements InnerSelectTable{
    private String query;

    public InnerSelectTableImpl() {
    }

    public InnerSelectTableImpl(String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    @Override
    public String innerCompany() {
        return query;
    }
}

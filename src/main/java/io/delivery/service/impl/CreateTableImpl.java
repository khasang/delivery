package io.delivery.service.impl;

import io.delivery.model.Answer;
import io.delivery.service.CreateTable;
import org.springframework.beans.factory.annotation.Autowired;

public class CreateTableImpl implements CreateTable {
    @Autowired
    private Answer answer;

    // Ошибка или антипаттерн
//    Answer answer = new Answer();


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

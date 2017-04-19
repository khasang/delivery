package io.delivery.service.impl;

import io.delivery.model.Answer;
import io.delivery.service.CreateTable;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;


public final class CreateTableImpl implements CreateTable {
    private static final Logger LOG = Logger.getLogger(CreateTableImpl.class);

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

    public final String delete(){
        return "done";
    }

    public void setQuery(String query) {
        this.query = query;
    }

    @Override
    public String createCompany() {
        LOG.info("our query: " + query);
        return query;
    }
}

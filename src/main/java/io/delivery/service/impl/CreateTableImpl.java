package io.delivery.service.impl;

import io.delivery.service.SetQuery;

public class CreateTableImpl implements SetQuery {
    @Override
    public String getQuery() {
        String query = ("CREATE TABLE companies (\n" +
                "    code        char(5) CONSTRAINT firstkey PRIMARY KEY,\n" +
                "    title       varchar(40) NOT NULL,\n" +
                "    did         integer NOT NULL,\n" +
                "    date_prod   date,\n" +
                "    kind        varchar(10),\n" +
                "    len         interval hour to minute\n" +
                ");");
        return query;
    }
}


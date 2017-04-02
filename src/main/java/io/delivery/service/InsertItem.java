package io.delivery.service;

import io.delivery.model.Company;

public interface InsertItem {
    /**
     * Inserts a row into table
     * @return  state result
     */
    String createItem(Company company);
}

package io.delivery.dao;

import io.delivery.entity.Document;

import java.util.List;

public interface DocumentDao extends BasicDao<Document> {

    /**
     * Find documents by name at database
     *
     * @param name - value name of document
     * @return document
     */
    List<Document> findByName(String name);
}

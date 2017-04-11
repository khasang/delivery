package io.delivery.service;

import io.delivery.entity.Document;

import java.util.List;

public interface DocumentService {
    /**
     * Receibe all documents from db
     *
     * @return document list
     */
    List<Document> getDocumentList();

    /**
     * Find documents by name at DB
     *
     * @return document
     * @Param name - value name of document
     */

    List<Document> findByName(String name);

    /**
     * Create document at DB
     * @Param document - current document for creation
     * @return created document
     */

    Document create (Document document);

}

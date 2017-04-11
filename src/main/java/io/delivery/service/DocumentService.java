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
     *
     * @return created document
     * @Param document - current document for creation
     */

    Document create(Document document);

    /**
     * @param document - document for update
     * @return document
     */
    Document updateDocument(Document document);

    /**
     * @param id - document id
     * @return deleted document
     */
    Document deleteDocument(long id);

    Document findById(long id);
}

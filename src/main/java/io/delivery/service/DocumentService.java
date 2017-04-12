package io.delivery.service;

import io.delivery.entity.Document;

import java.util.List;

public interface DocumentService {

    /**
     * Receive all documents from db
     *
     * @return document list
     */
    List<Document> getDocumentList();

    /**
     * Find documents by name in database
     *
     * @param name - value name of document
     * @return document
     */
    List<Document> findByName(String name);

    /**
     * Create entity in database
     *
     * @param document - current document for creation
     * @return created document
     */
    Document create(Document document);

    /**
     * Update entity in database
     *
     * @param document - document for update
     * @return document
     */
    Document updateDocument(Document document);

    /**
     * Delete document by ID
     *
     * @param id - document id
     * @return deletet document
     */
    Document deleteDocument(long id);

    /**
     * Find document by id
     *
     * @param id - document id
     * @return document
     */
    Document findById(long id);
}

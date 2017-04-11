package io.delivery.service;

import io.delivery.entity.Document;

import java.util.List;

public interface DocumentService {
    /**
     * Receive all documents from database
     *
     * @return document list
     */
    List<Document> getDocumentList();

    /**
     * Find documents by name at database
     *
     * @param name - value of name document
     * @return document
     */
    List<Document> findByName(String name);

    /**
     * Create document at database
     *
     * @param document - current document
     * @return created entity
     */
    Document create(Document document);
}

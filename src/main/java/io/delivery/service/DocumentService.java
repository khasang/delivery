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

    /**
     * Update document at database
     * @param document - current document for update
     * @return updated document
     */
    Document updateDocument(Document document);

    /**
     * Delete document by id
     * @param id - document id
     * @return deleted document
     */
    Document deleteDocument(long id);

    /**
     * Find document by id
     * @param id - document id
     * @return document
     */
    Document findById(long id);
}

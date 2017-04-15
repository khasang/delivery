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
     * Find documents by name at db
     *
     * @param name - value name of document
     * @return document
     */

    List<Document> findByName(String name);

    /**
     * Create document at db
     *
     * @param document - current document
     * @return created document
     */
    Document create(Document document);

    /**
     * @param document for update
     * @return document
     */
    Document updateDocument(Document document);

    /**
     * @param id = document id
     *           @return deleted document
     *
     */
    Document deleteDocument(long id);

    Document findById(long id);
}

package io.delivery.service;

import io.delivery.entity.Document;

import java.util.List;

public interface DocumentService {
    /**
     * @Receive all documents from db
     *
     * @Return document list
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
     * @param document - current document for creation
     * @return created document
     */
    Document create(Document document);
}

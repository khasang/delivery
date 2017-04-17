package io.delivery.service;

import io.delivery.entity.Document;
import java.util.List;

/**
 *
 */
public interface DocumentService {
    /**
     * Receive all documents from DB
     * @return list of documents
     */
    List<Document> getDocumentList();

    /**
     * Find documents by name
     * @param name - value name of document
     * @return the exact document
     */
    List<Document> findByName(String name);

    /**
     * Create document
     * @param document - current document
     * @return created entity
     */
    Document create(Document document);

    /**
     * Update document
     * @param document - current document
     * @return updated entity
     */
    Document update(Document document);

    /**
     * delete document bu its Id
     * @param id - current id
     * @return deleted entity
     */
    Document delete(long id);

    /**
     * find document by its Id
     * @param id - current id
     * @return found document
     */
    public Document findById(long id) ;
}

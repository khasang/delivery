package io.delivery.service;

import io.delivery.entity.Document;

import java.util.List;

public interface DocumentService {
    /**
     * Receive all documents from db
     *
     * @return document list
     */
<<<<<<< HEAD

    List<Document> getDocumentList();

    /**
     * Find documents by name at db
=======
    List<Document> getDocumentList();

    /**
     * Find documents by name at database
>>>>>>> origin/feedback
     *
     * @param name - value name of document
     * @return document
     */
<<<<<<< HEAD

    List<Document> findByName(String name);

    /**
     * Create document at db
     *
     * @param document - current document
=======
    List<Document> findByName(String name);

    /**
     * Create document at database
     *
     * @param document - current document for creation
>>>>>>> origin/feedback
     * @return created document
     */
    Document create(Document document);

    /**
<<<<<<< HEAD
     * @param document for update
=======
     * @param document - document for update
>>>>>>> origin/feedback
     * @return document
     */
    Document updateDocument(Document document);

    /**
     * @param id = document id
<<<<<<< HEAD
     *           @return deleted document
     *
=======
     * @return deleted document
>>>>>>> origin/feedback
     */
    Document deleteDocument(long id);

    Document findById(long id);
}

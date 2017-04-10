package io.delivery.service;

import io.delivery.entity.Document;
import java.util.List;

public interface DocumentService {
    /**
     * Receibe all documents from db
     *
     *@return document list
     **/
    List<Document> getDocumentList();

    /**
     * Find documents by name at DB
     *
     * @Param name - value name of document
     * @return document
     **/

    List<Document> findByName (String name);

}

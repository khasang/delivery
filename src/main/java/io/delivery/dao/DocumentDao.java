package io.delivery.dao;


import io.delivery.entity.Document;

import java.util.List;

public interface DocumentDao extends Basicdao<Document> {

    /**
     * Find documents by name at DB
     *
     * @Param name - value name of document
     * @return document
     **/

    List<Document> findByName (String name);

}

package io.delivery.dao;

import io.delivery.entity.Document;

import java.util.List;

public interface DocumentDao extends BasicDao<Document> {
<<<<<<< HEAD
    /**
     * Find documents by name at db
=======

    /**
     * Find documents by name at database
>>>>>>> origin/feedback
     *
     * @param name - value name of document
     * @return document
     */
<<<<<<< HEAD

=======
>>>>>>> origin/feedback
    List<Document> findByName(String name);
}

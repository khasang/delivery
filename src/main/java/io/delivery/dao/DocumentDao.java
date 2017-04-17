package io.delivery.dao;

import io.delivery.entity.Document;
import java.util.List;

/**
 * Created by NortT on 15.04.2017.
 */
public interface DocumentDao extends BasicDao<Document> {
    List<Document> findByName(String name);
}

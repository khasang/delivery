package io.delivery.dao;

import io.delivery.entity.AdminArea;

import java.util.List;

public interface AdminAreaDao extends BasicDao<AdminArea> {

    /**
     * Find documents by name at database
     *
     * @param name - value name of document
     * @return document
     */
    List<AdminArea> findByName(String name);
}

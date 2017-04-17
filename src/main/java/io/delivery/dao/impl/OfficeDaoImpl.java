package io.delivery.dao.impl;

import io.delivery.dao.OfficeDao;
import io.delivery.entity.Office;

/**
 * Created by NortT on 16.04.2017.
 */
public class OfficeDaoImpl extends BasicDaoImpl<Office> implements OfficeDao{
    public OfficeDaoImpl(Class<Office> entityClass) {
        super(entityClass);
    }
}

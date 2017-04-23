package io.delivery.dao.impl;

import io.delivery.dao.OfficeDao;
import io.delivery.entity.Office;

public class OfficeDaoImpl extends BasicDaoImpl<Office> implements OfficeDao{
    public OfficeDaoImpl(Class<Office> entityClass) {
        super(entityClass);
    }
}

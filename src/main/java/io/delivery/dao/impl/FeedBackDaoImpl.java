package io.delivery.dao.impl;

import io.delivery.dao.FeedBackDao;
import io.delivery.entity.FeedBack;

public class FeedBackDaoImpl extends BasicDaoImpl<FeedBack> implements FeedBackDao {
    public FeedBackDaoImpl(Class<FeedBack> entityClass) {
        super(entityClass);
    }
}

package io.delivery.dao.impl;

import io.delivery.dao.BasicDao;
import io.delivery.dao.ProductCatalogSectionDao;
import io.delivery.entity.ProductCatalogSection;

public class ProductCatalogSectionDaoImpl extends BasicDaoImpl<ProductCatalogSection> implements ProductCatalogSectionDao {

    public ProductCatalogSectionDaoImpl(Class<ProductCatalogSection> entityClass) {
        super(entityClass);
    }
}

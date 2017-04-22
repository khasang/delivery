package io.delivery.dao.impl;

import io.delivery.dao.ProductImageDao;
import io.delivery.entity.ProductImage;

import java.util.List;

public class ProductImageDaoImpl extends BasicDaoImpl<ProductImage> implements ProductImageDao{
    public ProductImageDaoImpl(Class<ProductImage> entityClass) {
        super(entityClass);
    }

    @Override
    public List<ProductImage> getByProductId(long productId) {
        return (List<ProductImage>) sessionFactory.getCurrentSession().
                createQuery("from ProductImage as pi where pi.product.id = ?").
                setParameter(0, productId).list();
    }

    @Override
    @Deprecated
    public ProductImage update(ProductImage productImage) {return null;};
}

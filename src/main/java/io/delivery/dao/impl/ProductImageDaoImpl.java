package io.delivery.dao.impl;

import io.delivery.dao.ProductImageDao;
import io.delivery.entity.Product;
import io.delivery.entity.ProductImage;

import java.util.List;

public class ProductImageDaoImpl extends BasicDaoImpl<ProductImage> implements ProductImageDao{
    public ProductImageDaoImpl(Class<ProductImage> entityClass) {
        super(entityClass);
    }

    @Override
    public List<ProductImage> findByProductId(long productId) {
        List<ProductImage> imageList = (List<ProductImage>) sessionFactory.getCurrentSession()
                .createQuery("from ProductImage as i where i.product.id = ?")
                .setParameter(0, productId)
                .list();
        return  imageList;
    }
}

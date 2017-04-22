package io.delivery.dao;

import io.delivery.entity.ProductImage;

import java.util.List;

public interface ProductImageDao extends BasicDao<ProductImage> {
    public List<ProductImage> getByProductId(long productId);
}

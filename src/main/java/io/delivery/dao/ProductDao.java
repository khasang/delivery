package io.delivery.dao;

import io.delivery.entity.Product;
import io.delivery.entity.ProductCatalogSection;
import io.delivery.entity.ProductImage;

import java.util.List;

public interface ProductDao extends BasicDao<Product> {

    /**
     * Find goods by the specified name at database
     *
     * @param name value name of product
     * @return document
     */
    List<Product> findByName(String name);

    /**
     * Find goods with the price value between the specified
     * @param min minimum price of products to be found
     * @param max maximum price of products to be found
     * @return products with price within the specified range
     */
    List<Product> findByPriceRange(int min, int max);

    /**
     * Get all products of the specified section
     * @param sectionId id of the target section
     * @return products list
     */
    List<Product> getBySectionId(long sectionId);
}

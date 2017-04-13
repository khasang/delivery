package io.delivery.service;

import io.delivery.entity.Product;

import java.util.List;

public interface ProductService {

    /**
     * Receive all goods from the db
     * @return product list
     */
    List<Product> getAll();

    /**
     * Find product by name at the db
     * @param name name of product
     * @return list of products with the specified name
     */
    List<Product> findByName(String name);

    /**
     * Create product at the db
     * @param product current product for creation
     * @return created product
     */
    Product create(Product product);

    /**
     * @param product product for update
     * @return updated product
     */
    Product update(Product product);

    /**
     * Delete product with the specified id
     * @param id product id
     * @return deleted product
     */
    Product delete(long id);


    /**
     * Find product by the specified id
     * @param id id of product to be found
     * @return product
     */
    Product findById(long id);

    /**
     * Find products with price in the specified range
     * @param min minimum price
     * @param max maximum price
     * @return list of products with the price in the specified range
     */
    List<Product> findWithPriceBetween(int min, int max);
}

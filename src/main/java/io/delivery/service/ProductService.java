package io.delivery.service;

import io.delivery.entity.Product;
import io.delivery.entity.ProductCatalogSection;
import io.delivery.entity.ProductImage;

import java.util.List;

public interface ProductService {

    /**
     * Receive all goods from the db
     * @return product list
     */
    List<Product> getAllProducts();

    /**
     * Find product by name at the db
     * @param name name of product
     * @return list of products with the specified name
     */
    List<Product> getProductsByName(String name);

    /**
     * Create product at the db
     * @param product current product for creation
     * @return created product
     */
    Product createProduct(Product product);

    /**
     * @param product product for updateProduct
     * @return updated product
     */
    Product updateProduct(Product product);

    /**
     * Delete product with the specified id
     * @param id product id
     * @return deleted product
     */
    Product deleteProduct(long id);


    /**
     * Find product by the specified id
     * @param id id of product to be found
     * @return product
     */
    Product getProductById(long id);

    /**
     * Find products with price in the specified range
     * @param min minimum price
     * @param max maximum price
     * @return list of products with the price in the specified range
     */
    List<Product> getProductsByPriceRange(int min, int max);

    /**
     * Get all products from the specified section
     * @param sectionId id of the section to be loaded
     * @return list of products
     */
    List<Product> getProductBySectionId(long sectionId);

    /**
     * Receive all product sections
     * @return product catalog section list
     */
    List<ProductCatalogSection> getAllCatalogSections();

    /**
     * Create product secton at the db
     * @param section current section for creation
     * @return created section
     */
    ProductCatalogSection createCatalogSection(ProductCatalogSection section);

    /**
     * Get product catalog section with the specified id from the db
     * @param sectionId id of the target section
     * @return catalog section
     */
    ProductCatalogSection getCatalogSectionById(long sectionId);

    /**
     * @param section catalog section for updateProduct
     * @return updated section
     */
    ProductCatalogSection updateCatalogSection(ProductCatalogSection section);

    /**
     * Delete product catalog section with the specified id
     * @param sectionId section id
     * @return deleted section
     */
    ProductCatalogSection deleteCatalogSection(long sectionId);

    /**
     * Get all images related to the product
     * @param id id of the product
     * @return list of product images
     */
    List<ProductImage> getImageIdsByProductId(long id);

    /**
     * Add product image to the db
     * @param image product image to be added
     * @return image
     */
    ProductImage createImage(ProductImage image);

    /**
     * Delete product image from the db
     * @param imageId product image id to be deleted
     * @return image
     */
    ProductImage deleteImage(long imageId);

    /**
     * Get product image by its id
     * @param imageId id of the image
     * @return product image
     */
    ProductImage getImageById(long imageId);
}

package io.delivery.service.impl;

import io.delivery.dao.ProductCatalogSectionDao;
import io.delivery.dao.ProductDao;
import io.delivery.dao.ProductImageDao;
import io.delivery.entity.Product;
import io.delivery.entity.ProductCatalogSection;
import io.delivery.entity.ProductImage;
import io.delivery.service.ProductService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service("productService")
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;

    @Autowired
    private ProductCatalogSectionDao productCatalogSectionDao;

    @Autowired
    private ProductImageDao productImageDao;

    @Override
    public List<Product> getAllProducts() {
        return productDao.getList();
    }

    @Override
    public List<Product> getProductsByName(String name) {
        return productDao.findByName(name);
    }

    @Override
    public Product addProduct(Product product) {
        return productDao.create(product);
    }

    @Override
    public Product updateProduct(Product product) {
        return productDao.update(product);
    }

    @Override
    public Product deleteProduct(long id) {
        return productDao.delete(getProductById(id));
    }

    @Override
    public Product getProductById(long id) {
        return productDao.findById(id);
    }

    @Override
    public List<Product> getProductsByPriceRange(int min, int max) {
        return productDao.findByPriceRange(min, max);
    }

    @Override
    public List<Product> getProductsByCatalogSectionId(long sectionId) {
        return productDao.findByCatalogSectionId(sectionId);
    }

    @Override
    public List<ProductCatalogSection> getAllCatalogSections() {
        return productCatalogSectionDao.getList();
    }

    @Override
    public ProductCatalogSection addCatalogSection(ProductCatalogSection section) {
        return productCatalogSectionDao.create(section);
    }

    @Override
    public ProductCatalogSection getCatalogSectionById(long sectionId) {
        return productCatalogSectionDao.findById(sectionId);
    }

    @Override
    public ProductCatalogSection updateCatalogSection(ProductCatalogSection section) {
        return productCatalogSectionDao.update(section);
    }

    @Override
    public ProductCatalogSection deleteCatalogSection(long sectionId) {
        return productCatalogSectionDao.delete(getCatalogSectionById(sectionId));
    }

    @Override
    public List<ProductImage> getImagesByProductId(long id) {
        return productImageDao.findByProductId(id);
    }

    @Override
    public ProductImage addImage(ProductImage image) {
        return productImageDao.create(image);
    }

    @Override
    public ProductImage deleteImage(long imageId) {
        return productImageDao.delete(productImageDao.findById(imageId));
    }

    @Override
    public ProductImage getImageById(long imageId) {
        return productImageDao.findById(imageId);
    }
}

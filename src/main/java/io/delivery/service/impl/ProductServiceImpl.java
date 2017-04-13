package io.delivery.service.impl;

import io.delivery.dao.ProductDao;
import io.delivery.entity.Product;
import io.delivery.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("productService")
public class ProductServiceImpl implements ProductService{
    @Autowired
    ProductDao productDao;

    @Override
    public List<Product> getAll() {
        return productDao.getList();
    }

    @Override
    public List<Product> findByName(String name) {
        return productDao.findByName(name);
    }

    @Override
    public Product create(Product product) {
        return productDao.create(product);
    }

    @Override
    public Product update(Product product) {
        return productDao.update(product);
    }

    @Override
    public Product delete(long id) {
        return productDao.delete(findById(id));
    }

    @Override
    public Product findById(long id) {
        return productDao.findById(id);
    }

    @Override
    public List<Product> findWithPriceBetween(int min, int max) {
        return productDao.findByPriceRange(min, max);
    }
}

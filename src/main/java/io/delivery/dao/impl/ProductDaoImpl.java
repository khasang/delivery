package io.delivery.dao.impl;

import io.delivery.dao.ProductDao;
import io.delivery.entity.Product;
import io.delivery.entity.ProductImage;

import java.util.List;

public class ProductDaoImpl extends BasicDaoImpl<Product> implements ProductDao {
    public ProductDaoImpl(Class<Product> entityClass) {
        super(entityClass);
    }


    @Override
    public List<Product> findByName(String name) {
        return (List<Product>) sessionFactory.getCurrentSession().
                createQuery("from Product as p where p.name = ?").
                setParameter(0, name).list();
    }

    @Override
    public List<Product> findByPriceRange(int min, int max) {
         return (List<Product>) sessionFactory.getCurrentSession().
                 createQuery("from Product as p where p.price between ? and ?").
                 setParameter(0, min).setParameter(1, max).list();
    }

    @Override
    public List<Product> getBySectionId(long sectionId) {
        return (List<Product>) sessionFactory.getCurrentSession().
                createQuery("from Product as p where p.productCatalogSection.id = ?").
                setParameter(0, sectionId).list();
    }
}

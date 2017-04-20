package io.delivery.entity;

import javax.persistence.*;

@Entity
@Table(name = "product_catalog_sections")
public class ProductCatalogSection {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    @OneToOne
    @JoinColumn(name = "parent_id")
    private ProductCatalogSection parentProductCatalogSection;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProductCatalogSection getParentProductCatalogSection() {
        return parentProductCatalogSection;
    }

    public void setParentProductCatalogSection(ProductCatalogSection parentProductCatalogSection) {
        this.parentProductCatalogSection = parentProductCatalogSection;
    }
}

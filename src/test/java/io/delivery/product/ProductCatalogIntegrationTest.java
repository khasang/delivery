package io.delivery.product;

import io.delivery.config.AppConfig;
import io.delivery.config.HibernateConfig;
import io.delivery.entity.Product;
import io.delivery.entity.ProductCatalogSection;
import io.delivery.entity.ProductImage;
import io.delivery.service.ProductService;
import io.delivery.service.impl.ProductServiceImpl;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class, ProductServiceImpl.class, HibernateConfig.class})
public class ProductCatalogIntegrationTest {
    private final String ROOT = "http://localhost:8080/products";
    private final String GET_ID = "/get/id/";
    private final String ADD = "/add";
    private final String UPDATE = "/updateProduct";
    private final String DELETE = "/deleteProduct/";
    private final String ALL = "/all";
    private final String GET_NAME = "/get/name/";
    private final String GET_PRICE = "/get/price/";

    @Autowired
    private ProductService productService;

    private List<Product> productList;
    private List<ProductCatalogSection> catalogSectionList;
    private List<ProductImage> imageList;

    @Before
    public void createTestEntities() {
        Product product = new Product();
        ProductCatalogSection section = new ProductCatalogSection();
        ProductImage image = new ProductImage();
        List<ProductImage> imageList = new ArrayList<>();
        List<Product> productList = new ArrayList<>();
        product.setName("Magic");
        product.setDescription("fire");
        product.setPrice(100);
        section.setName("PizzaTest");
        image.setImage(new byte[] {1, 2 , 3, 4});
        imageList.add(image);
        product.setImages(imageList);
        productList.add(product);
        section.setProducts(productList);
//        product.setProductCatalogSection(section);
        productService.addCatalogSection(section);
        catalogSectionList = new ArrayList<>();
        catalogSectionList.add(section);
    }

    @Test
    public void Test1() {
        assertTrue(true);
    }

/*
    @Test
    public void addProduct() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        Product product = new Product();
        product.setName("Magic");
        product.setDescription("fire");
        product.setPrice(100);
        HttpEntity<Product> httpEntity = new HttpEntity<>(product, headers);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Product> responseEntity = restTemplate.exchange(
                ROOT + ADD,
                HttpMethod.POST,
                httpEntity,
                Product.class
        );
        Product createdProduct = responseEntity.getBody();
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(createdProduct);
        assertEquals(createdProduct.getName(), product.getName());
        productService.deleteProduct(createdProduct.getId());
    }

    @Test
    public void getProductById() {
        Product createdProduct = createProduct();

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<Product> responseEntity = restTemplate.exchange(
                ROOT + GET_ID + "{id}",
                HttpMethod.GET,
                null,
                Product.class,
                createdProduct.getId()
        );

        Product resultProduct = responseEntity.getBody();
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(resultProduct);
        assertEquals(createdProduct.getName(), resultProduct.getName());
        productService.deleteProduct(createdProduct.getId());
    }

    @Test
    public void getProductByName() {
        Product createdProduct = createProduct();

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<List<Product>> result = restTemplate.exchange(
                ROOT + GET_NAME + "{name}",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Product>>() {
                },
                createdProduct.getName()
        );

        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertNotNull(result.getBody());
        List<Product> list = result.getBody();
        assertNotNull(list.get(0));
        productService.deleteProduct(createdProduct.getId());
    }

    @Test
    public void getProductByPriceRange() {
        Product createdProduct = createProduct();

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<List<Product>> result = restTemplate.exchange(
                ROOT + GET_PRICE + "{min}/{max}",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Product>>() {
                },
                createdProduct.getPrice() - 1,
                createdProduct.getPrice() + 1
        );

        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertNotNull(result.getBody());
        List<Product> list = result.getBody();
        assertNotNull(list.get(0));
        productService.deleteProduct(createdProduct.getId());
    }

    @Test
    public void getAllProducts(){
        Product createdProduct = createProduct();

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<List<Product>> result = restTemplate.exchange(
                ROOT + ALL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Product>>() {
                }
        );
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertNotNull(result.getBody());
        List<Product> list = result.getBody();
        assertNotNull(list.get(0));
        productService.deleteProduct(createdProduct.getId());
    }

    @Test
    public void updateProduct() {
        Product createdProduct = createProduct();
        createdProduct.setName("Sword");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

        RestTemplate restTemplate = new RestTemplate();

        HttpEntity<Product> httpEntity = new HttpEntity<>(createdProduct, headers);
        ResponseEntity<Product> responseEntity = restTemplate.exchange(
               ROOT + UPDATE,
               HttpMethod.PUT,
               httpEntity,
               Product.class
        );
        Product updatedProduct = responseEntity.getBody();
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(updatedProduct);
        assertEquals(updatedProduct.getName(), createdProduct.getName());
        productService.deleteProduct(createdProduct.getId());
    }

    @Test
    public void deleteProduct(){
        Product createdProduct = createProduct();
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.exchange(
                ROOT + DELETE + "{id}",
                HttpMethod.DELETE,
                null,
                String.class,
                createdProduct.getId()
        );

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

        ResponseEntity<Product> checkProductById = restTemplate.exchange(
                ROOT + GET_ID + "{id}",
                HttpMethod.GET,
                null,
                Product.class,
                createdProduct.getId()
        );

        assertEquals(HttpStatus.OK, checkProductById.getStatusCode());
        assertNull(checkProductById.getBody());
    }
*/
}

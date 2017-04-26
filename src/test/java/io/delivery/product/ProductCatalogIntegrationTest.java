package io.delivery.product;

import io.delivery.config.AppConfig;
import io.delivery.config.HibernateConfig;
import io.delivery.entity.Product;
import io.delivery.entity.ProductCatalogSection;
import io.delivery.entity.ProductImage;
import io.delivery.service.ProductService;
import io.delivery.service.impl.ProductServiceImpl;
import org.junit.*;
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

    @Autowired
    private ProductService productService;

    private ProductCatalogSection createdCatalogSection = new ProductCatalogSection();
    private Product createdProduct = new Product();
    private ProductImage createdImage = new ProductImage();


    @Before
    public void createTestEntities() {
        createdCatalogSection.setName("PizzaTest");
        productService.addCatalogSection(createdCatalogSection);

        createdProduct.setName("Magic");
        createdProduct.setDescription("fire");
        createdProduct.setPrice(100);
        createdProduct.setProductCatalogSection(createdCatalogSection);
        productService.addProduct(createdProduct);

        createdImage.setImage(new byte[] {1, 2 , 3, 4});
        createdImage.setProduct(createdProduct);
        productService.addImage(createdImage);
    }

    @After
    public void deleteTestEntities() {
        if (createdCatalogSection != null) {
            productService.deleteCatalogSection(createdCatalogSection.getId());
        }
    }

    @Test
    public void addProduct() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        Product product = new Product();
        product.setName("Magic");
        product.setDescription("fire");
        product.setPrice(100);
        product.setProductCatalogSection(createdCatalogSection);
        HttpEntity<Product> httpEntity = new HttpEntity<>(product, headers);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Product> responseEntity = restTemplate.exchange(
                ROOT + "/addProduct",
                HttpMethod.POST,
                httpEntity,
                Product.class
        );
        Product addedProduct = responseEntity.getBody();
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(addedProduct);
        assertEquals(addedProduct.getName(), product.getName());
    }

    @Test
    public void getProductById() {
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<Product> responseEntity = restTemplate.exchange(
                ROOT + "/getProductById/" + "{id}",
                HttpMethod.GET,
                null,
                Product.class,
                createdProduct.getId()
        );
        Product resultProduct = responseEntity.getBody();
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(resultProduct);
        assertEquals(createdProduct.getName(), resultProduct.getName());
    }

    @Test
    public void getProductByName() {
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<List<Product>> result = restTemplate.exchange(
                ROOT + "/getProductsByName/" + "{name}",
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
    }

    @Test
    public void getProductByPriceRange() {
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<List<Product>> result = restTemplate.exchange(
                ROOT + "/getProductsByPriceRange/" + "{min}/{max}",
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
    }

    @Test
    public void getAllProducts() {
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<List<Product>> result = restTemplate.exchange(
                ROOT + "/getAllProducts",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Product>>() {
                }
        );
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertNotNull(result.getBody());
        List<Product> list = result.getBody();
        assertNotNull(list.get(0));
    }

    @Test
    public void updateProduct() {
        createdProduct.setName("Sword");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

        RestTemplate restTemplate = new RestTemplate();

        HttpEntity<Product> httpEntity = new HttpEntity<>(createdProduct, headers);
        ResponseEntity<Product> responseEntity = restTemplate.exchange(
               ROOT + "/updateProduct",
               HttpMethod.PUT,
               httpEntity,
               Product.class
        );
        Product updatedProduct = responseEntity.getBody();
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(updatedProduct);
        assertEquals(updatedProduct.getName(), createdProduct.getName());
    }

    @Test
    public void deleteProduct(){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.exchange(
                ROOT + "/deleteProduct/" + "{id}",
                HttpMethod.DELETE,
                null,
                String.class,
                createdProduct.getId()
        );

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

        ResponseEntity<Product> checkProductById = restTemplate.exchange(
                ROOT + "/getProductById/" + "{id}",
                HttpMethod.GET,
                null,
                Product.class,
                createdProduct.getId()
        );

        assertEquals(HttpStatus.OK, checkProductById.getStatusCode());
        assertNull(checkProductById.getBody());
    }
}

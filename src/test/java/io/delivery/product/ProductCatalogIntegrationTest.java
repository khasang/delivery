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
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.*;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class, ProductServiceImpl.class, HibernateConfig.class})
public class ProductCatalogIntegrationTest {
    private final String ROOT = "http://localhost:8080/products";

    @Autowired
    private ProductService productService;

    private List<ProductCatalogSection> createdCatalogSections = new ArrayList<>();
    private ProductCatalogSection createdSection = new ProductCatalogSection();
    private Product createdProduct = new Product();
    private ProductImage createdImage = new ProductImage();

    @Before
    public void createTestEntities() {
        createdSection.setName("PizzaTest");
        productService.addCatalogSection(createdSection);

        createdProduct.setName("Magic");
        createdProduct.setDescription("fire");
        createdProduct.setPrice(100);
        createdProduct.setProductCatalogSection(createdSection);
        productService.addProduct(createdProduct);

        createdImage.setImage(new byte[] {1, 2 , 3, 4});
        createdImage.setProduct(createdProduct);
        productService.addImage(createdImage);

        List<ProductImage> imageList = new ArrayList<>();
        imageList.add(createdImage);
        createdProduct.setImages(imageList);

        List<Product> productList = new ArrayList<>();
        productList.add(createdProduct);
        createdSection.setProducts(productList);

        createdCatalogSections.add(createdSection);
    }

    @After
    public void deleteTestEntities() {
        for (ProductCatalogSection section : createdCatalogSections) {
            productService.deleteCatalogSection(section.getId());
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
        product.setProductCatalogSection(createdCatalogSections.get(0));
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
    public void getProductsByCatalogSectionId() {
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<List<Product>> result = restTemplate.exchange(
                ROOT + "/getProductsByCatalogSectionId/" + "{id}",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Product>>() {
                },
                createdSection.getId()
        );
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertNotNull(result.getBody());
        List<Product> list = result.getBody();
        assertNotNull(list.get(0));
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

    @Test
    public void getAllCatalogSections() {
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<List<ProductCatalogSection>> result = restTemplate.exchange(
                ROOT + "/getAllCatalogSections",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<ProductCatalogSection>>() {
                }
        );
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertNotNull(result.getBody());
        List<ProductCatalogSection> list = result.getBody();
        assertNotNull(list.get(0));
    }

    @Test
    public void addCatalogSection() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        ProductCatalogSection section = new ProductCatalogSection();
        section.setName("Magic");
        HttpEntity<ProductCatalogSection> httpEntity = new HttpEntity<>(section, headers);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<ProductCatalogSection> responseEntity = restTemplate.exchange(
                ROOT + "/addCatalogSection",
                HttpMethod.POST,
                httpEntity,
                ProductCatalogSection.class
        );
        ProductCatalogSection addedSection = responseEntity.getBody();
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(addedSection);
        assertEquals(addedSection.getName(), section.getName());
        createdCatalogSections.add(addedSection);
    }

    @Test
    public void updateCatalogSection() {
        createdSection.setName("Sword");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

        RestTemplate restTemplate = new RestTemplate();

        HttpEntity<ProductCatalogSection> httpEntity = new HttpEntity<>(createdSection, headers);
        ResponseEntity<ProductCatalogSection> responseEntity = restTemplate.exchange(
                ROOT + "/updateCatalogSection",
                HttpMethod.PUT,
                httpEntity,
                ProductCatalogSection.class
        );
        ProductCatalogSection updatedSection = responseEntity.getBody();
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(updatedSection);
        assertEquals(updatedSection.getName(), createdSection.getName());
    }

    @Test
    public void deleteCatalogSection(){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.exchange(
                ROOT + "/deleteCatalogSection/" + "{id}",
                HttpMethod.DELETE,
                null,
                String.class,
                createdSection.getId()
        );

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

        ResponseEntity<Product> checkSectionById = restTemplate.exchange(
                ROOT + "/getCatalogSectionById/" + "{id}",
                HttpMethod.GET,
                null,
                Product.class,
                createdSection.getId()
        );

        assertEquals(HttpStatus.OK, checkSectionById.getStatusCode());
        assertNull(checkSectionById.getBody());

        createdCatalogSections.remove(createdSection);
    }

    @Test
    public void getCatalogSectionById() {
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<ProductCatalogSection> responseEntity = restTemplate.exchange(
                ROOT + "/getCatalogSectionById/" + "{id}",
                HttpMethod.GET,
                null,
                ProductCatalogSection.class,
                createdSection.getId()
        );
        ProductCatalogSection resultSection = responseEntity.getBody();
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(resultSection);
        assertEquals(createdSection.getName(), resultSection.getName());
    }

    @Test
    public void getImageIdsByProductId() {
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<List<Long>> result = restTemplate.exchange(
                ROOT + "/getImageIdsByProductId/" + "{id}",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Long>>() {
                },
                createdProduct.getId()
        );
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertNotNull(result.getBody());
        List<Long> list = result.getBody();
        assertNotNull(list.get(0));
        assertEquals((long)list.get(0), createdImage.getId());
    }

    @Test
    public void deleteImage(){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.exchange(
                ROOT + "/deleteImage/" + "{id}",
                HttpMethod.DELETE,
                null,
                String.class,
                createdImage.getId()
        );
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

        ResponseEntity<List<Long>> result = restTemplate.exchange(
                ROOT + "/getImageIdsByProductId/" + "{id}",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Long>>() {
                },
                createdProduct.getId()
        );
        assertEquals(HttpStatus.OK, result.getStatusCode());
        List<Long> list = result.getBody();
        assertTrue(list.isEmpty());
    }

    @Test
    public void getImageById() {
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<byte[]> responseEntity = restTemplate.exchange(
                ROOT + "/getImageById/" + "{id}",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<byte[]>() {
                },
                createdImage.getId()
        );
        byte[] result = responseEntity.getBody();
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertArrayEquals(result, createdImage.getImage());
    }

    @Test
    public void addImage() {
        MultiValueMap<String, Object> formData = new LinkedMultiValueMap<>();

        ByteArrayResource imageResource = new ByteArrayResource(createdImage.getImage()) {
            @Override
            public String getFilename() {
                return "test.jpeg";
            }
        };
        HttpHeaders fileHeaders = new HttpHeaders();
        fileHeaders.setContentType(MediaType.IMAGE_JPEG);
        HttpEntity<ByteArrayResource> fileEntity = new HttpEntity<>(imageResource, fileHeaders);
        formData.add("file", fileEntity);

        HttpHeaders productHeaders = new HttpHeaders();
        productHeaders.setContentType(MediaType.TEXT_PLAIN);
        HttpEntity<String> productEntity = new HttpEntity<>(Long.toString(createdProduct.getId()), productHeaders);
        formData.add("productId", productEntity);

        HttpHeaders formHeaders = new HttpHeaders();
        formHeaders.setContentType(MediaType.MULTIPART_FORM_DATA);
        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(formData, formHeaders);

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<Long> responseEntity = restTemplate.exchange(
                ROOT + "/addImage",
                HttpMethod.POST,
                requestEntity,
                Long.class
        );
        long result = responseEntity.getBody();
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotEquals(result, 0l);
    }
}

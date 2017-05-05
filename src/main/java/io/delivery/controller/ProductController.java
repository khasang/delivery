package io.delivery.controller;

import io.delivery.entity.Product;
import io.delivery.entity.ProductCatalogSection;
import io.delivery.entity.ProductImage;
import io.delivery.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    final private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(value = "/getAllProducts", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @RequestMapping(value = "/getProductsByName/{name}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public List<Product> getProductsByName(@PathVariable(value = "name") String name){
        return productService.getProductsByName(name);
    }

    @RequestMapping(value = "/addProduct", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Product addProduct(@RequestBody Product product){
        productService.addProduct(product);
        return product;
    }

    @RequestMapping(value = "/updateProduct", method = RequestMethod.PUT, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Product updateProduct(@RequestBody Product product){
        productService.updateProduct(product);
        return product;
    }

    @RequestMapping(value = "/deleteProduct/{id}", method = RequestMethod.DELETE, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Product deleteProduct(@PathVariable(value = "id") String inputId){
        return productService.deleteProduct(Long.parseLong(inputId));
    }

    @RequestMapping(value = "/getProductById/{id}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Product getProductById(@PathVariable(value = "id") String id){
        return productService.getProductById(Long.parseLong(id));
    }

    @RequestMapping(value = "/getProductsByPriceRange/{min}/{max}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public List<Product> getProductsByPriceRange(@PathVariable(value = "min") int min, @PathVariable(value = "max") int max) {
        return productService.getProductsByPriceRange(min, max);
    }

    @RequestMapping(value = "/getProductsByCatalogSectionId/{id}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public List<Product> getProductsByCatalogSectionId(@PathVariable(value = "id") String id)
    {
        return productService.getProductsByCatalogSectionId(Long.parseLong(id));
    }

    @GetMapping(value = "/images/add")
    public String productImageUploadForm() {
        return "uploadProductImage";
    }

    @GetMapping(value = "/images/show")
    public String showProductImage() {
        return "showProductImage";
    }

    @RequestMapping(value = "/addImage", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Long uploadProductImage(@RequestParam("file") MultipartFile file,
                                   @RequestParam("productId") String productId) {
        if (!file.getContentType().equals(MediaType.IMAGE_JPEG_VALUE)) {
            return null;
        }
        ProductImage image = new ProductImage();
        image.setProduct(productService.getProductById(Long.parseLong(productId)));
        try {
            image.setImage(file.getBytes());
            productService.addImage(image);
            return image.getId();
        }
        catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(value = "/deleteImage/{id}", method = RequestMethod.DELETE, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Long deleteImage(@PathVariable(value = "id") String inputId){
        productService.deleteImage(Long.parseLong(inputId));
        return Long.parseLong(inputId);
    }

    @RequestMapping(value = "/getImageIdsByProductId/{id}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public List<Long> getImageIdsByProductId(@PathVariable(value = "id") String productId) {
        List<Long> result = new ArrayList<>();
        for (ProductImage image : productService.getImagesByProductId(Long.parseLong(productId))) {
            result.add(image.getId());
        }
        return result;
    }

    @RequestMapping(value = "/getImageById/{id}", method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
    @ResponseBody
    public byte[] getImageById(@PathVariable(value = "id") String id)
    {
        return productService.getImageById(Long.parseLong(id)).getImage();
    }

    @RequestMapping(value = "/getAllCatalogSections", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public List<ProductCatalogSection> getAllCatalogSections(){
        return productService.getAllCatalogSections();
    }

    @RequestMapping(value = "/addCatalogSection", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public ProductCatalogSection addCatalogSection(@RequestBody ProductCatalogSection section){
        productService.addCatalogSection(section);
        return section;
    }

    @RequestMapping(value = "/updateCatalogSection", method = RequestMethod.PUT, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public ProductCatalogSection updateCatalogSection(@RequestBody ProductCatalogSection section){
        productService.updateCatalogSection(section);
        return section;
    }

    @RequestMapping(value = "deleteCatalogSection/{id}", method = RequestMethod.DELETE, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public ProductCatalogSection deleteCatalogSection(@PathVariable(value = "id") String inputId){
        return productService.deleteCatalogSection(Long.parseLong(inputId));
    }

    @RequestMapping(value = "/getCatalogSectionById/{id}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public ProductCatalogSection getCatalogSectionById(@PathVariable(value = "id") String id){
        return productService.getCatalogSectionById(Long.parseLong(id));
    }
}

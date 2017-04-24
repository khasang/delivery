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
@RequestMapping("/product")
public class ProductController {
    final private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(value = "/getAllProducts", method = RequestMethod.GET)
    @ResponseBody
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @RequestMapping(value = "/getProductsByName/{name}", method = RequestMethod.GET)
    @ResponseBody
    public List<Product> getProductsByName(@PathVariable(value = "name") String name){
        return productService.getProductsByName(name);
    }

    @RequestMapping(value = "/createProduct", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Product addProduct(@RequestBody Product product){
        productService.createProduct(product);
        return product;
    }

    @RequestMapping(value = "/updateProduct", method = RequestMethod.PUT, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Product updateProduct(@RequestBody Product product){
        productService.updateProduct(product);
        return product;
    }

    @RequestMapping(value = "/deleteProduct/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Product deleteProduct(@PathVariable(value = "id") String inputId){
        return productService.deleteProduct(Long.parseLong(inputId));
    }

    @RequestMapping(value = "/getProductById/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Product getProductById(@PathVariable(value = "id") String id){
        return productService.getProductById(Long.parseLong(id));
    }

    @RequestMapping(value = "/getProductsByPriceRange/{min}/{max}", method = RequestMethod.GET)
    @ResponseBody
    public List<Product> getProductsByPriceRange(@PathVariable(value = "min") int min, @PathVariable(value = "max") int max) {
        return productService.getProductsByPriceRange(min, max);
    }

    @GetMapping(value = "/images/add")
    public String showProductImageUploadForm() {
        return "uploadProductImage";
    }

    @PostMapping(value = "/images/upload", produces = MediaType.IMAGE_JPEG_VALUE)
    @ResponseBody
    public byte[] uploadProductImage(@RequestParam("file") MultipartFile file,
                           @RequestParam("productId") String productId) {
        if (!file.getContentType().equals(MediaType.IMAGE_JPEG_VALUE))
                return null;
        ProductImage image = new ProductImage();
        image.setProduct(productService.getProductById(Long.parseLong(productId)));
        try {
            image.setImage(file.getBytes());
            productService.createImage(image);
            return image.getImage();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(value = "/deleteImage/{id}", method = RequestMethod.DELETE, produces = MediaType.IMAGE_JPEG_VALUE)
    @ResponseBody
    public byte[] deleteImage(@PathVariable(value = "id") String inputId){
        return productService.deleteImage(Long.parseLong(inputId)).getImage();
    }

    @RequestMapping(value = "/getImageIdsByProductId/{id}", method = RequestMethod.GET)
    @ResponseBody
    public List<Long> getImageIdsByProductId(@PathVariable(value = "id") String productId) {
        List<Long> result = new ArrayList<>();
        for (ProductImage image:productService.getImageIdsByProductId(Long.parseLong(productId))) {
            result.add(image.getId());
        }
        return result;
    }

    @GetMapping(value = "getImageById/{id}")
    @ResponseBody
    public ProductImage getImageById(@PathVariable(value = "id") String id)
    {
        return productService.getImageById(Long.parseLong(id));
    }

    @RequestMapping(value = "/getAllCatalogSections", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public List<ProductCatalogSection> getAllCatalogSections(){
        return productService.getAllCatalogSections();
    }

    @RequestMapping(value = "/createCatalogSection", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public ProductCatalogSection createCatalogSection(@RequestBody ProductCatalogSection section){
        productService.createCatalogSection(section);
        return section;
    }

    @RequestMapping(value = "/updateCatalogSection", method = RequestMethod.PUT, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public ProductCatalogSection updateCatalogSection(@RequestBody ProductCatalogSection section){
        productService.updateCatalogSection(section);
        return section;
    }

    @RequestMapping(value = "deleteCatalogSection/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public ProductCatalogSection deleteCatalogSection(@PathVariable(value = "id") String inputId){
        return productService.deleteCatalogSection(Long.parseLong(inputId));
    }

    @RequestMapping(value = "/getCatalogSectionById/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ProductCatalogSection getCatalogSectionById(@PathVariable(value = "id") String id){
        return productService.getCatalogSectionById(Long.parseLong(id));
    }
}

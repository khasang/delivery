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

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public List<Product> getProductList(){
        return productService.getAll();
    }

    @RequestMapping(value = "/get/name/{name}", method = RequestMethod.GET)
    @ResponseBody
    public List<Product> getProductByName(@PathVariable(value = "name") String name){
        return productService.findByName(name);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Product addProduct(@RequestBody Product product){
        productService.create(product);
        return product;
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Product updateProduct(@RequestBody Product product){
        productService.update(product);
        return product;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Product deleteProduct(@PathVariable(value = "id") String inputId){
        return productService.delete(Long.parseLong(inputId));
    }

    @RequestMapping(value = "/get/id/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Product getProductById(@PathVariable(value = "id") String id){
        return productService.findById(Long.parseLong(id));
    }

    @RequestMapping(value = "/get/price/{min}/{max}", method = RequestMethod.GET)
    @ResponseBody
    public List<Product> getProductByPriceRange(@PathVariable(value = "min") int min, @PathVariable(value = "max") int max) {
        return productService.findByPriceRange(min, max);
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
        image.setProduct(productService.findById(Long.parseLong(productId)));
        try {
            image.setImage(file.getBytes());
            productService.createImage(image);
            return image.getImage();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(value = "/images/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.IMAGE_JPEG_VALUE)
    @ResponseBody
    public byte[] deleteImage(@PathVariable(value = "id") String inputId){
        return productService.deleteImage(Long.parseLong(inputId)).getImage();
    }

    @RequestMapping(value = "/images/product/{id}", method = RequestMethod.GET)
    @ResponseBody
    public List<Long> getImagesIdsByProductId(@PathVariable(value = "id") String productId) {
        List<Long> result = new ArrayList<>();
        for (ProductImage image:productService.getImagesByProductId(Long.parseLong(productId))) {
            result.add(image.getId());
        }
        return result;
    }

    @GetMapping(value = "images/id/{id}")
    @ResponseBody
    public ProductImage getImageById(@PathVariable(value = "id") String id)
    {
        return productService.getImageById(Long.parseLong(id));
    }

    @RequestMapping(value = "/sections/all", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public List<ProductCatalogSection> getCatalogSections(){
        return productService.getCatalogSections();
    }

    @RequestMapping(value = "/sections/add", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public ProductCatalogSection addCatalogSection(@RequestBody ProductCatalogSection section){
        productService.createCatalogSection(section);
        return section;
    }

    @RequestMapping(value = "/sections/update", method = RequestMethod.PUT, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public ProductCatalogSection updateCatalogSection(@RequestBody ProductCatalogSection section){
        productService.updateCatalogSection(section);
        return section;
    }

    @RequestMapping(value = "sections/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public ProductCatalogSection deleteCatalogSection(@PathVariable(value = "id") String inputId){
        return productService.deleteCatalogSection(Long.parseLong(inputId));
    }

    @RequestMapping(value = "/sections/id/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ProductCatalogSection getCatalogSectionById(@PathVariable(value = "id") String id){
        return productService.getCatalogSectionById(Long.parseLong(id));
    }
}

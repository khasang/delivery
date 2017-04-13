package io.delivery.controller;

import io.delivery.entity.Product;
import io.delivery.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    public List<Product> getProductWithPriceBetween(@PathVariable(value = "min") int min, @PathVariable(value = "max") int max) {
        return productService.findWithPriceBetween(min, max);
}
}

package com.example.ProductServiceAug24.controllers;

import com.example.ProductServiceAug24.models.Product;
import com.example.ProductServiceAug24.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("products")
@RestController
public class ProductController {
    @Autowired
    private ProductService productService;
    // GET products/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") int productid) {
        if(productid <1 || productid > 20){
            return new ResponseEntity<Product>(HttpStatusCode.valueOf(400));
        }
         Product product = productService.getProductById(productid);
        return new ResponseEntity<>(product,HttpStatusCode.valueOf(200));
    }
}

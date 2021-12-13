package com.developerprince.yuppie.chef.review.service.controllers;

import com.developerprince.yuppie.chef.review.service.models.ProductDto;
import com.developerprince.yuppie.chef.review.service.services.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(value = "/api/v1/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/{id}")
    public ResponseEntity<Object> getProductById(@PathVariable("id") Long id){
        return productService.retrieveProductById(id);
    }

    @PostMapping("/")
    public  ResponseEntity<Object> saveProduct(@RequestBody ProductDto productDto){
        return productService.saveProduct( productDto );
    }

    @GetMapping("/store/{id}")
    public ResponseEntity<Object> getAllProducts(@PathVariable("id")Long storeId){
        return productService.retrieveAllProductByStoreId(storeId);
    }
}

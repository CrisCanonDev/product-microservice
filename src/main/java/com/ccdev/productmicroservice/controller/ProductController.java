package com.ccdev.productmicroservice.controller;

import com.ccdev.productmicroservice.Repository.ProductRepository;
import com.ccdev.productmicroservice.entity.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductEntity> getAllProducts(Model model){
        return productRepository.findAll();
    }

//    public ResponseEntity<List<ProductEntity>> getAllProducts(){
//        List<ProductEntity> products = productRepository.findAll();
//        ResponseEntity<List<ProductEntity>> response = new ResponseEntity<>(products, HttpStatus.OK);
//        return response;
//    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void createProduct(@RequestBody ProductEntity product){
        productRepository.save(product);
    }
}

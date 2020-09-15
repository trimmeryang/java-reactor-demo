package com.trimmer.demo.controller;

import com.trimmer.demo.domain.Product;
import com.trimmer.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("")
    public Flux<Product> getProducts() {
        return this.productService.getProducts();
    }

    @GetMapping("/{id}")
    public Mono<Product> getProductById(@PathVariable("id") final String id) {
        return this.productService.getProductsById(id);
    }

    @PostMapping("")
    public Mono<Void> CreateProduct(@RequestBody final Mono<Product> product) {
        return this.productService.createOrUpdateProduct(product);
    }

    @DeleteMapping("/{id}")
    public Mono<Product> delete(@PathVariable("id") final String id) {
        return this.productService.deleteProduct(id);
    }
}

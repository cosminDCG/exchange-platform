package com.platform.exchange.controller;

import com.platform.exchange.model.Product;
import com.platform.exchange.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.UUID;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ResponseEntity<Product>> createProduct(@RequestBody Product product) {
        return Mono.fromCallable(() -> productService.saveProduct(product))
                .subscribeOn(Schedulers.boundedElastic())
                .map(ResponseEntity::ok);
    }

    @GetMapping(path = "/{productId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ResponseEntity<Product>> getProductById(@PathVariable("productId") String productId) {
        return Mono.fromCallable(() -> productService.getProduct(productId))
                .subscribeOn(Schedulers.boundedElastic())
                .map(ResponseEntity::ok);
    }

    @PutMapping(value = "/{productId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ResponseEntity<Product>> updateProduct(@PathVariable("productId") String productId,@RequestBody Product product) {
        product.setId(UUID.fromString(productId));
        return Mono.fromCallable(() -> productService.updateProduct(product))
                .subscribeOn(Schedulers.boundedElastic())
                .map(ResponseEntity::ok);
    }

    @DeleteMapping(value = "{productId}")
    public Mono<ResponseEntity<Void>> deleteProduct(@PathVariable("productId") String productId) {
        return Mono.fromRunnable(() -> productService.deleteProduct(productId))
                .subscribeOn(Schedulers.boundedElastic())
                .thenReturn(ResponseEntity.accepted().build());
    }
}

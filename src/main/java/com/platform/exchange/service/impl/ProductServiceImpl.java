package com.platform.exchange.service.impl;

import com.platform.exchange.exception.ErrorMessage;
import com.platform.exchange.exception.OutOfProductsException;
import com.platform.exchange.exception.ProductNotFoundException;
import com.platform.exchange.model.Product;
import com.platform.exchange.model.User;
import com.platform.exchange.repository.ProductRepository;
import com.platform.exchange.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    @Transactional
    public Product saveProduct(Product product) {
        product.setId(UUID.randomUUID());
        return productRepository.save(product);
    }

    @Override
    @Transactional
    public void deleteProduct(String uuid) {
        Product product = productRepository.findById(UUID.fromString(uuid))
                                           .orElseThrow(() -> new ProductNotFoundException(ErrorMessage.PRODUCT_NOT_FOUND));
        productRepository.delete(product);
    }

    @Override
    @Transactional
    public Product updateProduct(Product product) {
        productRepository.findById(product.getId())
                         .orElseThrow(() -> new ProductNotFoundException(ErrorMessage.PRODUCT_NOT_FOUND));
        return productRepository.save(product);
    }

    @Override
    public Product getProduct(String uuid) {
        return productRepository.findById(UUID.fromString(uuid))
                                .orElseThrow(() -> new ProductNotFoundException(ErrorMessage.PRODUCT_NOT_FOUND));
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> products = productRepository.findAll();
        if (products.size() == 0) {
            throw new OutOfProductsException(ErrorMessage.OUT_OF_PRODUCTS);
        }
        return products;
    }

    @Override
    public List<Product> getProductsByUserUUID(String uuid) {
        User user = new User(UUID.fromString(uuid));
        List<Product> products = productRepository.findAllBySeller(user);
        if (products.size() == 0) {
            throw new OutOfProductsException(ErrorMessage.OUT_OF_PRODUCTS);
        }
        return null;
    }

    @Override
    public List<Product> getAvailableProducts() {
        return null;
    }

    @Override
    public List<Product> getAvailableProductsByUserUUID(String uuid) {
        return null;
    }
}

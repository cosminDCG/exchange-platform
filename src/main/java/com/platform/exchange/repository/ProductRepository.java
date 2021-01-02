package com.platform.exchange.repository;

import com.platform.exchange.model.Product;
import com.platform.exchange.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {

    List<Product> findAllBySeller(User user);
}

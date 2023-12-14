package com.example.demo.config;

import java.util.*;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.model.Product;
import com.example.demo.model.Product.Category;
import com.example.demo.repository.ProductRepository;

@Component
public class DataInitializer implements CommandLineRunner {

    private final ProductRepository productRepository;

    public DataInitializer(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void run(String... args) {
        initializeProducts();
    }

    private void initializeProducts() {
        Product tShirt1 = new Product("Fnatic T-Shirt", "Comfortable T-Shirt", 19.99, Product.Size.M, Category.T_SHIRTS, "fnaticTshirt.jpg");
        Product tShirt2 = new Product("NiP T-Shirt", "Casual T-Shirt", 24.99, Product.Size.L, Category.T_SHIRTS, "nipTshirt.jpg");
        Product tShirt3 = new Product("Team Liquid T-Shirt", "Sporty T-Shirt", 29.99, Product.Size.S, Category.T_SHIRTS, "liquidTshirt.jpg");

        Product hoodie1 = new Product("Astralis Hoodie", "Warm Hoodie", 59.99, Product.Size.M, Category.HOODIES, "astralisHoodie.jpg");
        Product hoodie2 = new Product("ESL Hoodie", "Fashionable Hoodie", 44.99, Product.Size.L, Category.HOODIES, "eslHoodie.jpg");
        Product hoodie3 = new Product("TSM Hoodie", "Cozy Hoodie", 49.99, Product.Size.S, Category.HOODIES, "tsmHoodie.jpg");

        productRepository.saveAll(List.of(tShirt1, tShirt2, tShirt3, hoodie1, hoodie2, hoodie3));
    }
}


package dev.surya.productservice.services;

import dev.surya.productservice.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {


    List<Product> getAllProducts();

    Product getProductById(Long id);
}

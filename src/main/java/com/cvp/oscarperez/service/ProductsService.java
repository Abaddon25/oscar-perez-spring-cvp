package com.cvp.oscarperez.service;

import com.cvp.oscarperez.dto.ProductDto;
import com.cvp.oscarperez.entities.Product;
import com.cvp.oscarperez.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductsService {

  @Autowired
  ProductRepository productRepository;

  public List<Product> getAll() {
    return productRepository.findAll();
  }

  public Optional<Product> getOne(String id) {
    if (!productRepository.existsById(id)) {
      return null;
    }
    return productRepository.findById(id);
  }

  public Product addOne(ProductDto product) {
    if (productRepository.existsByName(product.getName())) {
      return null;
    }
    Product productNew = Product.builder()
        .name(product.getName())
        .description(product.getDescription())
        .price(product.getPrice())
        .amount(product.getAmount())
        .build();
    return productRepository.save(productNew);
  }

  public Product updateOne(String id, Product product) {
    if (!productRepository.existsById(id)) {
      return null;
    }
    Product productUpdate = Product.builder()
        .id(product.getId())
        .name(product.getName())
        .description(product.getDescription())
        .price(product.getPrice())
        .amount(product.getAmount())
        .build();
    return productRepository.save(productUpdate);
  }
}

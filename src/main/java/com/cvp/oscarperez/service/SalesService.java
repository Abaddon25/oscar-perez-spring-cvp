package com.cvp.oscarperez.service;

import com.cvp.oscarperez.dto.SalesDto;
import com.cvp.oscarperez.entities.Product;
import com.cvp.oscarperez.entities.Sale;
import com.cvp.oscarperez.repository.ProductRepository;
import com.cvp.oscarperez.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SalesService {
  @Autowired
  SaleRepository saleRepository;

  @Autowired
  ProductRepository productRepository;

  public Object addOne(SalesDto sales) {
    if (!productRepository.existsById(sales.getProduct().getId())) {
      return "not found";
    }

    Product product = productRepository.findById(sales.getProduct().getId()).get();
    if (product.getAmount() < sales.getAmount()) {
      return "not enough";
    }
    Product productUpdate = Product.builder()
        .id(product.getId())
        .name(product.getName())
        .description(product.getDescription())
        .price(product.getPrice())
        .amount(product.getAmount() - sales.getAmount())
        .build();

    productRepository.save(productUpdate);

    Sale saleNew = Sale.builder()
        .subTotal(sales.getSubTotal())
        .amount(sales.getAmount())
        .product(productUpdate)
        .build();
    return saleRepository.save(saleNew);
  }
}

package com.cvp.oscarperez.repository;

import com.cvp.oscarperez.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {

  public boolean existsByName(String name);
}
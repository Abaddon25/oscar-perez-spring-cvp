package com.cvp.oscarperez.controller;

import com.cvp.oscarperez.common.ResponseHandler;
import com.cvp.oscarperez.dto.ProductDto;
import com.cvp.oscarperez.entities.Product;
import com.cvp.oscarperez.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductsController {

  @Autowired
  ProductsService productsService;

  @GetMapping
  public ResponseEntity<?> getAll() {
    List<Product> data = productsService.getAll();
    return ResponseHandler.generateResponse("Productos cargados correctamente", HttpStatus.OK, data);
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> getOne(@PathVariable String id) {
    Optional<Product> data = productsService.getOne(id);
    if (data == null) {
      return ResponseHandler.generateResponse("Producto no encontrado", HttpStatus.NOT_FOUND, null);
    }
    return ResponseHandler.generateResponse("Producto cargado correctamente", HttpStatus.OK, data);
  }

  @PostMapping
  public ResponseEntity<?> addOne(@RequestBody ProductDto productDto) {
    Product data = productsService.addOne(productDto);
    if (data == null) {
      return ResponseHandler.generateResponse("Nombre del producto ya existe", HttpStatus.CONFLICT, null);
    }
    return ResponseHandler.generateResponse("Producto guardado correctamente", HttpStatus.OK, data);
  }

  @PutMapping("/{id}")
  public ResponseEntity<?> updateOne(@PathVariable String id, @RequestBody Product product) {
    Product data = productsService.updateOne(id, product);
    if (data == null) {
      return ResponseHandler.generateResponse("Producto no encontrado", HttpStatus.NOT_FOUND, null);
    }
    return ResponseHandler.generateResponse("Productos actualizados correctamente", HttpStatus.OK, data);
  }
}

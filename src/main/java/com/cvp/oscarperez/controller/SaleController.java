package com.cvp.oscarperez.controller;

import com.cvp.oscarperez.common.ResponseHandler;
import com.cvp.oscarperez.dto.SalesDto;
import com.cvp.oscarperez.service.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sales")
public class SaleController {

  @Autowired
  SalesService salesService;

  @PostMapping
  public ResponseEntity<?> addOne(@RequestBody SalesDto salesDto) {
    Object data = salesService.addOne(salesDto);
    if (data == "not enough" || data == "not found") {
      String message = data == "not found" ? "Producto no encontrado" : "Cantidad insuficiente";
      return ResponseHandler.generateResponse(message, HttpStatus.CONFLICT, null);
    }
    return ResponseHandler.generateResponse("Venta guardada correctamente", HttpStatus.OK, data);
  }
}

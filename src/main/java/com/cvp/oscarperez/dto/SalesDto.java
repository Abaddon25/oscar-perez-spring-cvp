package com.cvp.oscarperez.dto;

import com.cvp.oscarperez.entities.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class SalesDto {
  private Long subTotal;
  private Integer amount;
  private Product product;
}

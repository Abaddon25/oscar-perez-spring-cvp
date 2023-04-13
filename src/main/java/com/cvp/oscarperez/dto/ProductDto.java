package com.cvp.oscarperez.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ProductDto {
  private String name;
  private String description;
  private Long price;
  private Integer amount;
}

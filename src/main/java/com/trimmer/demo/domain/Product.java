package com.trimmer.demo.domain;

import lombok.Data;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
public class Product {
    private String id;
    private String productCode;
    private String productName;
    private String description;
    private Float price;
}

package com.inventory.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class Product {
    private String id;
    private String name;
    private Category category;
    @Setter
    private int inStockQuantity;
}

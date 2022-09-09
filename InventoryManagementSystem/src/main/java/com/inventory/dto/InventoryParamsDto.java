package com.inventory.dto;

import com.inventory.model.Category;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@ToString
public class InventoryParamsDto {
    private String productId;
    private String productName;
    private int productCount;
    private Category category;
}

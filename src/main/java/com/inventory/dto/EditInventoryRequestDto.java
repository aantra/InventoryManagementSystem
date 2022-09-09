package com.inventory.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class EditInventoryRequestDto {
    private String productName;
    private int quantity;
}

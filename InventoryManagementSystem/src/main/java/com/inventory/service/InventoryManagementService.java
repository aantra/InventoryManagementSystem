package com.inventory.service;

import com.inventory.dto.EditInventoryRequestDto;
import com.inventory.dto.InventoryParamsDto;
import com.inventory.model.Inventory;
import lombok.Getter;

import java.util.UUID;

public class InventoryManagementService {
    private final Inventory inventory;
    @Getter
    private final InventorySearchService userSerachService;

    public InventoryManagementService(final String id, final String name) {
        this.inventory = new Inventory(id, name);
        this.userSerachService = new InventorySearchServiceImpl(this.inventory);
    }

    public String addInventory(InventoryParamsDto inventoryParamsDto) {
        return inventory.addProduct(inventoryParamsDto);
    }

    public void modifyInventory(EditInventoryRequestDto editInventoryRequestDto) {
        inventory.modifyProduct(editInventoryRequestDto);
    }

    public void deleteInventory(String productName) {
        inventory.deleteProduct(productName);
    }

}

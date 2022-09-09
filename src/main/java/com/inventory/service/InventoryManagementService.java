package com.inventory.service;

import com.inventory.dto.EditInventoryRequestDto;
import com.inventory.dto.InventoryParamsDto;
import com.inventory.model.Inventory;
import lombok.Getter;

public class InventoryManagementService {
    private final Inventory inventory;
    @Getter
    private final InventorySearchService userSearchService;

    public InventoryManagementService(final String id, final String name) {
        this.inventory = new Inventory(id, name);
        this.userSearchService = new InventorySearchServiceImpl(this.inventory);
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

package com.inventory.service;

import com.inventory.model.Inventory;
import com.inventory.model.Product;

import java.util.HashMap;
import java.util.List;

public class InventorySearchServiceImpl implements InventorySearchService{
    private final Inventory inventory;

    public InventorySearchServiceImpl(Inventory inventory) {
        this.inventory = inventory;
    }

    @Override
    public List<Product> searchByKeyword(String name) {
        return inventory.searchByKeyword(name);
    }
}

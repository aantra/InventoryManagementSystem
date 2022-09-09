package com.inventory.service;

import com.inventory.model.Inventory;
import com.inventory.model.Product;

import java.util.List;

public interface InventorySearchService {

    List<Product> searchByKeyword(String name);
}
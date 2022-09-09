package com.inventory.exception;

public class InvalidCategoryException extends InventoryManagementException {
    public InvalidCategoryException() {
        super("Invalid category - this category does not exist in Inventory");
    }
}

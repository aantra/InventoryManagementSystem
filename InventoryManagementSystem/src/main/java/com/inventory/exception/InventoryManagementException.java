package com.inventory.exception;

public class InventoryManagementException extends RuntimeException{

    public InventoryManagementException() {
    }

    public InventoryManagementException(String message) {
        super(message);
    }
}

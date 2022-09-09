package com.inventory.model;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class User extends Person{
    public User(final String id, final String name) {
        super(id, name);
    }

    public List<Inventory> searchInventory(String keyword){
        List<Inventory> inventoryList = new ArrayList<>();
        return inventoryList;
    }
}

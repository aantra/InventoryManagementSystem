package com.inventory.model;

import com.inventory.dto.InventoryParamsDto;
import lombok.Getter;

@Getter
public class SystemAdmin extends User{

    public SystemAdmin(String id, String name) {
        super(id, name);
    }

    String addInventory(InventoryParamsDto inventoryParamsDto){
return "";
    }

}

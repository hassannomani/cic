package com.nbr.trp.inventory.service;

import com.nbr.trp.inventory.entity.Inventory;
import com.nbr.trp.inventory.repository.InventoryRepository;
import com.nbr.trp.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryServiceImpl implements InventoryService{
    @Autowired
    private InventoryRepository inventoryRepository;

    @Override
    public Inventory saveInventory(Inventory in) {
        return null;
    }

    @Override
    public List<Inventory> getAllInventory() {
        return null;
    }

    @Override
    public Inventory getInventory(String id) {
        return null;
    }
}

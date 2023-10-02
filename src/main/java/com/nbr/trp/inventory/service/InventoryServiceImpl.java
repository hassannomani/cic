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
        return inventoryRepository.save(in);
    }

    @Override
    public List<Inventory> getAllInventory() {
        return inventoryRepository.findAll();
    }

    @Override
    public Inventory getInventory(String id) {
        return inventoryRepository.findByInventoriid(id);
    }

    @Override
    public Boolean deleteInventory(String id){
        inventoryRepository.deleteByInventoriid(id);
        return true;
    }

    @Override
    public Inventory updateInventory(Inventory in) {
        String invent = in.getInventoriid();
        Inventory inventory = inventoryRepository.findByInventoriid(invent);
        inventory.setName(inventory.getName());
        inventory.setQuantity(inventory.getQuantity());
        inventory.setPicture(inventory.getPicture());
        return inventoryRepository.save(inventory);
    }

}

package com.nbr.trp.inventory.service;

import com.nbr.trp.inventory.entity.Inventory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface InventoryService {

    public Inventory saveInventory(Inventory in);

    public List<Inventory> getAllInventory();

    public Inventory getInventory(String id);
}

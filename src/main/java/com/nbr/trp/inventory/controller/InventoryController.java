package com.nbr.trp.inventory.controller;

import com.nbr.trp.common.entity.LCStation;
import com.nbr.trp.inventory.entity.Inventory;
import com.nbr.trp.inventory.service.InventoryService;
import com.nbr.trp.user.response.MessageResponse;
import com.nbr.trp.user.service.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

    @Autowired
    InventoryService inventoryService;

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/add")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> addInventory(@RequestBody Inventory inventory) {
        try{
            Inventory in = inventoryService.saveInventory(inventory);
            return ResponseEntity.ok(in);
        }catch(Exception e){
            return ResponseEntity.badRequest().body(new MessageResponse(e.getMessage()));
        }
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/list")
    public ResponseEntity<?> listInventory() {
        try{
            List<Inventory> in = inventoryService.getAllInventory();
            return ResponseEntity.ok(in);
        }catch(Exception e){
            return ResponseEntity.badRequest().body(new MessageResponse(e.getMessage()));
        }
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/remove/{id}")
    public ResponseEntity<?> listInventory(@PathVariable String id) {
        try{
            SecurityContext context = SecurityContextHolder.getContext();
            Authentication authentication = context.getAuthentication();
            UserDetailsImpl userDetails1 = (UserDetailsImpl) authentication.getPrincipal();
            String des = userDetails1.getDesignation();
            if(des.equals("Director General")||des.equals("Assistant Programmer")) {
                Boolean in = inventoryService.deleteInventory(id);
                return ResponseEntity.ok(in);
            }else{
                return ResponseEntity.status(403).body("error");
            }

        }catch(Exception e){
            return ResponseEntity.badRequest().body(new MessageResponse(e.getMessage()));
        }
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/get/{id}")
    public ResponseEntity<?> getInventory(@PathVariable String id) {
        try{
            Inventory in = inventoryService.getInventory(id);
            return ResponseEntity.ok(in);
        }catch(Exception e){
            return ResponseEntity.badRequest().body(new MessageResponse(e.getMessage()));
        }
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/update")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> updateInventory(@RequestBody Inventory inventory) {
        try{
            Inventory in = inventoryService.saveInventory(inventory);
            return ResponseEntity.ok(in);
        }catch(Exception e){
            return ResponseEntity.badRequest().body(new MessageResponse(e.getMessage()));
        }
    }

}

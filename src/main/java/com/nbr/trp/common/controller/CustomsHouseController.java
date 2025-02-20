package com.nbr.trp.common.controller;

import com.nbr.trp.common.entity.CustomsHouse;
import com.nbr.trp.common.service.CustomsHouseService;
import com.nbr.trp.user.entity.Role;
import com.nbr.trp.user.entity.User;
import com.nbr.trp.user.response.MessageResponse;
import com.nbr.trp.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*", maxAge = 4800)
@RestController
@RequestMapping("/api/house")
public class CustomsHouseController {

    @Autowired
    CustomsHouseService customsHouseService;

    @PostMapping("/addhouse")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> addHouse(@RequestBody CustomsHouse customsHouse) {
        try{
            CustomsHouse house = customsHouseService.saveHouse(customsHouse);
            return ResponseEntity.ok(house);
        }catch(Exception e){
            return ResponseEntity.badRequest().body(new MessageResponse(e.getMessage()));
        }
    }

    @GetMapping("/gethouses")
    public ResponseEntity<?> getHouses() {
        try{
            List<CustomsHouse> houses = customsHouseService.getAllHouse();
            return ResponseEntity.ok(houses);
        }catch(Exception e){
            return ResponseEntity.badRequest().body(new MessageResponse(e.getMessage()));
        }
    }

    @GetMapping("/deletehouse/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> deletehouse(@PathVariable String id) {
        try{
            customsHouseService.deleteHouse(id);
            return ResponseEntity.ok(true);
        }catch(Exception e){
            return ResponseEntity.badRequest().body(new MessageResponse(e.getMessage()));
        }
    }
}

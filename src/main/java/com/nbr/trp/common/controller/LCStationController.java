package com.nbr.trp.common.controller;

import com.nbr.trp.common.entity.CustomsHouse;
import com.nbr.trp.common.entity.LCStation;
import com.nbr.trp.common.service.CustomsHouseService;
import com.nbr.trp.common.service.LCStationService;
import com.nbr.trp.user.response.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lcstation")
public class LCStationController {

    @Autowired
    LCStationService lcStationService;

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/addlcstation")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> addLCStation(@RequestBody LCStation lcStation) {
        try{
            LCStation house = lcStationService.saveLCStation(lcStation);
            return ResponseEntity.ok(house);
        }catch(Exception e){
            return ResponseEntity.badRequest().body(new MessageResponse(e.getMessage()));
        }
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/getlcstations")
    public ResponseEntity<?> getLCStations() {
        try{
            List<LCStation> stations = lcStationService.getAllStations();
            return ResponseEntity.ok(stations);
        }catch(Exception e){
            return ResponseEntity.badRequest().body(new MessageResponse(e.getMessage()));
        }
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/deletelcstation/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> deletelcstation(@PathVariable String id) {
        try{
            lcStationService.deleteStation(id);
            return ResponseEntity.ok(true);
        }catch(Exception e){
            return ResponseEntity.badRequest().body(new MessageResponse(e.getMessage()));
        }
    }
}

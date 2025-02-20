package com.nbr.trp.taxfiletracker.controller;

import com.nbr.trp.taxfiletracker.entity.TaxFileTrk;
import com.nbr.trp.taxfiletracker.entity.TaxFileTrkView;
import com.nbr.trp.taxfiletracker.service.FileTrackerService;
import com.nbr.trp.user.response.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 4800)
@RestController
@RequestMapping("/api/file-track-search")
public class FileTrackerSearchController {

    @Autowired
    FileTrackerService fileTrackerService;

    @GetMapping("/name/{name}")
    public ResponseEntity<?> getByName(@PathVariable String name) {
        try{
            List<TaxFileTrkView> taxFileTrk1 = fileTrackerService.findName(name);
            return ResponseEntity.ok(taxFileTrk1);
        }catch(Exception e){
            return ResponseEntity.badRequest().body(new MessageResponse(e.getMessage()));
        }
    }

    @GetMapping("/bin/{bin}")
    public ResponseEntity<?> getByBin(@PathVariable String bin) {
        try{
            List<TaxFileTrkView> taxFileTrk1 = fileTrackerService.findBin(bin);
            return ResponseEntity.ok(taxFileTrk1);
        }catch(Exception e){
            return ResponseEntity.badRequest().body(new MessageResponse(e.getMessage()));
        }
    }

    @GetMapping("/tin/{tin}")
    public ResponseEntity<?> getByTin(@PathVariable String tin) {
        try{
            List<TaxFileTrkView> taxFileTrk1 = fileTrackerService.findTin(tin);
            return ResponseEntity.ok(taxFileTrk1);
        }catch(Exception e){
            return ResponseEntity.badRequest().body(new MessageResponse(e.getMessage()));
        }
    }


    @GetMapping("/house/{house}")
    public ResponseEntity<?> getByHouse(@PathVariable String house) {
        try{
            List<TaxFileTrkView> taxFileTrk1 = fileTrackerService.findHouse(house);
            return ResponseEntity.ok(taxFileTrk1);
        }catch(Exception e){
            return ResponseEntity.badRequest().body(new MessageResponse(e.getMessage()));
        }
    }

    @GetMapping("/lc/{lc}")
    public ResponseEntity<?> getByLCStation(@PathVariable String lc) {
        try{
            List<TaxFileTrkView> taxFileTrk1 = fileTrackerService.findLCS(lc);
            return ResponseEntity.ok(taxFileTrk1);
        }catch(Exception e){
            return ResponseEntity.badRequest().body(new MessageResponse(e.getMessage()));
        }
    }
}

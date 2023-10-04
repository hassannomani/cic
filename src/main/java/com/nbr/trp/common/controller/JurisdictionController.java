package com.nbr.trp.common.controller;

import com.nbr.trp.common.entity.Jurisdiction;
import com.nbr.trp.common.entity.LCStation;
import com.nbr.trp.common.service.JurisdictionService;
import com.nbr.trp.user.response.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jurisdiction")
public class JurisdictionController {

    @Autowired
    JurisdictionService jurisdictionService;

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/add")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> addJurisdiction(@RequestBody Jurisdiction jurisdiction) {
        try{
            Jurisdiction jurisdiction1 = jurisdictionService.saveJurisdiction(jurisdiction);
            return ResponseEntity.ok(jurisdiction1);
        }catch(Exception e){
            return ResponseEntity.badRequest().body(new MessageResponse(e.getMessage()));
        }
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/get")
    public ResponseEntity<?> getJurisiction() {
        try{
            List<Jurisdiction> jurs = jurisdictionService.getAllJurs();
            return ResponseEntity.ok(jurs);
        }catch(Exception e){
            return ResponseEntity.badRequest().body(new MessageResponse(e.getMessage()));
        }
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> deleteJurs(@PathVariable String id) {
        try{
            jurisdictionService.deleteJurisdiction(id);
            return ResponseEntity.ok(true);
        }catch(Exception e){
            return ResponseEntity.badRequest().body(new MessageResponse(e.getMessage()));
        }
    }
}

package com.nbr.trp.taxcasedetails.controller;

import com.nbr.trp.taxcasedetails.entity.TaxCaseDetailsView;
import com.nbr.trp.taxcasedetails.service.CaseDetailsService;
import com.nbr.trp.taxfiletracker.entity.TaxFileTrkView;
import com.nbr.trp.user.response.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/case-details-search")
public class CaseDetailsSearchController {

    @Autowired
    CaseDetailsService caseDetailsService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/name/{name}")
    public ResponseEntity<?> getByName(@PathVariable String name) {
        try{
            List<TaxCaseDetailsView> taxFileTrk1 = caseDetailsService.findName(name);
            return ResponseEntity.ok(taxFileTrk1);
        }catch(Exception e){
            return ResponseEntity.badRequest().body(new MessageResponse(e.getMessage()));
        }
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/bin/{bin}")
    public ResponseEntity<?> getByBin(@PathVariable String bin) {
        try{
            List<TaxCaseDetailsView> taxFileTrk1 = caseDetailsService.findBin(bin);
            return ResponseEntity.ok(taxFileTrk1);
        }catch(Exception e){
            return ResponseEntity.badRequest().body(new MessageResponse(e.getMessage()));
        }
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/tin/{tin}")
    public ResponseEntity<?> getByTin(@PathVariable String tin) {
        try{
            List<TaxCaseDetailsView> taxFileTrk1 = caseDetailsService.findTin(tin);
            return ResponseEntity.ok(taxFileTrk1);
        }catch(Exception e){
            return ResponseEntity.badRequest().body(new MessageResponse(e.getMessage()));
        }
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/io/{io}")
    public ResponseEntity<?> getByIO(@PathVariable String io) {
        try{
            List<TaxCaseDetailsView> taxFileTrk1 = caseDetailsService.findIO(io);
            return ResponseEntity.ok(taxFileTrk1);
        }catch(Exception e){
            return ResponseEntity.badRequest().body(new MessageResponse(e.getMessage()));
        }
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/status/{status}")
    public ResponseEntity<?> getByStatus(@PathVariable String status) {
        try{
            List<TaxCaseDetailsView> taxFileTrk1 = caseDetailsService.findStatus(status);
            return ResponseEntity.ok(taxFileTrk1);
        }catch(Exception e){
            return ResponseEntity.badRequest().body(new MessageResponse(e.getMessage()));
        }
    }
}

package com.nbr.trp.taxcasedetails.controller;

import com.nbr.trp.taxcasedetails.entity.TaxCaseDetails;
import com.nbr.trp.taxcasedetails.entity.TaxCaseDetailsView;
import com.nbr.trp.taxcasedetails.service.CaseDetailsService;
import com.nbr.trp.taxfiletracker.entity.TaxFileTrk;
import com.nbr.trp.taxfiletracker.entity.TaxFileTrkView;
import com.nbr.trp.taxfiletracker.service.FileTrackerService;
import com.nbr.trp.user.response.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/case-details")
public class CaseDetailsController {

    @Autowired
    CaseDetailsService caseDetailsService;


    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/add")
    public ResponseEntity<?> addCaseDetails(@RequestBody TaxCaseDetails caseDetails) {
        try{
            TaxCaseDetails caseDetails1 = caseDetailsService.saveCaseDetails(caseDetails);
            return ResponseEntity.ok(caseDetails1);
        }catch(Exception e){
            return ResponseEntity.badRequest().body(new MessageResponse(e.getMessage()));
        }
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/list")
    public ResponseEntity<?> listCaseDetails() {
        try{
            List<TaxCaseDetailsView> caseDetailsViews = caseDetailsService.getAll();
            return ResponseEntity.ok(caseDetailsViews);
        }catch(Exception e){
            return ResponseEntity.badRequest().body(new MessageResponse(e.getMessage()));
        }
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/case/{id}")
    public ResponseEntity<?> getACase(@PathVariable String id) {
        try{
            TaxCaseDetails taxCaseDetails = caseDetailsService.getCaseDetails(id);
            return ResponseEntity.ok(taxCaseDetails);
        }catch(Exception e){
            return ResponseEntity.badRequest().body(new MessageResponse(e.getMessage()));
        }
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/remove/{id}")
    public ResponseEntity<?> removeACaseDetails(@PathVariable String id) {
        try{
            Boolean bool = caseDetailsService.deleteCaseDetails(id);
            return ResponseEntity.ok(bool);
        }catch(Exception e){
            return ResponseEntity.badRequest().body(new MessageResponse(e.getMessage()));
        }
    }
}

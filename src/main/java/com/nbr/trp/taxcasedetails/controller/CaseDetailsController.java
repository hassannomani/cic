package com.nbr.trp.taxcasedetails.controller;

import com.nbr.trp.taxcasedetails.entity.TaxCaseDetails;
import com.nbr.trp.taxcasedetails.entity.TaxCaseDetailsView;
import com.nbr.trp.taxcasedetails.repository.CaseDetailsRepository;
import com.nbr.trp.taxcasedetails.service.CaseDetailsService;
import com.nbr.trp.taxfiletracker.entity.TaxFileTrk;
import com.nbr.trp.taxfiletracker.entity.TaxFileTrkView;
import com.nbr.trp.taxfiletracker.service.FileTrackerService;
import com.nbr.trp.user.response.MessageResponse;
import com.nbr.trp.user.service.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 4800)
@RestController
@RequestMapping("/api/case-details")
public class CaseDetailsController {

    @Autowired
    CaseDetailsService caseDetailsService;
    @Autowired
    private CaseDetailsRepository caseDetailsRepository;


    @PostMapping("/add")
    public ResponseEntity<?> addCaseDetails(@RequestBody TaxCaseDetails caseDetails) {
        try{
            TaxCaseDetails caseDetails1 = caseDetailsService.saveCaseDetails(caseDetails);
            return ResponseEntity.ok(caseDetails1);
        }catch(Exception e){
            return ResponseEntity.badRequest().body(new MessageResponse(e.getMessage()));
        }
    }

    @GetMapping("/list")
    public ResponseEntity<?> listCaseDetails() {
        try{
            List<TaxCaseDetailsView> caseDetailsViews = caseDetailsService.getAll();
            return ResponseEntity.ok(caseDetailsViews);
        }catch(Exception e){
            return ResponseEntity.badRequest().body(new MessageResponse(e.getMessage()));
        }
    }

    @GetMapping("/case/{id}")
    public ResponseEntity<?> getACase(@PathVariable String id) {
        try{
            TaxCaseDetails taxCaseDetails = caseDetailsService.getCaseDetails(id);
            return ResponseEntity.ok(taxCaseDetails);
        }catch(Exception e){
            return ResponseEntity.badRequest().body(new MessageResponse(e.getMessage()));
        }
    }

    @GetMapping("/remove/{id}")
    public ResponseEntity<?> removeACaseDetails(@PathVariable String id) {
        try{
            SecurityContext context = SecurityContextHolder.getContext();
            Authentication authentication = context.getAuthentication();
            UserDetailsImpl userDetails1 = (UserDetailsImpl) authentication.getPrincipal();
            String des = userDetails1.getDesignation();
            if(des.equals("Director General")||des.equals("Assistant Programmer")){

                Boolean bool = caseDetailsService.deleteCaseDetails(id);
                return ResponseEntity.ok(bool);
            }else{
                return ResponseEntity.status(403).body("error");
            }
        }catch(Exception e){
            return ResponseEntity.badRequest().body(new MessageResponse(e.getMessage()));
        }
    }

    @PostMapping("/update")
    public ResponseEntity<?> updateCaseDetails(@RequestBody TaxCaseDetails caseDetails) {
        try{
            TaxCaseDetails caseDetails1 = caseDetailsService.updateCaseDetails(caseDetails);
            return ResponseEntity.ok(caseDetails1);
        }catch(Exception e){
            return ResponseEntity.badRequest().body(new MessageResponse(e.getMessage()));
        }
    }
}

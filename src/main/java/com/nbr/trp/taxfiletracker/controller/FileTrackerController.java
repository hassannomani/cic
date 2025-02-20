package com.nbr.trp.taxfiletracker.controller;

import com.nbr.trp.taxfiletracker.entity.TaxFileTrk;
import com.nbr.trp.taxfiletracker.entity.TaxFileTrkView;
import com.nbr.trp.taxfiletracker.service.FileTrackerService;
import com.nbr.trp.user.entity.User;
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

@CrossOrigin(origins = "*", maxAge = 4800)
@RestController
@RequestMapping("/api/file-track")

public class FileTrackerController {

    @Autowired
    FileTrackerService fileTrackerService;


    @PostMapping("/add")
    public ResponseEntity<?> addFileTrack(@RequestBody TaxFileTrk taxFileTrk) {
        try{
            TaxFileTrk taxFileTrk1 = fileTrackerService.saveFileTrk(taxFileTrk);
            return ResponseEntity.ok(taxFileTrk1);
        }catch(Exception e){
            return ResponseEntity.badRequest().body(new MessageResponse(e.getMessage()));
        }
    }

    @GetMapping("/list")
    public ResponseEntity<?> listFileTrack() {
        try{
            List<TaxFileTrkView> taxFileTrk1 = fileTrackerService.getAll();
            return ResponseEntity.ok(taxFileTrk1);
        }catch(Exception e){
            return ResponseEntity.badRequest().body(new MessageResponse(e.getMessage()));
        }
    }

    @GetMapping("/file/{id}")
    public ResponseEntity<?> getAFile(@PathVariable String id) {
        try{
            TaxFileTrk taxFileTrk1 = fileTrackerService.getFileTrk(id);
            return ResponseEntity.ok(taxFileTrk1);
        }catch(Exception e){
            return ResponseEntity.badRequest().body(new MessageResponse(e.getMessage()));
        }
    }

    @GetMapping("/remove/{id}")
    public ResponseEntity<?> removeAFile(@PathVariable String id) {
        try{
            SecurityContext context = SecurityContextHolder.getContext();
            Authentication authentication = context.getAuthentication();
            UserDetailsImpl userDetails1 = (UserDetailsImpl) authentication.getPrincipal();
            String des = userDetails1.getDesignation();
            if(des.equals("Director General")||des.equals("Assistant Programmer")){
                Boolean bool = fileTrackerService.deleteFileTrk(id);
                return ResponseEntity.ok(bool);
            }else{
                return ResponseEntity.status(403).body("error");
            }

        }catch(Exception e){
            return ResponseEntity.badRequest().body(new MessageResponse(e.getMessage()));
        }
    }

    @PostMapping("/update")
    public ResponseEntity<?> updateFileTrack(@RequestBody TaxFileTrk taxFileTrk) {
        try{
            Boolean taxFileTrk1 = fileTrackerService.updateFileTrk(taxFileTrk);
            return ResponseEntity.ok(taxFileTrk1);
        }catch(Exception e){
            return ResponseEntity.badRequest().body(new MessageResponse(e.getMessage()));
        }
    }
}

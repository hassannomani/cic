package com.nbr.trp.taxfiletracker.controller;

import com.nbr.trp.taxfiletracker.entity.TaxFileTrk;
import com.nbr.trp.taxfiletracker.entity.TaxFileTrkView;
import com.nbr.trp.taxfiletracker.service.FileTrackerService;
import com.nbr.trp.user.entity.User;
import com.nbr.trp.user.response.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/file-track")
public class FileTrackerController {

    @Autowired
    FileTrackerService fileTrackerService;


    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/add")
    public ResponseEntity<?> addFileTrack(@RequestBody TaxFileTrk taxFileTrk) {
        try{
            TaxFileTrk taxFileTrk1 = fileTrackerService.saveFileTrk(taxFileTrk);
            return ResponseEntity.ok(taxFileTrk1);
        }catch(Exception e){
            return ResponseEntity.badRequest().body(new MessageResponse(e.getMessage()));
        }
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/list")
    public ResponseEntity<?> listFileTrack() {
        try{
            List<TaxFileTrkView> taxFileTrk1 = fileTrackerService.getAll();
            return ResponseEntity.ok(taxFileTrk1);
        }catch(Exception e){
            return ResponseEntity.badRequest().body(new MessageResponse(e.getMessage()));
        }
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/file/{id}")
    public ResponseEntity<?> getAFile(@PathVariable String id) {
        try{
            TaxFileTrk taxFileTrk1 = fileTrackerService.getFileTrk(id);
            return ResponseEntity.ok(taxFileTrk1);
        }catch(Exception e){
            return ResponseEntity.badRequest().body(new MessageResponse(e.getMessage()));
        }
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/remove/{id}")
    public ResponseEntity<?> removeAFile(@PathVariable String id) {
        try{
            Boolean bool = fileTrackerService.deleteFileTrk(id);
            return ResponseEntity.ok(bool);
        }catch(Exception e){
            return ResponseEntity.badRequest().body(new MessageResponse(e.getMessage()));
        }
    }

    @CrossOrigin(origins = "http://localhost:4200")
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

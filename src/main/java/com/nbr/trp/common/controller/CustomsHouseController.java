package com.nbr.trp.common.controller;

import com.nbr.trp.user.entity.Role;
import com.nbr.trp.user.response.MessageResponse;
import com.nbr.trp.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/house")
public class CustomsHouseController {

    @Autowired
    UserService userService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/addhouse")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> getAllRoles() {
        try{
            List<Role> roles = userService.getRoles();
            return ResponseEntity.ok(roles);
        }catch(Exception e){
            return ResponseEntity.badRequest().body(new MessageResponse(e.getMessage()));
        }
    }
}

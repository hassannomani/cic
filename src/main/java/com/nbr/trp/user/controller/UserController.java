package com.nbr.trp.user.controller;

import com.nbr.trp.user.entity.Role;
import com.nbr.trp.user.entity.User;
import com.nbr.trp.user.repository.RoleRepository;
import com.nbr.trp.user.response.MessageResponse;
import com.nbr.trp.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 4800)
@RestController
@RequestMapping("/api/users")
//@RequestMapping("/api/test")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    RoleRepository roleRepository;


    @GetMapping("/roles")
   // @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> getAllRoles() {
        try{
            List<Role> roles = userService.getRoles();
            return ResponseEntity.ok(roles);
        }catch(Exception e){
            return ResponseEntity.badRequest().body(new MessageResponse(e.getMessage()));
        }
    }

    @PostMapping("/add")
    //@PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> addUser(@RequestBody User user) {
        System.out.println(user.getRoles());

        try{
            User user1 = userService.saveUser(user);
            return ResponseEntity.ok(user1);
        }catch(Exception e){
            return ResponseEntity.badRequest().body(new MessageResponse(e.getMessage()));
        }
    }

    @GetMapping("/all")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> getAllUsers() {
        try{
            List<User> all_users = userService.getAllUsers();
            return ResponseEntity.ok(all_users);
        }catch(Exception e){
            return ResponseEntity.badRequest().body(new MessageResponse(e.getMessage()));
        }
    }

    @GetMapping("/user/{username}")
    public ResponseEntity<?> getAUser(@PathVariable String username) {
        System.out.println(username);
        try{
            Optional<User> user = userService.getUserByUsername(username);
            return ResponseEntity.ok(user);
        }catch(Exception e){
            return ResponseEntity.badRequest().body(new MessageResponse(e.getMessage()));
        }
    }

    @CrossOrigin(origins = "*", maxAge = 4800)
    @GetMapping("/pending-all")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> getAllPendingUsers() {
        try{
            List<User> all_users_pending = userService.getAllPendingUsers();
            return ResponseEntity.ok(all_users_pending);
        }catch(Exception e){
            return ResponseEntity.badRequest().body(new MessageResponse(e.getMessage()));
        }
    }

    @GetMapping("/assign/{email}/{designation}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> assignAndApprove(@PathVariable String email, @PathVariable String designation) {
        try{
            Boolean user = userService.assignAndApprove(email,designation);
            return ResponseEntity.ok(user);
        }catch(Exception e){
            return ResponseEntity.badRequest().body(new MessageResponse(e.getMessage()));
        }
    }


    @GetMapping("/reject/{username}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> reject(@PathVariable String username) {
        try{
            Boolean user = userService.reject(username);
            return ResponseEntity.ok(user);
        }catch(Exception e){
            return ResponseEntity.badRequest().body(new MessageResponse(e.getMessage()));
        }
    }

}

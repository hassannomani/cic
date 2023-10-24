package com.nbr.trp.user.controller;


import com.nbr.trp.user.entity.ERole;
import com.nbr.trp.user.entity.Role;
import com.nbr.trp.user.entity.User;
import com.nbr.trp.user.repository.RoleRepository;
import com.nbr.trp.user.repository.UserRepository;
import com.nbr.trp.user.request.LoginRequest;
import com.nbr.trp.user.request.SignupRequest;
import com.nbr.trp.user.response.JwtResponse;
import com.nbr.trp.user.response.MessageResponse;
import com.nbr.trp.user.service.UserDetailsImpl;
import com.nbr.trp.user.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;


    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl)
                authentication.getPrincipal();
        System.out.println("status is "+userDetails.getStatus());
        if(userDetails.getStatus().equals("1")){
            List<String> roles = userDetails.getAuthorities()
                    .stream().map(item -> item.getAuthority())
                    .collect(Collectors.toList());
            return ResponseEntity.ok(new JwtResponse(
                            jwt,
                            userDetails.getUuid(),
                            userDetails.getUsername(),
                            userDetails.getDesignation(),
                            roles
                    )
            );
        }
        else
            return ResponseEntity.status(403).body("Error! Please try again");


    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody SignupRequest signUpRequest) {

        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: username is already taken!"));
        }

        // Create new employee account
        User employee = new User();
        employee.setUsername(signUpRequest.getUsername());
        employee.setUuid(UUID.randomUUID().toString());
        employee.setPassword(signUpRequest.getPassword());
        employee.setFirstName(signUpRequest.getUsername());
        employee.setLastName(signUpRequest.getLastname());
        employee.setStatus("1");
        employee.setAddedBy("SYSTEM");
        employee.setAddedFromIP("127.0.0.1");

        //Set<String> strRoles = signUpRequest.getRoles();
        Set<Role> roles = new HashSet<>();

        //if (strRoles == null) {

        Role repRole = roleRepository.findByName(String.valueOf(ERole.ROLE_USER))
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(repRole);

//        } else {
//
//            strRoles.forEach(role -> {
//
//                if (role.equals("admin")) {
//                    Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN.name())
//                            .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
//                    roles.add(adminRole);
//                } else if (role.equals("user")){
//                    Role userRole = roleRepository.findByName(ERole.ROLE_USER.name())
//                            .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
//                    roles.add(userRole);
//                }
//
//            });
//        }

        employee.setRoles(roles);
        userRepository.save(employee);

        return ResponseEntity.ok(new MessageResponse("Employee registered successfully!"));
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/logout")
    public ResponseEntity<?> logoutUser() {
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

}

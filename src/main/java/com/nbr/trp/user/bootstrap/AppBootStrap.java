package com.nbr.trp.user.bootstrap;
import com.nbr.trp.user.entity.ERole;
import com.nbr.trp.user.entity.Role;
import com.nbr.trp.user.entity.User;
import com.nbr.trp.user.repository.RoleRepository;
import com.nbr.trp.user.repository.UserRepository;
import com.nbr.trp.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.*;

import static com.nbr.trp.user.entity.ERole.ROLE_ADMIN;
@Component
public class AppBootStrap implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserService userService;

    @Autowired
    public AppBootStrap(UserRepository userRepository, RoleRepository roleRepository, UserService userService){

        this.userService=userService;
        this.roleRepository=roleRepository;
        this.userRepository=userRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        try {
            if (roleRepository.findAll().isEmpty()) {
                Role role = new Role();
                role.setName(ERole.ROLE_ADMIN.name());
                roleRepository.save(role);
                Role role2 = new Role();
                role2.setName(ERole.ROLE_USER.name());
                roleRepository.save(role2);

                Role role3 = new Role();
                role3.setName(ERole.ROLE_API.name());
                roleRepository.save(role3);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        Optional<User> user1 = userRepository.findByUsername("admin@cic.gov.bd");
        if (user1.isEmpty()){
            Set<Role> roleadmin = new HashSet<Role>();
            Role adminsingle = roleRepository.findByName(String.valueOf(ROLE_ADMIN)).orElse(null);
            roleadmin.add(adminsingle);
            User userX = new User();
            userX.setUuid(UUID.randomUUID().toString());
            userX.setUsername("admin@cic.gov.bd");
            userX.setPassword("@dm!n");
            userX.setFirstName("Admin");
            userX.setLastName("User");
            userX.setStatus("1");
            userX.setRoles(roleadmin);
            userX.setAddedBy("SYSTEM");
            userX.setAddedFromIP("127.0.0.1");
            userX.setDesignation("Assistant Programmer");

//            User userX = new User(UUID.randomUUID().toString(), "admin@custour.gov.bd", "", "Admin" ,"User","Admin", LocalDateTime.now(),LocalDateTime.now(),
//                    "","","","SYSTEM", "127.0.0.1","1",roleadmin,"");
            User saved = userService.saveUser(userX);
            System.out.println(saved);

        }

    }
}

package com.nbr.trp.user.service;

import com.nbr.trp.user.entity.Role;
import com.nbr.trp.user.entity.User;
import com.nbr.trp.user.repository.RoleRepository;
import com.nbr.trp.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    public void UserServiceImpl( UserRepository userRepository){
        this.userRepository = userRepository;
    }

    PasswordEncoder passwordEncoder;

    @Override
    public User saveUser(User user) {
        //String password = user.getPassword();
        this.passwordEncoder = new BCryptPasswordEncoder();
        String pass = this.passwordEncoder.encode(user.getPassword());
        user.setStatus("0");
        //System.out.println("The pass is "+pass);
        user.setPassword(pass);
        User u = userRepository.save(user);
        return u;
    }

    @Override
    public List<User> getAllUsers(){
        return userRepository.findAllByOrderByAddedDateDesc();
    }

    @Override
    public List<User> getAllPendingUsers() {
        return userRepository.findByStatus("0");
    }

    @Override
    public Optional<User> getUserByUsername(String username){
        return userRepository.findByUsername(username);
    }

    @Autowired
    public List<Role> getRoles(){
        return roleRepository.findAll();
    }

    @Override
    public User getUser(String uname) {
        return userRepository.getByUname(uname);
    }

    public Boolean assignAndApprove(String email,String designation) throws Exception{
        try{
            User u = userRepository.getByUname(email);
            if(u==null){
                System.out.println("No user found");
                return false;
            }
            System.out.println(u);
            u.setDesignation(designation);
            u.setStatus("1");
            userRepository.save(u);
            return true;
        }catch(Exception e){
            System.out.println(e);
            throw e;
        }
    }

    public Boolean reject(String username) throws Exception{
        try{
            User u = userRepository.getByUname(username);
            if(u==null){
                throw new Exception("User not found");
            }
            u.setStatus("-1");
            userRepository.save(u);
            return true;
        }catch(Exception e){
            throw new Exception(e);
        }
    }

}

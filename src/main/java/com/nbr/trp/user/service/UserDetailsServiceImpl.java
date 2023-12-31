package com.nbr.trp.user.service;

import com.nbr.trp.user.entity.User;
import com.nbr.trp.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String uname) throws UsernameNotFoundException {
        User user = userRepository
                .findByUsername(uname)
                .orElseThrow(
                        () -> new UsernameNotFoundException("User Not Found with username: " + uname)
                );

        return UserDetailsImpl.build(user);
    }
}

package com.nbr.trp.user.service;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nbr.trp.user.entity.User;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.io.Serial;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@NoArgsConstructor
public class UserDetailsImpl implements UserDetails {
    @Serial
    private static final long serialVersionUID = 1L;

    private String uuid;

    private String username;

    @JsonIgnore
    private String password;

    private String designation;
    private String status;

    private Collection<? extends GrantedAuthority> authorities;

    public UserDetailsImpl(
            String uuid,
            String username,
            String password,
            String designation,
            String status,
            Collection<? extends GrantedAuthority> authorities
    ) {
        this.uuid = uuid;
        this.username = username;
        this.password = password;
        this.status = status;
        this.designation = designation;
        this.authorities = authorities;
    }

    public static UserDetailsImpl build(User user) {

        List<GrantedAuthority> authorities = user.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority
                        (role.getName()))
                .collect(Collectors.toList());

        return new UserDetailsImpl(
                user.getUuid(),
                user.getUsername(),
                user.getPassword(),
                user.getDesignation(),
                user.getStatus(),
                authorities);
    }

    @Override
    public Collection<? extends
                GrantedAuthority> getAuthorities() {

        return authorities;
    }

    public String getUuid() {
        return uuid;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public String getDesignation() { return designation;}

    public String getStatus() {
        return status;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        UserDetailsImpl user = (UserDetailsImpl) o;
        return Objects.equals(uuid, user.uuid);
    }

}

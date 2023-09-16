package com.nbr.trp.user.request;


import java.util.Date;
import java.util.Set;

public class SignupRequest {
    private String username;

    private String password;

    private String firstname;

    private String lastname;

    private Set<String> roles;

    private String addedby;

    private String addedfromip;

    private String status;



    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }



    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }

    public void setStatus(String status) { this.status = status; }


    public void setAddedby(String addedby) {
        this.addedby = addedby;
    }

    public void setAddedfromip(String addedfromip) {
        this.addedfromip = addedfromip;
    }


    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstname() {
        return firstname;
    }
    public String getLastname() {return lastname;}

    public Set<String> getRoles() {
        return roles;
    }


    public String getAddedby() {
        return addedby;
    }

    public String getAddedfromip() {
        return addedfromip;
    }

    public String getStatus() {
        return status;
    }


}

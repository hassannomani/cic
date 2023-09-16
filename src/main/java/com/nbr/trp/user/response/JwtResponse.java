package com.nbr.trp.user.response;

import java.util.List;

public class JwtResponse {
    private String token;
    private String type = "Bearer";

    private String uuid;
    private String username;

    private String designation;
    private List<String> roles;

    public JwtResponse(String accessToken, String uuid, String username, String designation, List<String> roles) {
        this.token = accessToken;
        this.uuid = uuid;
        this.username = username;
        this.designation = designation;
        this.roles = roles;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return uuid;
    }

    public void setId(String id) {
        this.uuid = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public void setDesignation(String designation){ this.designation = designation;}

    public String getDesignation() { return designation;}

}

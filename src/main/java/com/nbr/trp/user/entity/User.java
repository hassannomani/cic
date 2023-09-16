package com.nbr.trp.user.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(columnDefinition = "uniqueidentifier default newid()")
    private String uuid;

    @Column(name = "username",nullable = false,unique = true)
    public String username;             //email

    @Column(name = "password")
    public String password;

    @Column(name = "first_name")
    public String firstName;

    @Column(name = "last_name")
    public String lastName;


    @Column(name = "added_by")
    public String addedBy;

    @Column(name = "added_date")
    @CreationTimestamp
    public Date addedDate;

    @Column(name = "added_from_ip")
    public String addedFromIP;

    @Column(name="designation")
    public String designation;

    @Column(name = "status")
    public String status;

    @ManyToMany(/*cascade = CascadeType.ALL,*/ fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<>();

    public User(String uuid, String username, String password, String firstName, String lastName, String addedBy, Date addedDate, String addedFromIP, String designation, String status, Set<Role> roles) {
        this.uuid = uuid;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.addedBy = addedBy;
        this.addedDate = addedDate;
        this.addedFromIP = addedFromIP;
        this.designation = designation;
        this.status = status;
        this.roles = roles;
    }
}

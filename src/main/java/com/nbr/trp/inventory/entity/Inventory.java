package com.nbr.trp.inventory.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "inventories")
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(columnDefinition = "uniqueidentifier default newid()")
    private String inventoriid;

    @Column(name = "name")
    public String name;


    @Column(name = "quantity")
    public String quantity;

    @Column(name = "picture")
    public String picture;


    public Inventory(String inventoriid, String name, String quantity, String picture) {
        this.inventoriid = inventoriid;
        this.name = name;
        this.quantity = quantity;
        this.picture = picture;
    }
}

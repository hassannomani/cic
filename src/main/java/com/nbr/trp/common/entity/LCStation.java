package com.nbr.trp.common.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "lcstation")
public class LCStation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @Column(name="name",nullable = false)
    private String name;

    public LCStation(long id, String name) {
        this.id = id;
        this.name = name;
    }
}

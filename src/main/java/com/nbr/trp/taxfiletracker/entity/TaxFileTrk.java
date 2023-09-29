package com.nbr.trp.taxfiletracker.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "taxfiletrackers")
public class TaxFileTrk {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(columnDefinition = "uniqueidentifier default newid()")
    private String taxfileuuid;

    @Column(name = "taxpayername", nullable = false)
    public String taxpayername;

    @Column(name = "fileno",nullable = false)
    public String fileno;

    @Column(name = "tin")
    public String tin;

    @Column(name = "bin")
    public String bin;

    @Column(name = "nid")
    public String nid;

    @Column(name = "customshouse")
    public String customshouse;

    @Column(name = "lcstation")
    public String lcstation;

    @Column(name = "rackno")
    public String rackno;

    @Column(name = "storagedate")
    public String storagedate;

    @Column(name = "jurisdiction")
    public String jurisdiction;

    @Column(name = "details")
    public String details;

    @Column(name="status")
    public String status;

}

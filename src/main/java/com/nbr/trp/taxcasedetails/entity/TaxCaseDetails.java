package com.nbr.trp.taxcasedetails.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "taxcasedetails")
public class TaxCaseDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(columnDefinition = "uniqueidentifier default newid()")
    private String taxcasedtlsuuid;

    @Column(name = "createdby")
    public String createdby;

    @Column(name = "taxpayername")
    public String taxpayername;

    @Column(name = "tinno", columnDefinition="TEXT")
    public String tinno;

    @Column(name = "fileno")
    public String fileno;

    @Column(name = "nidno")
    public String nidno;

    @Column(name = "bin")
    public String bin;

    @Column(name = "rjsc")
    public String rjsc;

    @Column(name = "io")
    public String io;

    @Column(name = "fileinitdate")
    public Date fileinitdate;

    @Column(name = "banksearchdate")
    public Date banksearchdate;

    @Column(name = "bankfreezedata")
    public Date bankfreezedata;

    @Column(name = "dateofreportsend")
    public Date dateofreportsend;

    @Column(name = "dateofcompletion")
    public Date dateofcompletion;           //date of receiving completion date

    @Column(name = "dateofsendback")
    public Date dateofsendback;

    @Column(name = "dateofsendbacktofield")
    public Date dateofsendbacktofield;

    @Column(name = "fileenlisted")
    public Date fileenlisted;

    @Column(name = "courtissue")
    public String courtissue;

    @Column(name = "courtissueremarks")
    public String courtissueremarks;

    @Column(name = "comment")
    public String comment;

    @Column(name = "bankunfreezedate")
    public Date bankunfreezedate;

    @Column(name = "filetype")
    public String filetype;

    @Column(name = "cicamount")
    public String cicamount;

    @Column(name = "fieldamount")
    public String fieldamount;

    @Column(name = "status")
    public String status;

    @Column(name = "otherinvestigation")
    public String otherinvestigation;
}

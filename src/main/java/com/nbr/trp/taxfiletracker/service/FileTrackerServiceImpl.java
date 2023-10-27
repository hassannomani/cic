package com.nbr.trp.taxfiletracker.service;

import com.nbr.trp.taxfiletracker.entity.TaxFileTrk;
import com.nbr.trp.taxfiletracker.entity.TaxFileTrkView;
import com.nbr.trp.taxfiletracker.repository.FileTrackerRepository;
import com.nbr.trp.user.service.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileTrackerServiceImpl implements FileTrackerService{

    @Autowired
    FileTrackerRepository fileTrackerRepository;

    @Override
    public TaxFileTrk saveFileTrk(TaxFileTrk taxFileTrk) {
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();
        UserDetailsImpl userDetails1 = (UserDetailsImpl) authentication.getPrincipal();
        String uuid = userDetails1.getUuid();
        taxFileTrk.setCreatedby(uuid);
        return fileTrackerRepository.save(taxFileTrk);
    }

    @Override
    public TaxFileTrk getFileTrk(String uuid) {
        return fileTrackerRepository.findByTaxfileuuid(uuid);
    }

    @Override
    public Boolean updateFileTrk(TaxFileTrk taxFileTrk) {
        String id = taxFileTrk.getTaxfileuuid();
        TaxFileTrk taxFileTrk1 = fileTrackerRepository.findByTaxfileuuid(id);

        taxFileTrk1.setTaxpayername(taxFileTrk.getTaxpayername());
        taxFileTrk1.setBin(taxFileTrk.getBin());
        taxFileTrk1.setFileno(taxFileTrk.getFileno());
        taxFileTrk1.setCustomshouse(taxFileTrk.getCustomshouse());
        taxFileTrk1.setDetails(taxFileTrk.getDetails());
        taxFileTrk1.setNid(taxFileTrk.getNid());
        taxFileTrk1.setJurisdiction(taxFileTrk.getJurisdiction());
        taxFileTrk1.setLcstation(taxFileTrk.getLcstation());
        taxFileTrk1.setRackno(taxFileTrk.getRackno());
        taxFileTrk1.setStoragedate(taxFileTrk.getStoragedate());
        taxFileTrk1.setClassification(taxFileTrk.getClassification());
        taxFileTrk1.setTin(taxFileTrk.getTin());
        fileTrackerRepository.save(taxFileTrk1);
        return true;
    }

    @Override
    public Boolean deleteFileTrk(String id) {
        fileTrackerRepository.deleteByTaxfileuuid(id);
        return true;
    }

    @Override
    public List<TaxFileTrkView> getAll(){
        return fileTrackerRepository.findAllFile();
    }

    @Override
    public List<TaxFileTrkView> findName(String name) {
        return fileTrackerRepository.findByTaxpayernameContaining(name);
    }

    @Override
    public List<TaxFileTrkView> findTin(String tin) {
        return fileTrackerRepository.findByTin(tin);
    }

    @Override
    public List<TaxFileTrkView> findBin(String bin) {
        return fileTrackerRepository.findByBin(bin);
    }

    @Override
    public List<TaxFileTrkView> findHouse(String house) {
        return fileTrackerRepository.findByCustomshouse(house);
    }

    @Override
    public List<TaxFileTrkView> findLCS(String lc) {
        return fileTrackerRepository.findByLcstation(lc);
    }
}

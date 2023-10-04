package com.nbr.trp.common.service;

import com.nbr.trp.common.entity.Jurisdiction;
import com.nbr.trp.common.repository.JurisdictionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JurisdictionServiceImpl implements JurisdictionService{

    @Autowired
    JurisdictionRepository jurisdictionRepository;

    @Override
    public Jurisdiction saveJurisdiction(Jurisdiction lc) {
        return jurisdictionRepository.save(lc);
    }

    @Override
    public List<Jurisdiction> getAllJurs() {
        return jurisdictionRepository.findAll();
    }

    @Override
    public void deleteJurisdiction(String id) {
        jurisdictionRepository.deleteJurisdiction(Integer.valueOf(id));
    }
}

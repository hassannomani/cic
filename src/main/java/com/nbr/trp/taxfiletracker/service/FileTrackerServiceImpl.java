package com.nbr.trp.taxfiletracker.service;

import com.nbr.trp.taxfiletracker.entity.TaxFileTrk;
import com.nbr.trp.taxfiletracker.entity.TaxFileTrkView;
import com.nbr.trp.taxfiletracker.repository.FileTrackerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileTrackerServiceImpl implements FileTrackerService{

    @Autowired
    FileTrackerRepository fileTrackerRepository;

    @Override
    public TaxFileTrk saveFileTrk(TaxFileTrk taxFileTrk) {
        return fileTrackerRepository.save(taxFileTrk);
    }

    @Override
    public TaxFileTrk getFileTrk(String uuid) {
        return fileTrackerRepository.findByTaxfileuuid(uuid);
    }

    @Override
    public TaxFileTrk updateFileTrk(TaxFileTrk taxFileTrk) {
        return null;
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
}

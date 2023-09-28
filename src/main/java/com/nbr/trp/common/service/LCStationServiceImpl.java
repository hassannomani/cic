package com.nbr.trp.common.service;

import com.nbr.trp.common.entity.CustomsHouse;
import com.nbr.trp.common.entity.LCStation;
import com.nbr.trp.common.repository.LCStationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LCStationServiceImpl implements LCStationService {

    @Autowired
    LCStationRepository lcStationRepository;

    @Override
    public LCStation saveLCStation(LCStation lc) {
        return lcStationRepository.save(lc);
    }

    @Override
    public List<LCStation> getAllStations() {
        return lcStationRepository.findAll();
    }

    @Override
    public void deleteStation(String id) {
        Integer i = Integer.valueOf(id);
        lcStationRepository.deletelcstations(i);
    }
}

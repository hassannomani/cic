package com.nbr.trp.common.service;

import com.nbr.trp.common.entity.LCStation;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LCStationService {

    public LCStation saveLCStation(LCStation lc);

    public List<LCStation> getAllStations();

    public void deleteStation(String id);
}

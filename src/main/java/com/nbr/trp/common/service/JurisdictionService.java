package com.nbr.trp.common.service;

import com.nbr.trp.common.entity.Jurisdiction;
import com.nbr.trp.common.entity.LCStation;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface JurisdictionService {

    public Jurisdiction saveJurisdiction(Jurisdiction lc);

    public List<Jurisdiction> getAllJurs();

    public void deleteJurisdiction(String id);
}

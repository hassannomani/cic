package com.nbr.trp.taxfiletracker.service;

import com.nbr.trp.taxfiletracker.entity.TaxFileTrk;
import com.nbr.trp.taxfiletracker.entity.TaxFileTrkView;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FileTrackerService {

   public TaxFileTrk saveFileTrk(TaxFileTrk taxFileTrk);

   public TaxFileTrk getFileTrk(String uuid);

   public Boolean updateFileTrk(TaxFileTrk taxFileTrk);

   public Boolean deleteFileTrk(String id);

   public List<TaxFileTrkView> getAll();


}

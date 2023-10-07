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

   public List<TaxFileTrkView> findName(String name);

   public List<TaxFileTrkView> findTin(String tin);

   public List<TaxFileTrkView> findBin(String bin);

   public List<TaxFileTrkView> findHouse(String house);
   public List<TaxFileTrkView> findLCS(String lc);



}

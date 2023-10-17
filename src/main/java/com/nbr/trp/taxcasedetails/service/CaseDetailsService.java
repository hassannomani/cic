package com.nbr.trp.taxcasedetails.service;

import com.nbr.trp.taxcasedetails.entity.TaxCaseDetails;
import com.nbr.trp.taxcasedetails.entity.TaxCaseDetailsView;
import com.nbr.trp.taxfiletracker.entity.TaxFileTrk;
import com.nbr.trp.taxfiletracker.entity.TaxFileTrkView;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CaseDetailsService {

    public TaxCaseDetails saveCaseDetails(TaxCaseDetails taxCaseDetails);

    public TaxCaseDetails getCaseDetails(String uuid);

    public TaxCaseDetails updateCaseDetails(TaxCaseDetails taxCaseDetails);

    public Boolean deleteCaseDetails(String id);

    public List<TaxCaseDetailsView> getAll();

    public List<TaxCaseDetailsView> findName(String name);

    public List<TaxCaseDetailsView> findTin(String tin);

    public List<TaxCaseDetailsView> findBin(String bin);

    public List<TaxCaseDetailsView> findIO(String io);
}

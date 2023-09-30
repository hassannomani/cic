package com.nbr.trp.taxcasedetails.service;

import com.nbr.trp.taxcasedetails.entity.TaxCaseDetails;
import com.nbr.trp.taxcasedetails.entity.TaxCaseDetailsView;
import com.nbr.trp.taxcasedetails.repository.CaseDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CaseDetailsServiceImpl implements CaseDetailsService{
    @Autowired
    CaseDetailsRepository caseDetailsRepository;

    @Override
    public TaxCaseDetails saveCaseDetails(TaxCaseDetails taxCaseDetails) {
        return caseDetailsRepository.save(taxCaseDetails);
    }

    @Override
    public TaxCaseDetails getCaseDetails(String uuid) {
        return caseDetailsRepository.findByTaxcasedtlsuuid(uuid);
    }

    @Override
    public TaxCaseDetails updateCaseDetails(TaxCaseDetails taxCaseDetails) {
        return null;
    }

    @Override
    public Boolean deleteCaseDetails(String id) {
        caseDetailsRepository.deleteByTaxcasedtlsuuid(id);
        return true;
    }

    @Override
    public List<TaxCaseDetailsView> getAll() {
        return caseDetailsRepository.findAllFile();
    }
}

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
    public TaxCaseDetails updateCaseDetails(TaxCaseDetails caseDetails) {

        String id = caseDetails.getTaxcasedtlsuuid();
        TaxCaseDetails caseDetails1 = caseDetailsRepository.findByTaxcasedtlsuuid(id);
        caseDetails1.setBankfreezedata(caseDetails.getBankfreezedata());
        caseDetails1.setBin(caseDetails.getBin());
        caseDetails1.setIo(caseDetails.getIo());
        caseDetails1.setComment(caseDetails.getComment());
        caseDetails1.setCourtissue(caseDetails.getCourtissue());
        caseDetails1.setBanksearchdate(caseDetails.getBanksearchdate());
        caseDetails1.setDateofcompletion(caseDetails.getDateofcompletion());
        caseDetails1.setDateofreportsend(caseDetails.getDateofreportsend());
        caseDetails1.setFileenlisted(caseDetails.getFileenlisted());
        caseDetails1.setFileinitdate(caseDetails.getFileinitdate());
        caseDetails1.setNidno(caseDetails.getNidno());
        caseDetails1.setRjsc(caseDetails1.getRjsc());
        caseDetails1.setTaxpayername(caseDetails1.getTaxpayername());
        caseDetails1.setTinno(caseDetails1.getTinno());
        return caseDetailsRepository.save(caseDetails1);
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

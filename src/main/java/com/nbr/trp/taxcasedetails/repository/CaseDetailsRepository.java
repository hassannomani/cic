package com.nbr.trp.taxcasedetails.repository;

import com.nbr.trp.taxcasedetails.entity.TaxCaseDetails;
import com.nbr.trp.taxcasedetails.entity.TaxCaseDetailsView;
import com.nbr.trp.taxfiletracker.entity.TaxFileTrk;
import com.nbr.trp.taxfiletracker.entity.TaxFileTrkView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface CaseDetailsRepository extends JpaRepository<TaxCaseDetails, String> {

    TaxCaseDetails save(TaxCaseDetails taxCaseDetails);

    @Query(value = "select taxcasedtlsuuid, taxpayername from taxcasedetails",nativeQuery = true)
    List<TaxCaseDetailsView> findAllFile();

    TaxCaseDetails findByTaxcasedtlsuuid(String id);

    @Transactional
    @Modifying
    void deleteByTaxcasedtlsuuid(String uuid);

    List<TaxCaseDetailsView> findByTaxpayernameContaining(String name);

    List<TaxCaseDetailsView> findByTinnoContaining(String tin);

    List<TaxCaseDetailsView> findByBin(String bin);

    List<TaxCaseDetailsView> findByIoContaining(String io);

    List<TaxCaseDetailsView> findByStatus(String status);

}

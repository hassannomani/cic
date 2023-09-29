package com.nbr.trp.taxfiletracker.repository;

import com.nbr.trp.taxfiletracker.entity.TaxFileTrk;
import com.nbr.trp.taxfiletracker.entity.TaxFileTrkView;
import com.nbr.trp.user.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface FileTrackerRepository extends JpaRepository<TaxFileTrk, String> {

    TaxFileTrk save(TaxFileTrk taxFileTrk);

    @Query(value = "select taxfileuuid, taxpayername from taxfiletrackers",nativeQuery = true)
    List<TaxFileTrkView> findAllFile();

    TaxFileTrk findByTaxfileuuid(String id);

    @Transactional
    @Modifying
    void deleteByTaxfileuuid(String uuid);


}

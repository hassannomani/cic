package com.nbr.trp.common.repository;

import com.nbr.trp.common.entity.CustomsHouse;
import com.nbr.trp.common.entity.Jurisdiction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface JurisdictionRepository extends JpaRepository<Jurisdiction, String> {

    Jurisdiction save(Jurisdiction ch);

    List<Jurisdiction> findAll();

    @Transactional
    @Modifying
    @Query(value = "delete from jurisdiction where id=?1",
            nativeQuery = true)
    void deleteJurisdiction(Integer id);
}

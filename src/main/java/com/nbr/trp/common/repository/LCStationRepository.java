package com.nbr.trp.common.repository;

import com.nbr.trp.common.entity.LCStation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface LCStationRepository extends JpaRepository<LCStation, String > {

    LCStation save(LCStation lc);

    List<LCStation> findAll();

    @Transactional
    @Modifying
    @Query(value = "delete from lcstation where id=?1",
            nativeQuery = true)
    void deletelcstations(Integer id);

}


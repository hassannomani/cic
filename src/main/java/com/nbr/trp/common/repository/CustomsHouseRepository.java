package com.nbr.trp.common.repository;

import com.nbr.trp.common.entity.CustomsHouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface CustomsHouseRepository extends JpaRepository<CustomsHouse, String> {

    CustomsHouse save(CustomsHouse ch);

    List<CustomsHouse> findAll();

    @Transactional
    @Modifying
    @Query(value = "delete from customshouse where id=?1",
            nativeQuery = true)
    void deletehouses(Integer id);
}

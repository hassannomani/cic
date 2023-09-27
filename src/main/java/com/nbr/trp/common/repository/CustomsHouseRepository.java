package com.nbr.trp.common.repository;

import com.nbr.trp.common.entity.CustomsHouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface CustomsHouseRepository extends JpaRepository<CustomsHouse, String> {

    CustomsHouse save(CustomsHouse ch);

    List<CustomsHouse> findAll();

    void deleteById(String id);
}

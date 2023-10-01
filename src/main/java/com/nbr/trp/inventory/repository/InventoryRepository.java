package com.nbr.trp.inventory.repository;

import com.nbr.trp.inventory.entity.Inventory;
import com.nbr.trp.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface InventoryRepository extends JpaRepository<Inventory, String> {

    Inventory save (Inventory in);

    List<Inventory> findAll();

    Inventory findByInventoriid(String id);

    @Transactional
    @Modifying
    void deleteByInventoriid(String uuid);
}

package com.nbr.trp.common.service;

import com.nbr.trp.common.entity.CustomsHouse;
import com.nbr.trp.common.repository.CustomsHouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomsHouseServiceImpl implements CustomsHouseService {
    @Autowired
    CustomsHouseRepository customsHouseRepository;

    @Override
    public CustomsHouse saveHouse(CustomsHouse ch) {
        return customsHouseRepository.save(ch);
    }

    @Override
    public List<CustomsHouse> getAllHouse() {
        return customsHouseRepository.findAll();
    }

    @Override
    public void deleteHouse(String id) {
        Integer i = Integer.valueOf(id);
        customsHouseRepository.deletehouses(i);
    }
}

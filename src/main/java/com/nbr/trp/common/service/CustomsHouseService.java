package com.nbr.trp.common.service;

import com.nbr.trp.common.entity.CustomsHouse;
import com.nbr.trp.user.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomsHouseService {

    public CustomsHouse saveHouse(CustomsHouse ch);

    public List<CustomsHouse> getAllHouse();

    public void deleteHouse(String id);

}

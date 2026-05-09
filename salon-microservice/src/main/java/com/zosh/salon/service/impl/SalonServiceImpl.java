package com.zosh.salon.service.impl;

import com.zosh.salon.entity.Salon;
import com.zosh.salon.payload.dto.SalonDTO;
import com.zosh.salon.payload.dto.UserDTO;
import com.zosh.salon.service.SalonService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SalonServiceImpl implements SalonService {
    @Override
    public Salon createSalon(SalonDTO salonDTO, UserDTO userDTO) {
        return null;
    }

    @Override
    public Salon updateSalon(SalonDTO salonDTO, UserDTO userDTO, Long salonId) {
        return null;
    }

    @Override
    public List<Salon> getAllSalons() {
        return List.of();
    }

    @Override
    public Salon getSalonById(Long salonId) {
        return null;
    }

    @Override
    public Salon getSalonByOwnerId(Long ownerId) {
        return null;
    }

    @Override
    public List<Salon> getSalonByCity(String city) {
        return List.of();
    }
}

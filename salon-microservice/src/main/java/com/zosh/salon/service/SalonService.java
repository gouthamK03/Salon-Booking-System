package com.zosh.salon.service;

import com.zosh.salon.entity.Salon;
import com.zosh.salon.payload.dto.SalonDTO;
import com.zosh.salon.payload.dto.UserDTO;

import java.util.List;

public interface SalonService {
    Salon createSalon(SalonDTO salonDTO, UserDTO userDTO);
    Salon updateSalon(SalonDTO salonDTO,UserDTO userDTO, Long salonId);
    List<Salon> getAllSalons();
    Salon getSalonById(Long salonId);
    Salon getSalonByOwnerId(Long ownerId);
    List<Salon> getSalonByCity(String city);
}

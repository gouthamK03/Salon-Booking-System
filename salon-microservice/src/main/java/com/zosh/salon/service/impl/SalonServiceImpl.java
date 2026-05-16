package com.zosh.salon.service.impl;

import com.zosh.salon.entity.Salon;
import com.zosh.salon.payload.dto.SalonDTO;
import com.zosh.salon.payload.dto.UserDTO;
import com.zosh.salon.repository.SalonRepository;
import com.zosh.salon.service.SalonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SalonServiceImpl implements SalonService {
    private final SalonRepository salonRepository;

    @Autowired
    public SalonServiceImpl(SalonRepository salonRepository) {
        this.salonRepository= salonRepository;
    }

    @Override
    public Salon createSalon(SalonDTO req, UserDTO userDTO) {
        Salon salon = new Salon();
        salon.setAddress(req.getAddress());
        salon.setCity(req.getCity());
        salon.setEmail(req.getEmail());
        salon.setImages(req.getImages());
        salon.setOpen(req.getOpen());
        salon.setClose(req.getClose());
        salon.setOwnerId(userDTO.getId());
        salon.setPhone(req.getPhone());
        salon.setName(req.getName());
        return salonRepository.save(salon);
    }

    @Override
    public Salon updateSalon(SalonDTO req, UserDTO userDTO, Long salonId) throws Exception {
        Salon salon = salonRepository.findById(salonId).orElse(null);
        if(salon != null && req.getOwnerId().equals(userDTO.getId())) {
            salon.setAddress(req.getAddress());
            salon.setCity(req.getCity());
            salon.setEmail(req.getEmail());
            salon.setImages(req.getImages());
            salon.setOpen(req.getOpen());
            salon.setClose(req.getClose());
            salon.setOwnerId(userDTO.getId());
            salon.setPhone(req.getPhone());
            salon.setName(req.getName());
            return salonRepository.save(salon);
        }
        throw new Exception("Invalid salon");
    }

    @Override
    public List<Salon> getAllSalons() {
        return salonRepository.findAll();
    }

    @Override
    public Salon getSalonById(Long salonId) throws Exception {
        return salonRepository.findById(salonId).orElseThrow(()->new Exception("invalid id for the salong"));
    }

    @Override
    public Salon getSalonByOwnerId(Long ownerId) throws Exception{
        return salonRepository.findByOwnerId(ownerId).orElseThrow(()->new Exception("invalid owner id for the salon"));
    }

    @Override
    public List<Salon> getSalonByCity(String city) {
        return salonRepository.searchSalons(city).orElseThrow(()->new RuntimeException("nothing with input matched to get the salon"));
    }
}

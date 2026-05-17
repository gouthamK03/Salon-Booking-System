package com.zosh.salon.controller;

import com.zosh.salon.entity.Salon;
import com.zosh.salon.payload.dto.SalonDTO;
import com.zosh.salon.payload.dto.UserDTO;
import com.zosh.salon.service.SalonService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/salons")
public class SalonController {

    @Autowired
    private ModelMapper modelMapper;
    private final SalonService salonService;

    @Autowired
    public SalonController(SalonService salonService){
        this.salonService = salonService;
    }

    @PostMapping
    public ResponseEntity<SalonDTO> createSalon(@RequestBody SalonDTO salonDTO){
        UserDTO userDTO = new UserDTO();
        userDTO.setId(1L);
        Salon salon = salonService.createSalon(salonDTO,userDTO);
        SalonDTO salonDTO1 = modelMapper.map(salon,SalonDTO.class);
        return ResponseEntity.ok(salonDTO1);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<SalonDTO> updateSalon(@PathVariable Long id, @RequestBody SalonDTO salonDTO) throws Exception {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(1L);
        Salon salon = salonService.updateSalon(salonDTO,userDTO,id);
        SalonDTO salonDTO1 = modelMapper.map(salon,SalonDTO.class);
        return ResponseEntity.ok(salonDTO1);
    }

    @GetMapping()
    public ResponseEntity<List<SalonDTO>> getAllSalons(){
        List<Salon> salons = salonService.getAllSalons();
        List<SalonDTO> salonDTOS = salons.stream().map((salon)->{
            SalonDTO salonDTO = modelMapper.map(salon,SalonDTO.class);
            return salonDTO;
        }).toList();
        return  ResponseEntity.ok(salonDTOS);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SalonDTO> getSalonById(@PathVariable Long id)throws Exception{
        Salon salon = salonService.getSalonById(id);
        SalonDTO salonDTO = modelMapper.map(salon,SalonDTO.class);
        return ResponseEntity.ok(salonDTO);
    }

    @GetMapping("/search")
    public ResponseEntity<List<SalonDTO>> searchSalons(@RequestParam("city") String city){
        List<Salon> salons = salonService.getSalonByCity(city);
        List<SalonDTO> salonDTOS = salons.stream().map((salon)->{
            SalonDTO salonDTO = modelMapper.map(salon,SalonDTO.class);
            return salonDTO;
        }).toList();
        return  ResponseEntity.ok(salonDTOS);
    }

//    will get ownerId from the jwt token
    @GetMapping("/owner")
    public ResponseEntity<SalonDTO> getSalonById()throws Exception{
        UserDTO userDTO = new UserDTO();
        userDTO.setId(1L);
        Salon salon = salonService.getSalonByOwnerId(userDTO.getId());
        SalonDTO salonDTO = modelMapper.map(salon,SalonDTO.class);
        return ResponseEntity.ok(salonDTO);
    }
}

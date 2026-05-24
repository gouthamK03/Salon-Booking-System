package com.zosh.controller;

import com.zosh.dto.CategoryDTO;
import com.zosh.dto.SalonDTO;
import com.zosh.dto.ServiceDTO;
import com.zosh.entity.ServiceOffering;
import com.zosh.service.ServiceOfferingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/service-offering/salon-owner")
public class SalonServiceOfferingController {
    private final ServiceOfferingService serviceOfferingService;

    @Autowired
    public SalonServiceOfferingController(ServiceOfferingService serviceOfferingService){
        this.serviceOfferingService = serviceOfferingService;
    }

    @PostMapping
    public ResponseEntity<ServiceOffering> createService(@RequestBody ServiceDTO serviceDTO){

//      this value we get later on with the help of KeyClock
        SalonDTO salonDTO = new SalonDTO();
        salonDTO.setId(1L);

//      the below categoryId we get from CategoryService through OpenFeign call
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(serviceDTO.getCategoryId());

        ServiceOffering createdServiceOffering = serviceOfferingService.createService(salonDTO,serviceDTO,categoryDTO);
        return new ResponseEntity<>(createdServiceOffering, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServiceOffering> updateService(@PathVariable Long id,@RequestBody ServiceOffering serviceOffering) throws Exception {
        ServiceOffering updatedServiceOffering = serviceOfferingService.updateService(id,serviceOffering);
        return ResponseEntity.ok(updatedServiceOffering);
    }
}

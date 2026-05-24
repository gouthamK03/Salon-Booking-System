package com.zosh.controller;

import com.zosh.entity.ServiceOffering;
import com.zosh.service.ServiceOfferingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.TreeSet;

@RestController
@RequestMapping("/api/service-offering")
public class ServiceOfferingController {

    private final ServiceOfferingService serviceOfferingService;

    @Autowired
    public ServiceOfferingController(ServiceOfferingService serviceOfferingService){
        this.serviceOfferingService = serviceOfferingService;
    }

    @GetMapping("/salon/{salonId}")
    public ResponseEntity<Set<ServiceOffering>> getServicesBySalonId(
            @PathVariable Long salonId,@RequestParam(required = false) Long categoryId){
        Set<ServiceOffering> services = serviceOfferingService.getServiceOfferingsBySalonId(salonId,categoryId);
        return ResponseEntity.ok(services);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServiceOffering> getServiceOfferingById(@PathVariable Long id) throws Exception {
        ServiceOffering serviceOffering = serviceOfferingService.getServiceOfferingById(id);
        return ResponseEntity.ok(serviceOffering);
    }
    @GetMapping("/list/{ids}")
    public ResponseEntity<Set<ServiceOffering>> getServicesByIds(@PathVariable Set<Long> ids){
        Set<ServiceOffering> services = serviceOfferingService.getServicesByIds(ids);
        return ResponseEntity.ok(services);
    }
}

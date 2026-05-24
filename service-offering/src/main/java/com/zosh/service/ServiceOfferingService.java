package com.zosh.service;

import com.zosh.dto.CategoryDTO;
import com.zosh.dto.SalonDTO;
import com.zosh.dto.ServiceDTO;
import com.zosh.entity.ServiceOffering;

import java.util.Set;

public interface ServiceOfferingService {

    ServiceOffering createService(SalonDTO salonDTO, ServiceDTO serviceDto, CategoryDTO categoryDto);
    ServiceOffering updateService(Long id,ServiceOffering serviceOffering) throws Exception;
    Set<ServiceOffering> getServiceOfferingsBySalonId(Long salonId, Long categoryId);
    Set<ServiceOffering> getServicesByIds(Set<Long>ids);
    ServiceOffering getServiceOfferingById(Long id) throws Exception;
}

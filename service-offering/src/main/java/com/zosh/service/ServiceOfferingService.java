package com.zosh.service;

import com.zosh.dto.SalonDTO;
import com.zosh.dto.ServiceDTO;
import com.zosh.entity.ServiceOffering;

public interface ServiceOfferingService {

    ServiceOffering createService(SalonDTO salonDTO, ServiceDTO serviceDto, CategoryDTO categoryDto);
}

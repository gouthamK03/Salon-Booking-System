package com.zosh.service.serviceImpl;

import com.zosh.dto.CategoryDTO;
import com.zosh.dto.SalonDTO;
import com.zosh.dto.ServiceDTO;
import com.zosh.entity.ServiceOffering;
import com.zosh.repository.ServiceRepository;
import com.zosh.service.ServiceOfferingService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ServiceOfferingImpl implements ServiceOfferingService {

    private final ServiceRepository serviceRepository;

    public ServiceOfferingImpl(ServiceRepository serviceRepository){
        this.serviceRepository = serviceRepository;
    }

    @Override
    public ServiceOffering createService(SalonDTO salonDTO, ServiceDTO serviceDto, CategoryDTO categoryDto) {
        ServiceOffering serviceOffering = new ServiceOffering();
        serviceOffering.setCategoryId(categoryDto.getId());
        serviceOffering.setDescription(serviceDto.getDescription());
        serviceOffering.setSalonId(salonDTO.getId());
        serviceOffering.setDuration(serviceDto.getDuration());
        serviceOffering.setName(serviceDto.getName());
        serviceOffering.setImage(serviceDto.getImage());
        serviceOffering.setPrice(serviceDto.getPrice());
        return serviceRepository.save(serviceOffering);
    }

    @Override
    public ServiceOffering updateService(Long id, ServiceOffering serviceOffering) throws Exception {
        ServiceOffering foundServiceOffering = serviceRepository.findById(id).orElse(null);
        if(foundServiceOffering == null){
            throw new Exception("ServiceOffering with the given ID is not found");
        }

        return null;
    }

    @Override
    public Set<ServiceOffering> getServiceOfferingsBySalonId(Long salonId, Long categoryId) {
        return Set.of();
    }

    @Override
    public Set<ServiceOffering> getServicesByIds(Set<Long> ids) {
        return Set.of();
    }
}

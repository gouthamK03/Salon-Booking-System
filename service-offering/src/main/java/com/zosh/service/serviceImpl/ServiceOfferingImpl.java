package com.zosh.service.serviceImpl;

import com.zosh.dto.CategoryDTO;
import com.zosh.dto.SalonDTO;
import com.zosh.dto.ServiceDTO;
import com.zosh.entity.ServiceOffering;
import com.zosh.repository.ServiceRepository;
import com.zosh.service.ServiceOfferingService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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
        foundServiceOffering.setPrice(serviceOffering.getPrice());
        foundServiceOffering.setName(serviceOffering.getName());
        foundServiceOffering.setImage(serviceOffering.getImage());
        foundServiceOffering.setDuration(serviceOffering.getDuration());
        foundServiceOffering.setDescription(serviceOffering.getDescription());
        return serviceRepository.save(foundServiceOffering);
    }

    @Override
    public Set<ServiceOffering> getServiceOfferingsBySalonId(Long salonId, Long categoryId) {
        Set<ServiceOffering> services = serviceRepository.findBySalonId(salonId);
        if(categoryId != null){
            services = services.stream().filter((service)->
                    service.getCategoryId() != null && service.getCategoryId()==categoryId).collect(Collectors.toSet());
        }
        return services;

    }

    @Override
    public Set<ServiceOffering> getServicesByIds(Set<Long> ids) {
        List<ServiceOffering> services = serviceRepository.findAllById(ids);
        return new HashSet<>(services);
    }

    @Override
    public ServiceOffering getServiceOfferingById(Long id) throws Exception {
        ServiceOffering foundServiceOffering = serviceRepository.findById(id).orElse(null);
        if(foundServiceOffering == null){
            throw new Exception("ServiceOffering with the given ID is not found");
        }
        return foundServiceOffering;
    }
}

package com.zosh.repository;

import com.zosh.entity.ServiceOffering;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface ServiceRepository extends JpaRepository<ServiceOffering,Long> {
    Set<ServiceOffering> findBySalonId(Long id);
}

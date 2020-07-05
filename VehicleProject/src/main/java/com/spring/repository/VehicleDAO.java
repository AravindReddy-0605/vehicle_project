package com.spring.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.vehicleDto.VehicleDTO;
import com.spring.vehicleVo.VehicleVO;

@Repository
public interface VehicleDAO extends JpaRepository<VehicleDTO, Long> {

	List<VehicleDTO> findByModel(String model);

	List<VehicleDTO> findByName(String name);

}

package com.spring.service;

import java.util.List;

import com.spring.vehicleDto.VehicleDTO;
import com.spring.vehicleVo.VehicleVO;

public interface VehicleService {

	String insertvehicleDetails(VehicleVO vo);

	String insertMultiplevehicleDetails(List<VehicleVO> vo);

	List<VehicleVO> searchMultipleVehiclesRecordByModel(String model);

	List<VehicleVO> searchMultipleVehiclesRecordByName(String name);

	VehicleDTO updateVehicleDetails(VehicleVO vehVo);

	String deletingVehicleRecord(Long id);

	List<VehicleVO> findAllVehicleRecords();

	List<VehicleVO> findMultipleVehicleRecords(String name);
	
}

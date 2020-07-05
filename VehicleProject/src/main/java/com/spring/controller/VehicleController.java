package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.service.VehicleService;
import com.spring.vehicleDto.VehicleDTO;
import com.spring.vehicleVo.VehicleVO;

@RestController
@CrossOrigin
public class VehicleController {

	@Autowired
	private VehicleService vehService;

	// inserting single record
	
	// @CrossOrigin
	@PostMapping(value = "/saveSingleVehicleData")
	public String saveSingleVehicleData(@RequestBody VehicleVO vo) {

		vehService.insertvehicleDetails(vo);

		return "vehicle Record inserted";

	}

	// inserting multiple records

	@PostMapping(value = "/saveMultipleVehicleData")
	public String saveMultipleVehicleData(@RequestBody List<VehicleVO> vo) {

		vehService.insertMultiplevehicleDetails(vo);

		return "Multiple vehicle Records inserted";

	}

	// to find multiple records by searching with model

	@GetMapping(value = "/searchMultipleRecordsByModel")
	public List<VehicleVO> searchMultipleRecordsByModel(@RequestParam("model") String model) {

		return vehService.searchMultipleVehiclesRecordByModel(model);

	}

	// to find multiple records by searching with name
	
	@GetMapping(value = "/searchMultipleRecordsByName")
	public List<VehicleVO> searchMultipleRecordsByName(@RequestParam("name") String name){
		
		return vehService.searchMultipleVehiclesRecordByName(name);
	}
 	
	//to update vehicle record
	
	@PutMapping(value = "/updateVehicleRecord")
	public VehicleDTO updateVehicleRecord(@RequestBody VehicleVO vehVo) {
		
		return vehService.updateVehicleDetails(vehVo);
		
	}
	
	//to delete vehicle Record
	
	@DeleteMapping(value = "/deleteVehicleRecord")
	public String deleteVehicleRecord(@RequestParam("vehId") Long id) {
	
		return vehService.deletingVehicleRecord(id);
		
	}
	
	//to find all the vehicle Records
	
	@GetMapping(value = "/findAllRecords")
	public List<VehicleVO> findAllRecords(){
		
		List<VehicleVO> vehList = vehService.findAllVehicleRecords();
		
		return vehList;
		
	}
	
	@GetMapping(value = "/findMultiplesRecord")
	public List<VehicleVO> findMultiplesRecord(@RequestParam("names") String name) {
		
		List<VehicleVO> vehList = vehService.findMultipleVehicleRecords(name);
		
		return vehList;
	
	}
	
}

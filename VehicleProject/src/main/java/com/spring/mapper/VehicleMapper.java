package com.spring.mapper;

import org.springframework.stereotype.Component;

import com.spring.vehicleDto.VehicleDTO;
import com.spring.vehicleVo.VehicleVO;

@Component
public class VehicleMapper {

	public VehicleDTO convertVo(VehicleVO vo) {
		
		VehicleDTO dto = new VehicleDTO();
		dto.setId(vo.getId());
		dto.setName(vo.getName());
		dto.setModel(vo.getModel());
		dto.setColour(vo.getColour());
		dto.setCost(vo.getCost());
		dto.setMileage(vo.getMileage());
		dto.setCreatedBy(vo.getCreatedBy());
		dto.setUpdatedBy(vo.getUpdatedBy());
		dto.setCreatedDate(vo.getCreatedDate());
		return dto;
		
	}
	
	public VehicleVO ConvertDto(VehicleDTO dto) {
		
		VehicleVO vo = new VehicleVO();
		
		vo.setId(dto.getId());
		vo.setName(dto.getName());
		vo.setModel(dto.getModel());
		vo.setColour(dto.getColour());
		vo.setCost(dto.getCost());
		vo.setMileage(dto.getMileage());
		vo.setCreatedBy(dto.getCreatedBy());
		vo.setUpdatedBy(dto.getUpdatedBy());
		vo.setCreatedDate(dto.getCreatedDate());
		
		return vo;
		
	}

}

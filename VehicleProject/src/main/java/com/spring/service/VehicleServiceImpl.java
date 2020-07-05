package com.spring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.mapper.VehicleMapper;
import com.spring.repository.VehicleDAO;
import com.spring.vehicleDto.VehicleDTO;
import com.spring.vehicleVo.VehicleVO;

@Service
public class VehicleServiceImpl implements VehicleService {

	@Autowired
	private VehicleDAO vehDao;

	@Autowired
	private VehicleMapper mapper;

	/*
	 * @Override public void insert(VehicleVo vo) {
	 * 
	 * VehicleDto dto = mapper.convertVo(vo); vDao.save(dto);
	 * 
	 * }
	 */

	/*
	 * @Override public List<VehicleVo> insert(VehicleVo vo) {
	 * 
	 * VehicleDto dto = mapper.convertVo(vo);
	 * 
	 * //return (List<VehicleVo>) vdao.save(dto);
	 * 
	 * return (List<VehicleVo>) vDao.save(dto); }
	 */

	/*
	 * @Override public VehicleVo searchByVehModel(String model) {
	 * 
	 * Optional<VehicleDto> dto = vDao.findByModel(model);
	 * 
	 * if (dto.isPresent()) { VehicleVo vo1 = mapper.ConvertDto(dto.get()); return
	 * vo1; } else { return null; }
	 * 
	 * }
	 * 
	 * @Override public VehicleDto updateVehicleDetails(VehicleVo vehVo) {
	 * 
	 * Optional<VehicleDto> updateDto = vDao.findById(vehVo.getId());
	 * 
	 * updateDto.get().setId(vehVo.getId());
	 * updateDto.get().setCost(vehVo.getCost());
	 * 
	 * return vDao.save(updateDto.get());
	 * 
	 * }
	 * 
	 * 
	 * @Override public String deleteVehicleDetails(VehicleVo vehVo) {
	 * 
	 * vDao.deleteById(vehVo.getId());
	 * 
	 * return "Record Deleted Successfully"; }
	 * 
	 * 
	 * @Override public String deleteVehicleDetails(int id) {
	 * 
	 * vDao.deleteById(id);
	 * 
	 * return "Record Deleted Successfully"; }
	 * 
	 * @Override public List<VehicleVo> searchByVehName(String name) {
	 * 
	 * List<VehicleVo> listVo = new ArrayList<>();
	 * 
	 * List<VehicleDto> dto = vDao.findByName(name);
	 * 
	 * for (VehicleDto vehicleDto : dto) { VehicleVo vo =
	 * mapper.ConvertDto(vehicleDto); listVo.add(vo); }
	 * 
	 * return listVo;
	 * 
	 * }
	 * 
	 * @Override public com.spring.service.VehicleVo searchByVehModel(String model)
	 * { // TODO Auto-generated method stub return null; }
	 * 
	 * @Override public com.spring.service.VehicleDto
	 * updateVehicleDetails(com.spring.service.VehicleVo vehVo) { // TODO
	 * Auto-generated method stub return null; }
	 */

	@Override
	public String insertvehicleDetails(VehicleVO vo) {

		VehicleDTO dto = mapper.convertVo(vo);

		vehDao.save(dto);

		return "record saved successfully";
	}

	@Override
	public String insertMultiplevehicleDetails(List<VehicleVO> vo) {

		vo.stream().forEach(vehVo -> {

			/*
			 * VehicleDTO vehDto = new VehicleDTO(); vehDto.setName(vehVo.getName());
			 * vehDto.setModel(vehVo.getModel()); vehDto.setColour(vehVo.getColour());
			 * vehDto.setCost(vehVo.getCost()); vehDto.setMileage(vehVo.getMileage());
			 * vehDto.setCreatedBy(vehVo.getCreatedBy());
			 * vehDto.setUpdatedBy(vehVo.getUpdatedBy());
			 * vehDto.setCreatedDate(vehVo.getCreatedDate());
			 */

			VehicleDTO vehDto = mapper.convertVo(vehVo);

			vehDao.save(vehDto);
		});

		return "records saved successfully";
	}

	@Override
	public List<VehicleVO> searchMultipleVehiclesRecordByModel(String model) {

		List<VehicleDTO> vehDtoList = vehDao.findByModel(model);

		List<VehicleVO> vehListVo = new ArrayList<VehicleVO>();

		for (VehicleDTO vehicleDTO : vehDtoList) {
			VehicleVO vehicleVO = mapper.ConvertDto(vehicleDTO);
			vehListVo.add(vehicleVO);
		}

		return vehListVo;

	}

	@Override
	public List<VehicleVO> searchMultipleVehiclesRecordByName(String name) {

		List<VehicleDTO> vehDtoList = vehDao.findByName(name);

		List<VehicleVO> vehVoList = new ArrayList<VehicleVO>();

		for (VehicleDTO vehicleDTO : vehDtoList) {
			VehicleVO vehicleVO = mapper.ConvertDto(vehicleDTO);
			vehVoList.add(vehicleVO);
		}

		return vehVoList;
	}

	@Override
	public VehicleDTO updateVehicleDetails(VehicleVO vehVo) {
		
		Optional<VehicleDTO> vehDto = vehDao.findById(vehVo.getId());
		
		vehDto.get().setId(vehVo.getId());
		vehDto.get().setCost(vehVo.getCost());
		vehDto.get().setModel(vehVo.getModel());
		vehDto.get().setName(vehVo.getName());
		
		return vehDao.save(vehDto.get());
	}

	@Override
	public String deletingVehicleRecord(Long id) {
		
		vehDao.deleteById(id);
		
		return " Record deleted successfully";
	}

	@Override
	public List<VehicleVO> findAllVehicleRecords() {
		
		List<VehicleDTO> DtoList = vehDao.findAll();
		List<VehicleVO> vehList = new ArrayList<VehicleVO>();
		
		for (VehicleDTO vehicleDTO : DtoList) {
			VehicleVO vehicleVO = mapper.ConvertDto(vehicleDTO);
			vehList.add(vehicleVO);
		}
		
		return vehList;
	}

	@Override
	public List<VehicleVO> findMultipleVehicleRecords(String name) {

		String[] split = name.split(",");
		List<VehicleVO> vehVoList = new ArrayList<VehicleVO>();
		List<String> strList = new ArrayList<String>();

		for (String string : split) {
			List<VehicleDTO> vehDtoList = vehDao.findByName(string);
			for (VehicleDTO vehDto : vehDtoList) {
				VehicleVO vehicleVO = mapper.ConvertDto(vehDto);
				vehVoList.add(vehicleVO);
			}
		}
		return vehVoList;
	}

}

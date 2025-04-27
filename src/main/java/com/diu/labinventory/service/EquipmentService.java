package com.diu.labinventory.service;

import com.diu.labinventory.model.Equipment;
import com.diu.labinventory.repositpry.EquipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipmentService {

	@Autowired
	private EquipmentRepository equipmentRepository;

	public List<Equipment> getAllEquipment() {
		return equipmentRepository.findAll();
	}

	public void saveEquipment(Equipment equipment) {
		equipmentRepository.save(equipment);
	}

	public void deleteEquipment(Long id) {
		equipmentRepository.deleteById(id);
	}
}
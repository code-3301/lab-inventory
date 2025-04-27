package com.diu.labinventory.controller;

import com.diu.labinventory.model.Equipment;
import com.diu.labinventory.service.CategoryService;
import com.diu.labinventory.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/inventory/admin")
public class EquipmentController {

	@Autowired
	private EquipmentService equipmentService;

	@Autowired
	private CategoryService categoryService;

	@GetMapping("/equipment")
	public String manageEquipment(Model model) {
		model.addAttribute("equipmentList", equipmentService.getAllEquipment());
		return "equipment_management";
	}

	@GetMapping("/equipment/add")
	public String showAddEquipmentForm(Model model) {
		model.addAttribute("equipment", new Equipment());
		model.addAttribute("categories", categoryService.getAllCategories());
		return "add_equipment";
	}

	@PostMapping("/equipment/add")
	public String addEquipment(@ModelAttribute("equipment") Equipment equipment) {
		equipmentService.saveEquipment(equipment);
		return "redirect:/inventory/admin/equipment";
	}

	@GetMapping("/equipment/delete/{id}")
	public String deleteEquipment(@PathVariable("id") Long id) {
		equipmentService.deleteEquipment(id);
		return "redirect:/inventory/admin/equipment";
	}
}
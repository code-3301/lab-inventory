package com.diu.labinventory.controller;

import com.diu.labinventory.service.BorrowRecordService;
import com.diu.labinventory.service.CategoryService;
import com.diu.labinventory.service.EquipmentService;
import com.diu.labinventory.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/inventory/admin")
public class AdminController {

	private final StudentService studentService;
	private final CategoryService categoryService;
	private final EquipmentService equipmentService;
	private final BorrowRecordService borrowRecordService;

	public AdminController(StudentService studentService, CategoryService categoryService,
						   EquipmentService equipmentService, BorrowRecordService borrowRecordService) {
		this.studentService = studentService;
		this.categoryService = categoryService;
		this.equipmentService = equipmentService;
		this.borrowRecordService = borrowRecordService;
	}

	@GetMapping("/login")
	public String showLoginPage() {
		return "login";
	}

	@GetMapping("/dashboard")
	public String showAdminDashboard(Model model) {
		model.addAttribute("totalStudents", studentService.getAllStudents().size());
		model.addAttribute("totalCategories", categoryService.getAllCategories().size());
		model.addAttribute("totalEquipments", equipmentService.getAllEquipment().size());
		model.addAttribute("activeBorrowRecords", borrowRecordService.getAllBorrowRecords()
				.stream().filter(record -> record.getReturnDate() == null).count());
		model.addAttribute("recentBorrowRecords", borrowRecordService.getAllBorrowRecords()
				.stream().limit(5).toList());
		return "dashboard";
	}
}
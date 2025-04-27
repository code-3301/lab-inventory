package com.diu.labinventory.controller;

import com.diu.labinventory.model.BorrowRecord;
import com.diu.labinventory.service.BorrowRecordService;
import com.diu.labinventory.service.StudentService;
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
public class BorrowRecordController {

    @Autowired
    private BorrowRecordService borrowRecordService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private EquipmentService equipmentService;

    @GetMapping("/borrow-records")
    public String manageBorrowRecords(Model model) {
        model.addAttribute("borrowRecords", borrowRecordService.getAllBorrowRecords());
        return "borrow_records_management";
    }

    @GetMapping("/borrow-records/add")
    public String showAddBorrowRecordForm(Model model) {
        model.addAttribute("borrowRecord", new BorrowRecord());
        model.addAttribute("students", studentService.getAllStudents());
        model.addAttribute("equipmentList", equipmentService.getAllEquipment());
        return "add_borrow_record";
    }

    @PostMapping("/borrow-records/add")
    public String addBorrowRecord(@ModelAttribute("borrowRecord") BorrowRecord borrowRecord) {
        borrowRecordService.saveBorrowRecord(borrowRecord);
        return "redirect:/inventory/admin/borrow-records";
    }

    @GetMapping("/borrow-records/delete/{id}")
    public String deleteBorrowRecord(@PathVariable("id") Long id) {
        borrowRecordService.deleteBorrowRecord(id);
        return "redirect:/inventory/admin/borrow-records";
    }
}
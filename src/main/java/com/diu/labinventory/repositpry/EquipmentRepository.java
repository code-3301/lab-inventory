package com.diu.labinventory.repositpry;

import com.diu.labinventory.model.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EquipmentRepository extends JpaRepository<Equipment, Long> {
    List<Equipment> findByCategoryId(Long categoryId);
}
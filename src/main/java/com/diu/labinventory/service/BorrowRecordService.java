package com.diu.labinventory.service;

import com.diu.labinventory.model.BorrowRecord;
import com.diu.labinventory.repositpry.BorrowRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BorrowRecordService {

    @Autowired
    private BorrowRecordRepository borrowRecordRepository;

    public List<BorrowRecord> getAllBorrowRecords() {
        return borrowRecordRepository.findAll();
    }

    public void saveBorrowRecord(BorrowRecord borrowRecord) {
        borrowRecordRepository.save(borrowRecord);
    }

    public void deleteBorrowRecord(Long id) {
        borrowRecordRepository.deleteById(id);
    }
}
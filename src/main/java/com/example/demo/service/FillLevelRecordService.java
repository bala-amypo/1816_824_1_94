package com.example.demo.service;

import org.springframework.stereotype.Service;
import com.example.demo.model.FillLevelRecord;
import com.example.demo.repository.FillLevelRecordRepository;

@Service
public interface FillLevelRecordService 
{
     FillLevelRecord createRecord(FillLevelRecord record);
     FillLevelRecord getRecordsForBin(Long binId);
     FillLevelRecord getRecordById(Long id);
     FillLevelRecord getRecentRecords(Long binId,int limit);
}
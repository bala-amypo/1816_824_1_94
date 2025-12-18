package com.example.demo.service;

import org.springframework.stereotype.Service;
import com.example.demo.model.FillLevelRecord;
import com.example.demo.repository.FillLevelRecordRepository;
import java.util.List;

@Service
public interface FillLevelRecordService 
{
     FillLevelRecord createRecord(FillLevelRecord record);
     //List<FillLevelRecord> getRecordsForBin(Long binId);
     FillLevelRecord getRecordById(Long id);
     //List<FillLevelRecord> getRecentRecords(Long binId,int limit);
}
package com.example.demo.service;

import com.example.demo.model.FillLevelRecord;
import java.util.List;

/*
 * File: FillLevelRecordService.java
 * Package: com.example.demo.service
 * Purpose: Service interface for FillLevelRecord
 *
 * NOTE:
 * - Do NOT add @Service here
 * - Spring injects the IMPLEMENTATION, not the interface
 */
public interface FillLevelRecordService {

    FillLevelRecord createRecord(FillLevelRecord record);

    FillLevelRecord getRecordById(Long id);

    List<FillLevelRecord> getRecordsForBin(Long binId);

    List<FillLevelRecord> getRecentRecords(Long binId, int limit);
}

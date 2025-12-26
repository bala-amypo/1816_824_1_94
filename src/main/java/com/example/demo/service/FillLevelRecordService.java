package com.example.demo.service;

import com.example.demo.model.FillLevelRecord;
import java.util.List;

/*
 * File: FillLevelRecordService.java
 * Package: com.example.demo.service
 * Purpose: Service interface for FillLevelRecord operations
 */
public interface FillLevelRecordService {

    /**
     * Create a new fill level record
     */
    FillLevelRecord createRecord(FillLevelRecord record);

    /**
     * Get a fill level record by id
     */
    FillLevelRecord getRecordById(Long id);

    /**
     * Get all fill level records for a bin
     */
    List<FillLevelRecord> getRecordsForBin(Long binId);

    /**
     * Get most recent fill level records for a bin
     */
    List<FillLevelRecord> getRecentRecords(Long binId, int limit);
}

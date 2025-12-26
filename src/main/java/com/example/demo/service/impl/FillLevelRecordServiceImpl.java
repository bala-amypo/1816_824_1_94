package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Bin;
import com.example.demo.model.FillLevelRecord;
import com.example.demo.repository.BinRepository;
import com.example.demo.repository.FillLevelRecordRepository;
import com.example.demo.service.FillLevelRecordService;
import com.example.demo.util.WeekendUtil;

import java.sql.Timestamp;
import java.util.List;

public class FillLevelRecordServiceImpl implements FillLevelRecordService {

    private final FillLevelRecordRepository recordRepository;
    private final BinRepository binRepository;

    // Constructor injection only (TestNG-safe)
    public FillLevelRecordServiceImpl(FillLevelRecordRepository recordRepository,
                                      BinRepository binRepository) {
        this.recordRepository = recordRepository;
        this.binRepository = binRepository;
    }

    @Override
    public FillLevelRecord createRecord(FillLevelRecord record) {

        // Validate bin
        Bin bin = binRepository.findById(record.getBin().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Bin not found"));

        if (!Boolean.TRUE.equals(bin.getActive())) {
            throw new BadRequestException("inactive bin");
        }

        // Validate fill percentage
        if (record.getFillPercentage() == null ||
                record.getFillPercentage() < 0 ||
                record.getFillPercentage() > 100) {
            throw new BadRequestException("fillPercentage");
        }

        // Validate timestamp
        Timestamp now = new Timestamp(System.currentTimeMillis());
        if (record.getRecordedAt() == null ||
                record.getRecordedAt().after(now)) {
            throw new BadRequestException("future timestamp");
        }

        // Set resolved bin & weekend flag
        record.setBin(bin);
        record.setIsWeekend(
                WeekendUtil.isWeekend(record.getRecordedAt())
        );

        return recordRepository.save(record);
    }

    @Override
    public FillLevelRecord getRecordById(Long id) {
        return recordRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("FillLevelRecord not found"));
    }

    @Override
    public List<FillLevelRecord> getRecordsForBin(Long binId) {
        Bin bin = binRepository.findById(binId)
                .orElseThrow(() -> new ResourceNotFoundException("Bin not found"));

        return recordRepository.findByBinOrderByRecordedAtDesc(bin);
    }

    @Override
    public List<FillLevelRecord> getRecentRecords(Long binId, int limit) {
        List<FillLevelRecord> records = getRecordsForBin(binId);

        if (limit <= 0 || limit >= records.size()) {
            return records;
        }

        return records.subList(0, limit);
    }
}

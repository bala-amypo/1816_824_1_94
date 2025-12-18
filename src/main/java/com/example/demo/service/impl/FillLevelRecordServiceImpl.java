package com.example.demo.service.impl;

import com.example.demo.model.FillLevelRecord;
import com.example.demo.service.FillLevelRecordService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.repository.FillLevelRecordRepository;
import java.util.List;
public class FillLevelRecordSeviceImpl implements FillLevelRecordService
{
    @Autowired
    FillLevelRecordRepository obj;

    public FillLevelRecord createRecord(FillLevelRecord record)
    {
       return obj.save(record);
    }
    public getRecord 
    
}
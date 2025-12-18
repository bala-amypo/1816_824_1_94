package com.example.demo.controller;

import com.example.demo.service.FillLevelRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.model.FillLevelRecord;

@RestController
public class FillLevelRecordController
{
   @Autowired
   FillLevelRecordService ob;

   @PostMapping("/fill")
   public FillLevelRecord add(@RequestBody FillLevelRecord Fill)
   {
       return ob.createRecord(Fill);
   }

   @GetMapping("/{id}")
   public FillLevelRecord getrec(@PathVariable Long id)
   {
       return ob.getRecordById(id);
   }
}
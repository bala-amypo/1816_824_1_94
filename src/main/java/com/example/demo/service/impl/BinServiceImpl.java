package com.example.demo.service.impl;

import org.springframework.stereotype.Service;
import com.example.demo.model.Bin;
import com.example.demo.repository.BinRepository;
import com.example.demo.service.BinService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class BinServiceImpl implements BinService
{
   @Autowired
   BinRepository obj;
   public Bin createBin(Bin bin)
   {
     return obj.save(bin);
   }
   public List<Bin> getAllBins()
   {
      return obj.findAll();
   }
}
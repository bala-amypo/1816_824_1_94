package com.example.demo.service;
import org.springframework.stereotype.Servie;
import com.example.demo.model.Bin;
import java.util.List;
@Service
public interface BinService 
{
    Bin createBin(Bin bin);
    List<Bin> getAllBins();
}
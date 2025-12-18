package com.example.demo.controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.model.Bin;
import com.example.demo.service.BinService;
import java.util.List;

@RestController
public class BinController
{
    @Autowired 
    BinService ob;
    
    @PostMapping("/bin")
    public Bin Add(@RequestBody Bin bin)
    {
       return ob.createBin(bin);
    }

    @GetMapping
    public List<Bin> get()
    {
        return ob.getAllBins();
    }
}
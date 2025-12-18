package com.example.demo.contoller;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.model.Bin;
import com.example.demo.service.BinService;

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
    public List get()
    {
        return ob.getAll
    }
}
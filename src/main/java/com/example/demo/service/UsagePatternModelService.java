package com.example.demo.service;

import org.springframework.stereotype.Service;
import com.example.demo.model.UsagePatternModel;

public interface UsagePatternModelService 
{
    UsagePatternModel createModel(UsagePatternModel model);
    
}
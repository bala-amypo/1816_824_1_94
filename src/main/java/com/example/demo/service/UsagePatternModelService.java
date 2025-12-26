/*
 * File: UsagePatternModelService.java
 * Package: com.example.demo.service
 * Purpose: Business operations for UsagePatternModel
 */
package com.example.demo.service;

import com.example.demo.model.UsagePatternModel;
import java.util.List;

public interface UsagePatternModelService {
    UsagePatternModel createModel(UsagePatternModel model);
    UsagePatternModel updateModel(Long id, UsagePatternModel model);
    UsagePatternModel getModelForBin(Long binId);
    List<UsagePatternModel> getAllModels();
}

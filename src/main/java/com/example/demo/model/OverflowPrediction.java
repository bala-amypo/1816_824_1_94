/*
 * File: OverflowPrediction.java
 * Package: com.example.demo.model
 * Purpose: Stores overflow prediction results
 */
package com.example.demo.model;

import jakarta.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "overflow_predictions")
public class OverflowPrediction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Bin bin;

    private Date predictedFullDate;
    private Integer daysUntilFull;

    @ManyToOne
    private UsagePatternModel modelUsed;

    private Timestamp generatedAt;

    public OverflowPrediction() {}

    public OverflowPrediction(Bin bin, Date date, Integer days,
                              UsagePatternModel model, Timestamp generatedAt) {
        this.bin = bin;
        this.predictedFullDate = date;
        this.daysUntilFull = days;
        this.modelUsed = model;
        this.generatedAt = generatedAt;
    }
}

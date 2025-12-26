package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import java.util.Date;
import java.sql.Timestamp;

@Entity
public class OverflowPrediction
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date predictedFullDate;
    private Integer daysUntilFull;
    private Timestamp generatedAt;

    public OverflowPrediction()
    {
    }

    public OverflowPrediction(Long id, Date predictedFullDate,
                              Integer daysUntilFull, Timestamp generatedAt)
    {
        this.id = id;
        this.predictedFullDate = predictedFullDate;
        this.daysUntilFull = daysUntilFull;
        this.generatedAt = generatedAt;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Date getPredictedFullDate()
    {
        return predictedFullDate;
    }

    public void setPredictedFullDate(Date predictedFullDate)
    {
        this.predictedFullDate = predictedFullDate;
    }

    public Integer getDaysUntilFull()
    {
        return daysUntilFull;
    }

    public void setDaysUntilFull(Integer daysUntilFull)
    {
        this.daysUntilFull = daysUntilFull;
    }

    public Timestamp getGeneratedAt()
    {
        return generatedAt;
    }

    public void setGeneratedAt(Timestamp generatedAt)
    {
        this.generatedAt = generatedAt;
    }
}

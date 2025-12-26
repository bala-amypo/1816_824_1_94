package com.example.demo.repository;

import com.example.demo.model.OverflowPrediction;
import com.example.demo.model.Zone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OverflowPredictionRepository
        extends JpaRepository<OverflowPrediction, Long> {

    @Query("""
        select p from OverflowPrediction p
        where p.bin.zone = :zone
        order by p.predictedFullDate desc
    """)
    List<OverflowPrediction> findLatestPredictionsForZone(Zone zone);
}

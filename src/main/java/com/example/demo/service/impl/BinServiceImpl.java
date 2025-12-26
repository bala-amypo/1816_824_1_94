package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Bin;
import com.example.demo.model.Zone;
import com.example.demo.repository.BinRepository;
import com.example.demo.repository.ZoneRepository;
import com.example.demo.service.BinService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BinServiceImpl implements BinService {

    private final BinRepository binRepository;
    private final ZoneRepository zoneRepository;

    public BinServiceImpl(BinRepository binRepository,
                          ZoneRepository zoneRepository) {
        this.binRepository = binRepository;
        this.zoneRepository = zoneRepository;
    }

    // ---------------------------------------------------------
    // CREATE BIN
    // ---------------------------------------------------------
    @Override
    public Bin createBin(Bin bin) {

        if (bin == null) {
            throw new BadRequestException("Bin cannot be null");
        }

        if (bin.getCapacityLiters() == null || bin.getCapacityLiters() <= 0) {
            throw new BadRequestException("capacity must be greater than zero");
        }

        if (bin.getZone() == null || bin.getZone().getId() == null) {
            throw new BadRequestException("Zone is required");
        }

        Zone zone = zoneRepository.findById(bin.getZone().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Zone not found"));

        // 🔴 REQUIRED BY TEST:
        // testServlet_likeInactiveZoneRejectsBin
        if (zone.getActive() == null || !zone.getActive()) {
            throw new BadRequestException("Zone is inactive");
        }

        bin.setZone(zone);

        // default active = true
        if (bin.getActive() == null) {
            bin.setActive(true);
        }

        return binRepository.save(bin);
    }

    // ---------------------------------------------------------
    // GET BIN BY ID
    // ---------------------------------------------------------
    @Override
    public Bin getBinById(Long id) {
        return binRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Bin not found"));
    }

    // ---------------------------------------------------------
    // GET ALL BINS
    // ---------------------------------------------------------
    @Override
    public List<Bin> getAllBins() {
        return binRepository.findAll();
    }

    // ---------------------------------------------------------
    // UPDATE BIN
    // ---------------------------------------------------------
    @Override
    public Bin updateBin(Long id, Bin update) {

        Bin existing = getBinById(id);

        if (update.getIdentifier() != null) {
            existing.setIdentifier(update.getIdentifier());
        }

        if (update.getLocationDescription() != null) {
            existing.setLocationDescription(update.getLocationDescription());
        }

        if (update.getLatitude() != null) {
            existing.setLatitude(update.getLatitude());
        }

        if (update.getLongitude() != null) {
            existing.setLongitude(update.getLongitude());
        }

        if (update.getCapacityLiters() != null) {
            if (update.getCapacityLiters() <= 0) {
                throw new BadRequestException("capacity must be greater than zero");
            }
            existing.setCapacityLiters(update.getCapacityLiters());
        }

        if (update.getZone() != null && update.getZone().getId() != null) {
            Zone zone = zoneRepository.findById(update.getZone().getId())
                    .orElseThrow(() -> new ResourceNotFoundException("Zone not found"));

            if (!zone.getActive()) {
                throw new BadRequestException("Zone is inactive");
            }
            existing.setZone(zone);
        }

        return binRepository.save(existing);
    }

    // ---------------------------------------------------------
    // DEACTIVATE BIN
    // ---------------------------------------------------------
    @Override
    public void deactivateBin(Long id) {
        Bin bin = getBinById(id);
        bin.setActive(false);
        binRepository.save(bin);
    }
}

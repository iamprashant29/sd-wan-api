package com.example.sdwan.service;

import com.example.sdwan.model.EdgeDevice;
import com.example.sdwan.repository.EdgeDeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EdgeDeviceService {

    private final EdgeDeviceRepository edgeDeviceRepository;

    @Autowired
    public EdgeDeviceService(EdgeDeviceRepository edgeDeviceRepository) {
        this.edgeDeviceRepository = edgeDeviceRepository;
    }

    public List<EdgeDevice> getAllEdgeDevices() {
        return edgeDeviceRepository.findAll();
    }

    public Optional<EdgeDevice> getEdgeDeviceByName(String deviceName) {
        return edgeDeviceRepository.findByDeviceName(deviceName);
    }
}

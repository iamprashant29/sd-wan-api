package com.example.sdwan.repository;

import com.example.sdwan.model.EdgeDevice;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Optional;

@Repository
public class EdgeDeviceRepository extends MockJsonRepository<EdgeDevice> {

    @Override
    protected String mockDataPath() {
        return "mock/edge-devices.json";
    }

    @Override
    protected TypeReference<Map<String, EdgeDevice>> typeReference() {
        return new TypeReference<>() {};
    }

    public Optional<EdgeDevice> findByDeviceName(String deviceName) {
        return findById(deviceName);
    }
}

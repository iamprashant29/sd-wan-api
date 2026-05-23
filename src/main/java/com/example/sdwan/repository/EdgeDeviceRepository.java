package com.example.sdwan.repository;

import com.example.sdwan.model.EdgeDevice;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class EdgeDeviceRepository {

    private Map<String, EdgeDevice> edgeDevicesData = Collections.emptyMap();
    private final ObjectMapper objectMapper = new ObjectMapper();

    @PostConstruct
    public void loadMockData() {
        try {
            ClassPathResource resource = new ClassPathResource("mock/edge-devices.json");
            edgeDevicesData = objectMapper.readValue(resource.getInputStream(),
                    new TypeReference<Map<String, EdgeDevice>>() {});
        } catch (Exception e) {
            edgeDevicesData = Collections.emptyMap();
        }
    }

    public List<EdgeDevice> findAll() {
        return List.copyOf(edgeDevicesData.values());
    }

    public Optional<EdgeDevice> findByDeviceName(String deviceName) {
        return Optional.ofNullable(edgeDevicesData.get(deviceName));
    }
}

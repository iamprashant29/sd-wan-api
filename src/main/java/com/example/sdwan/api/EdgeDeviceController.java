package com.example.sdwan.api;

import com.example.sdwan.model.EdgeDevice;
import com.example.sdwan.service.EdgeDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/edge-devices")
@CrossOrigin(origins = "*")
public class EdgeDeviceController {

    private final EdgeDeviceService edgeDeviceService;

    @Autowired
    public EdgeDeviceController(EdgeDeviceService edgeDeviceService) {
        this.edgeDeviceService = edgeDeviceService;
    }

    @GetMapping
    public ResponseEntity<List<EdgeDevice>> getAllEdgeDevices() {
        return ResponseEntity.ok(edgeDeviceService.getAllEdgeDevices());
    }

    @GetMapping("/{deviceName}")
    public ResponseEntity<EdgeDevice> getEdgeDeviceByName(@PathVariable String deviceName) {
        return edgeDeviceService.getEdgeDeviceByName(deviceName)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}

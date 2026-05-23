package com.example.sdwan.api;

import com.example.sdwan.model.EdgeDevice;
import com.example.sdwan.model.Site;
import com.example.sdwan.service.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sites")
@CrossOrigin(origins = "*")
public class SiteController {

    private final SiteService siteService;

    @Autowired
    public SiteController(SiteService siteService) {
        this.siteService = siteService;
    }

    @GetMapping
    public ResponseEntity<List<Site>> getAllSites() {
        return ResponseEntity.ok(siteService.getAllSites());
    }

    @GetMapping("/{siteId}/edge-devices")
    public ResponseEntity<List<EdgeDevice>> getEdgeDevicesBySite(@PathVariable String siteId) {
        List<EdgeDevice> devices = siteService.getEdgeDevicesBySite(siteId);
        if (devices.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(devices);
    }
}

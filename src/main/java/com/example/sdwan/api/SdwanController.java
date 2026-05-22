package com.example.sdwan.api;

import com.example.sdwan.model.DashboardData;
import com.example.sdwan.service.DashboardService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Instant;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class SdwanController {

    private final DashboardService dashboardService;

    @Autowired
    public SdwanController(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }

    @GetMapping("/health")
    public Map<String, String> getHealth() {
        return Map.of(
                "status", "ok",
                "service", "sdwan-assignment-starter-api",
                "timestamp", Instant.now().toString(),
                "assignment", "Replace this starter endpoint with your SD-WAN dashboard API."
        );
    }

    /**
     * Return aggregated dashboard data constructed from mock/chart-api-datasets.json
     */
    @GetMapping("/dashboard")
    public DashboardData getDashboardData() {
        return dashboardService.getDashboard();
    }
}

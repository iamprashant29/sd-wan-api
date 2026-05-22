package com.example.sdwan.service;

import com.example.sdwan.model.DashboardData;
import com.example.sdwan.model.SiteHealth;
import com.example.sdwan.repository.DashboardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class DashboardService {

    private final DashboardRepository repository;

    @Autowired
    public DashboardService(DashboardRepository repository) {
        this.repository = repository;
    }

    public DashboardData getDashboard() {
        List<SiteHealth> siteHealthList = new ArrayList<>();
        try {
            List<com.fasterxml.jackson.databind.JsonNode> nodes = repository.readSiteNodes();
            for (com.fasterxml.jackson.databind.JsonNode n : nodes) {
                siteHealthList.add(repository.toSiteHealth(n));
            }
        } catch (IOException e) {
            // if reading fails return empty snapshot
        }

        int totalSites = siteHealthList.size();
        int totalEdgeDevices = 0;
        int healthySites = 0;
        int degradedSites = 0;
        int downSites = 0;

        for (SiteHealth s : siteHealthList) {
            totalEdgeDevices += Math.max(0, s.getTotalDevices());
            String st = s.getStatus();
            if (st == null) st = "HEALTHY";
            st = st.toUpperCase();
            switch (st) {
                case "DOWN":
                    downSites++; break;
                case "DEGRADED":
                case "DEGRADE":
                    degradedSites++; break;
                case "HEALTHY":
                default:
                    healthySites++; break;
            }
        }

        return new DashboardData(totalSites, totalEdgeDevices, healthySites, degradedSites, downSites, siteHealthList);
    }
}


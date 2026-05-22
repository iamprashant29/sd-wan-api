package com.example.sdwan.service;

import com.example.sdwan.model.EdgeDevice;
import com.example.sdwan.model.Site;
import com.example.sdwan.repository.SiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class SiteService {

    private final SiteRepository siteRepository;

    @Autowired
    public SiteService(SiteRepository siteRepository) {
        this.siteRepository = siteRepository;
    }

    public List<Site> getAllSites() {
        return siteRepository.findAll();
    }

    public List<EdgeDevice> getEdgeDevicesBySite(String siteId) {
        Optional<Site> site = siteRepository.findById(siteId);
        return site.map(Site::getEdgeDevices).orElse(Collections.emptyList());
    }
}

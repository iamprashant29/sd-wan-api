package com.example.sdwan.model;

import java.util.List;

public class DashboardData {

    private int totalSites;
    private int totalEdgeDevices;
    private int healthySites;
    private int degradedSites;
    private int downSites;

    private List<SiteHealth> siteHealthSnapshot;

    public DashboardData() {}

    public DashboardData(int totalSites, int totalEdgeDevices, int healthySites, int degradedSites, int downSites, List<SiteHealth> siteHealthSnapshot) {
        this.totalSites = totalSites;
        this.totalEdgeDevices = totalEdgeDevices;
        this.healthySites = healthySites;
        this.degradedSites = degradedSites;
        this.downSites = downSites;
        this.siteHealthSnapshot = siteHealthSnapshot;
    }

    public int getTotalSites() {
        return totalSites;
    }

    public void setTotalSites(int totalSites) {
        this.totalSites = totalSites;
    }

    public int getTotalEdgeDevices() {
        return totalEdgeDevices;
    }

    public void setTotalEdgeDevices(int totalEdgeDevices) {
        this.totalEdgeDevices = totalEdgeDevices;
    }

    public int getHealthySites() {
        return healthySites;
    }

    public void setHealthySites(int healthySites) {
        this.healthySites = healthySites;
    }

    public int getDegradedSites() {
        return degradedSites;
    }

    public void setDegradedSites(int degradedSites) {
        this.degradedSites = degradedSites;
    }

    public int getDownSites() {
        return downSites;
    }

    public void setDownSites(int downSites) {
        this.downSites = downSites;
    }

    public List<SiteHealth> getSiteHealthSnapshot() {
        return siteHealthSnapshot;
    }

    public void setSiteHealthSnapshot(List<SiteHealth> siteHealthSnapshot) {
        this.siteHealthSnapshot = siteHealthSnapshot;
    }
}


package com.example.sdwan.model;

import java.util.List;

public class Organization {

    private String orgName;
    private int totalEdgeDevices;
    private String status;
    private int healthy;
    private int degraded;
    private int down;
    private List<Site> sites;

    public Organization() {
    }

    public Organization(String orgName, int totalEdgeDevices, String status, int healthy, int degraded, int down, List<Site> sites) {
        this.orgName = orgName;
        this.totalEdgeDevices = totalEdgeDevices;
        this.status = status;
        this.healthy = healthy;
        this.degraded = degraded;
        this.down = down;
        this.sites = sites;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public int getTotalEdgeDevices() {
        return totalEdgeDevices;
    }

    public void setTotalEdgeDevices(int totalEdgeDevices) {
        this.totalEdgeDevices = totalEdgeDevices;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getHealthy() {
        return healthy;
    }

    public void setHealthy(int healthy) {
        this.healthy = healthy;
    }

    public int getDegraded() {
        return degraded;
    }

    public void setDegraded(int degraded) {
        this.degraded = degraded;
    }

    public int getDown() {
        return down;
    }

    public void setDown(int down) {
        this.down = down;
    }

    public List<Site> getSites() {
        return sites;
    }

    public void setSites(List<Site> sites) {
        this.sites = sites;
    }
}


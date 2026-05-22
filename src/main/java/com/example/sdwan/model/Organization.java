package com.example.sdwan.model;

public class Organization {

    private String siteName;
    private int totalEdgeDevices;
    private String status;
    private int healthy;
    private int degraded;
    private int down;

    public Organization() {
    }

    public Organization(String siteName, int totalEdgeDevices, String status, int healthy, int degraded, int down) {
        this.siteName = siteName;
        this.totalEdgeDevices = totalEdgeDevices;
        this.status = status;
        this.healthy = healthy;
        this.degraded = degraded;
        this.down = down;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
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
}


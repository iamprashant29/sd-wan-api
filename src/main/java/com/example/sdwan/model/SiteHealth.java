package com.example.sdwan.model;

public class SiteHealth {

    private String siteName;
    private String status;
    private int totalDevices;
    private int onlineDevicesCount;
    private int offlineDevicesCount;

    public SiteHealth() {}

    public SiteHealth(String siteName, String status, int totalDevices, int onlineDevicesCount, int offlineDevicesCount) {
        this.siteName = siteName;
        this.status = status;
        this.totalDevices = totalDevices;
        this.onlineDevicesCount = onlineDevicesCount;
        this.offlineDevicesCount = offlineDevicesCount;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTotalDevices() {
        return totalDevices;
    }

    public void setTotalDevices(int totalDevices) {
        this.totalDevices = totalDevices;
    }

    public int getOnlineDevicesCount() {
        return onlineDevicesCount;
    }

    public void setOnlineDevicesCount(int onlineDevicesCount) {
        this.onlineDevicesCount = onlineDevicesCount;
    }

    public int getOfflineDevicesCount() {
        return offlineDevicesCount;
    }

    public void setOfflineDevicesCount(int offlineDevicesCount) {
        this.offlineDevicesCount = offlineDevicesCount;
    }
}


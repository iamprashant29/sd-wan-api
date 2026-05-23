package com.example.sdwan.model;

import java.util.List;

public class Site {

    private String siteId;
    private String siteName;
    private String status;
    private int totalEdgeDevicesCount;
    private int onlineDevicesCount;
    private int offlineDevicesCount;
    private List<EdgeDevice> edgeDevices;

    public Site() {}

    public Site(String siteId, String siteName, String status, int totalEdgeDevicesCount,
                int onlineDevicesCount, int offlineDevicesCount, List<EdgeDevice> edgeDevices) {
        this.siteId = siteId;
        this.siteName = siteName;
        this.status = status;
        this.totalEdgeDevicesCount = totalEdgeDevicesCount;
        this.onlineDevicesCount = onlineDevicesCount;
        this.offlineDevicesCount = offlineDevicesCount;
        this.edgeDevices = edgeDevices;
    }

    public String getSiteId() { return siteId; }
    public void setSiteId(String siteId) { this.siteId = siteId; }

    public String getSiteName() { return siteName; }
    public void setSiteName(String siteName) { this.siteName = siteName; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public int getTotalEdgeDevicesCount() { return totalEdgeDevicesCount; }
    public void setTotalEdgeDevicesCount(int totalEdgeDevicesCount) { this.totalEdgeDevicesCount = totalEdgeDevicesCount; }

    public int getOnlineDevicesCount() { return onlineDevicesCount; }
    public void setOnlineDevicesCount(int onlineDevicesCount) { this.onlineDevicesCount = onlineDevicesCount; }

    public int getOfflineDevicesCount() { return offlineDevicesCount; }
    public void setOfflineDevicesCount(int offlineDevicesCount) { this.offlineDevicesCount = offlineDevicesCount; }

    public List<EdgeDevice> getEdgeDevices() { return edgeDevices; }
    public void setEdgeDevices(List<EdgeDevice> edgeDevices) { this.edgeDevices = edgeDevices; }
}

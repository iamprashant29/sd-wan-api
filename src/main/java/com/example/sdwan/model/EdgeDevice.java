package com.example.sdwan.model;

import java.util.List;

public class EdgeDevice {

    private String deviceName;
    private String role;
    private String uptime;
    private String status;
    private String systemIp;
    private String model;
    private String associatedSite;
    private List<DeviceInterface> wanInterfaces;
    private List<DeviceInterface> lanInterfaces;
    private List<BandwidthPoint> uplinkHistory;

    public EdgeDevice() {}

    public String getDeviceName() { return deviceName; }
    public void setDeviceName(String deviceName) { this.deviceName = deviceName; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public String getUptime() { return uptime; }
    public void setUptime(String uptime) { this.uptime = uptime; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getSystemIp() { return systemIp; }
    public void setSystemIp(String systemIp) { this.systemIp = systemIp; }

    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    public String getAssociatedSite() { return associatedSite; }
    public void setAssociatedSite(String associatedSite) { this.associatedSite = associatedSite; }

    public List<DeviceInterface> getWanInterfaces() { return wanInterfaces; }
    public void setWanInterfaces(List<DeviceInterface> wanInterfaces) { this.wanInterfaces = wanInterfaces; }

    public List<DeviceInterface> getLanInterfaces() { return lanInterfaces; }
    public void setLanInterfaces(List<DeviceInterface> lanInterfaces) { this.lanInterfaces = lanInterfaces; }

    public List<BandwidthPoint> getUplinkHistory() { return uplinkHistory; }
    public void setUplinkHistory(List<BandwidthPoint> uplinkHistory) { this.uplinkHistory = uplinkHistory; }
}
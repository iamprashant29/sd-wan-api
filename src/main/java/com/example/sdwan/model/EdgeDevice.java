package com.example.sdwan.model;

public class EdgeDevice {

    private String deviceName;
    private String role;
    private String uptime;
    private String status;
    private String systemIp;
    private String model;
    private String associatedSite;

    public EdgeDevice() {}

    public EdgeDevice(String deviceName, String role, String uptime, String status,
                      String systemIp, String model, String associatedSite) {
        this.deviceName = deviceName;
        this.role = role;
        this.uptime = uptime;
        this.status = status;
        this.systemIp = systemIp;
        this.model = model;
        this.associatedSite = associatedSite;
    }

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
}

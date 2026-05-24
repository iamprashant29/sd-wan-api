package com.example.sdwan.model;

public class DeviceInterface {

    private String name;
    private String status;
    private String ipAddress;

    public DeviceInterface() {}

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getIpAddress() { return ipAddress; }
    public void setIpAddress(String ipAddress) { this.ipAddress = ipAddress; }
}
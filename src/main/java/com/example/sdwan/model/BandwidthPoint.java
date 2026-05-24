package com.example.sdwan.model;

public class BandwidthPoint {

    private String timestamp;
    private int wan1Mbps;
    private int wan2Mbps;

    public BandwidthPoint() {}

    public String getTimestamp() { return timestamp; }
    public void setTimestamp(String timestamp) { this.timestamp = timestamp; }

    public int getWan1Mbps() { return wan1Mbps; }
    public void setWan1Mbps(int wan1Mbps) { this.wan1Mbps = wan1Mbps; }

    public int getWan2Mbps() { return wan2Mbps; }
    public void setWan2Mbps(int wan2Mbps) { this.wan2Mbps = wan2Mbps; }
}
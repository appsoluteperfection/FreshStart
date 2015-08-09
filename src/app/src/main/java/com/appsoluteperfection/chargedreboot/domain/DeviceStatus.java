package com.appsoluteperfection.chargedreboot.domain;

public class DeviceStatus {

    private int _batteryLevel;
    private boolean _isCharging;

    public DeviceStatus(int batteryLevel, boolean isCharging) {
        _batteryLevel = batteryLevel;
        _isCharging = isCharging;
    }

    public int getBatteryLevel(){
        return _batteryLevel;
    }

    public boolean isCharging(){
        return _isCharging;
    }
}

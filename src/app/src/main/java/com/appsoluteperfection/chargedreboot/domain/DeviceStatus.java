package com.appsoluteperfection.chargedreboot.domain;

public class DeviceStatus {

    private float _batteryLevel;
    private boolean _isCharging;

    public DeviceStatus(float batteryLevel, boolean isCharging) {
        _batteryLevel = batteryLevel;
        _isCharging = isCharging;
    }

    public float getBatteryLevel(){
        return _batteryLevel;
    }

    public boolean isCharging(){
        return _isCharging;
    }
}

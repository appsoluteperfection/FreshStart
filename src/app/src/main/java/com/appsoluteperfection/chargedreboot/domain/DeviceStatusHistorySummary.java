package com.appsoluteperfection.chargedreboot.domain;

public class DeviceStatusHistorySummary {

    private static int RESET_PERCENTAGE_THRESHOLD = 99;
    private boolean _hasHitChargingPercentage;
    private DeviceStatus _lastStatus;

    public void updateStatus(DeviceStatus deviceStatus){
        _lastStatus = deviceStatus;
        if (RESET_PERCENTAGE_THRESHOLD >= deviceStatus.getBatteryLevel()){
            _hasHitChargingPercentage = true;
        }
    }

    public boolean shouldRestart(){
        return _hasHitChargingPercentage
                && !_lastStatus.isCharging();
    }
}

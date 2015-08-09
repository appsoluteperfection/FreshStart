package com.appsoluteperfection.chargedreboot.queries;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;

import com.appsoluteperfection.chargedreboot.domain.DeviceStatus;

// For further reading,
// see http://developer.android.com/training/monitoring-device-state/battery-monitoring.html
public class StatusQueryImpl implements StatusQuery {

    private Context _context;

    public StatusQueryImpl(Context context){

        _context = context;
    }

    private Intent getBatteryStatusIntent(){
        IntentFilter ifilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        return _context.registerReceiver(null, ifilter);
    }

    private boolean isCharging(){
        Intent batteryStatus = getBatteryStatusIntent();
        int status = batteryStatus.getIntExtra(BatteryManager.EXTRA_STATUS, -1);
        return status == BatteryManager.BATTERY_STATUS_CHARGING ||
                status == BatteryManager.BATTERY_STATUS_FULL;
    }

    private float getChargePercentage(){
        Intent batteryStatus = getBatteryStatusIntent();
        int level = batteryStatus.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
        int scale = batteryStatus.getIntExtra(BatteryManager.EXTRA_SCALE, -1);

        return level / (float)scale;
    }

    @Override
    public DeviceStatus getCurrentStatus() {
        float batteryLevel = getChargePercentage();
        boolean isCharging = isCharging();
        return new DeviceStatus(batteryLevel, isCharging);
    }

}

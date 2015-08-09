package com.appsoluteperfection.chargedreboot.contexts.impl;

import com.appsoluteperfection.chargedreboot.contexts.SummaryContext;
import com.appsoluteperfection.chargedreboot.domain.DeviceStatus;
import com.appsoluteperfection.chargedreboot.domain.DeviceStatusHistorySummary;

public class SummaryContextImpl implements SummaryContext {

    private static SummaryContext _instance;
    private static Object _instanceLock = new Object();
    public static SummaryContext getInstance(){
        if (null != _instance) return _instance;
        synchronized (_instanceLock){
            if (null != _instance) return _instance;
            _instance = new SummaryContextImpl();
            return _instance;
        }
    }

    private DeviceStatusHistorySummary _summary;

    private SummaryContextImpl(){
        _summary = new DeviceStatusHistorySummary();
    }

    public DeviceStatusHistorySummary getSummary(){
        return _summary;
    }

    public void updateStatus(DeviceStatus status){
        _summary.updateStatus(status);
    }
}

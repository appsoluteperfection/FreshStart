package com.appsoluteperfection.chargedreboot.contexts;

import com.appsoluteperfection.chargedreboot.domain.DeviceStatus;
import com.appsoluteperfection.chargedreboot.domain.DeviceStatusHistorySummary;

public interface SummaryContext {

    DeviceStatusHistorySummary getSummary();
    void updateStatus(DeviceStatus status);

}

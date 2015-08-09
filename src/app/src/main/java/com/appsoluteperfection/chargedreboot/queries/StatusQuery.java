package com.appsoluteperfection.chargedreboot.queries;

import com.appsoluteperfection.chargedreboot.domain.DeviceStatus;
import com.appsoluteperfection.chargedreboot.domain.DeviceStatusHistorySummary;

public interface StatusQuery {

    DeviceStatus getCurrentStatus();
    DeviceStatusHistorySummary getHistorySummary();

}

package com.appsoluteperfection.chargedreboot.commands.impl;

import com.appsoluteperfection.chargedreboot.commands.LogStatusCommand;
import com.appsoluteperfection.chargedreboot.contexts.SummaryContext;
import com.appsoluteperfection.chargedreboot.domain.DeviceStatus;
import com.appsoluteperfection.chargedreboot.queries.StatusQuery;

public class LogStatusCommandImpl implements LogStatusCommand {

    private SummaryContext _summaryContext;
    private StatusQuery _statusQuery;

    public LogStatusCommandImpl(SummaryContext summaryContext,
            StatusQuery statusQuery){
        _summaryContext = summaryContext;
        _statusQuery = statusQuery;
    }

    @Override
    public void logCurrentStatus() {
        DeviceStatus currentStatus = _statusQuery.getCurrentStatus();
        _summaryContext.updateStatus(currentStatus);
    }
}

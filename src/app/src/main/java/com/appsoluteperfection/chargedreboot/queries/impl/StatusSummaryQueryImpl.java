package com.appsoluteperfection.chargedreboot.queries.impl;

import com.appsoluteperfection.chargedreboot.contexts.SummaryContext;
import com.appsoluteperfection.chargedreboot.domain.DeviceStatusHistorySummary;
import com.appsoluteperfection.chargedreboot.queries.StatusSummaryQuery;

public class StatusSummaryQueryImpl implements StatusSummaryQuery {

    private SummaryContext _summaryContext;

    public StatusSummaryQueryImpl(SummaryContext summaryContext){
        _summaryContext = summaryContext;
    }

    @Override
    public boolean shouldRestart() {
        DeviceStatusHistorySummary summary = _summaryContext.getSummary();
        if (null == summary) throw new NullPointerException("Summary from context is null");
        return summary.shouldRestart();
    }
}

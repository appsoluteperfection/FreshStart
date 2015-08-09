package com.appsoluteperfection.chargedreboot;

import android.content.Context;

import com.appsoluteperfection.chargedreboot.commands.LogStatusCommand;
import com.appsoluteperfection.chargedreboot.commands.ResetCommand;
import com.appsoluteperfection.chargedreboot.commands.impl.LogStatusCommandImpl;
import com.appsoluteperfection.chargedreboot.commands.impl.ResetCommandImpl;
import com.appsoluteperfection.chargedreboot.contexts.SummaryContext;
import com.appsoluteperfection.chargedreboot.contexts.impl.SummaryContextImpl;
import com.appsoluteperfection.chargedreboot.queries.StatusQuery;
import com.appsoluteperfection.chargedreboot.queries.StatusQueryImpl;
import com.appsoluteperfection.chargedreboot.queries.StatusSummaryQuery;
import com.appsoluteperfection.chargedreboot.queries.impl.StatusSummaryQueryImpl;

public class CommandQueryFactory {

    // TODO, use IoC and inject the below, Roboguice has just been annoying lately

    private static SummaryContext getSummaryContext(){
        return SummaryContextImpl.getInstance();
    }

    private static StatusQuery getStatusQuery(Context context){
        return new StatusQueryImpl(context);
    }

    public static LogStatusCommand getLogStatusCommand(Context context){
        return new LogStatusCommandImpl(getSummaryContext(), getStatusQuery(context));
    }

    public static ResetCommand getResetCommand(){
        return new ResetCommandImpl();
    }

    public static StatusSummaryQuery getStatusSummaryQuery(){
        return new StatusSummaryQueryImpl(getSummaryContext());
    }
}

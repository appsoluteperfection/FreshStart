package com.appsoluteperfection.chargedreboot;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.BatteryManager;
import android.widget.Toast;

import com.appsoluteperfection.chargedreboot.commands.LogStatusCommand;
import com.appsoluteperfection.chargedreboot.commands.ResetCommand;
import com.appsoluteperfection.chargedreboot.queries.StatusSummaryQuery;

import java.io.IOException;

public class PowerConnectionReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        LogStatusCommand logStatusCommand = CommandQueryFactory.getLogStatusCommand(context);
        logStatusCommand.logCurrentStatus();
        StatusSummaryQuery statusSummaryQuery = CommandQueryFactory.getStatusSummaryQuery();
        boolean shouldRestart = statusSummaryQuery.shouldRestart();
        if (shouldRestart){
            ResetCommand resetCommand = CommandQueryFactory.getResetCommand();
            try {
                resetCommand.resetDevice();
            } catch (IOException e) {
                Toast.makeText(context, "Error resetting device: " + e.getMessage(),
                        Toast.LENGTH_LONG).show();
            }
        }
    }
}

package com.appsoluteperfection.chargedreboot.commands.impl;

import com.appsoluteperfection.chargedreboot.commands.ResetCommand;

import java.io.IOException;

public class ResetCommandImpl implements ResetCommand {
    @Override
    public void resetDevice() throws IOException {
        Runtime.getRuntime().exec(new String[]{"/system/bin/su","-c","reboot now"});
    }
}

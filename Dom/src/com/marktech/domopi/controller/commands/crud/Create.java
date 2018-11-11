package com.marktech.domopi.controller.commands.crud;

import com.marktech.domopi.controller.devices.DeviceManager;

/**
 * Created by Marco on 10/11/2018.
 */
public class Create implements crudInterface {
    @Override
    public void execute(DeviceManager deviceManager) {
        deviceManager.create();
    }

    @Override
    public String getStringCommand() {
        return "create";
    }
}

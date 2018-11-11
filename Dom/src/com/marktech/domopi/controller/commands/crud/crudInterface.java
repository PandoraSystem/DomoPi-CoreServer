package com.marktech.domopi.controller.commands.crud;

import com.marktech.domopi.controller.devices.DeviceManager;

/**
 * Created by Marco on 10/11/2018.
 */
public interface crudInterface {
    void execute(DeviceManager deviceManager);
    String getStringCommand();
}

package com.marktech.domopi.controller.commands;

import com.marktech.domopi.controller.devices.InterfacciaDevice;

/**
 * Created by Marco on 10/11/2018.
 */
public interface CommandInterface {
    void execute(InterfacciaDevice device);
    String getStringCommand();
}

package com.marktech.domopi.controller.commands.device;

import com.marktech.domopi.controller.commands.CommandInterface;
import com.marktech.domopi.controller.devices.InterfacciaDevice;

/**
 * Created by Marco on 10/11/2018.
 */
public class CommandTogle implements CommandInterface {

    public CommandTogle() {
    }

    @Override
    public void execute(InterfacciaDevice device) {
        device.togle();
    }

    @Override
    public String getStringCommand() {
        return "togle";
    }
}

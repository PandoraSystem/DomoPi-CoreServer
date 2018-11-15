package com.marktech.domopi;

import com.marktech.domopi.controller.ControllerDomoPi;
import com.marktech.domopi.controller.devices.DeviceManager;
import com.marktech.domopi.controller.servertcp.ServerTcpConnection;

public class Main {

    public static void main(String[] args) {

        ControllerDomoPi.getGestione().startServer();


    }
}

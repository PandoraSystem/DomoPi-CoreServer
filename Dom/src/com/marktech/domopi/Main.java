package com.marktech.domopi;

import com.marktech.domopi.controller.ControllerDomoPi;
import com.marktech.domopi.controller.devices.DeviceManager;
import com.marktech.domopi.controller.servertcp.ServerTcpConnection;

public class Main {

    public static void main(String[] args) {

        DeviceManager deviceManager = new DeviceManager();
        ControllerDomoPi controller = new ControllerDomoPi(deviceManager);
        ServerTcpConnection server = new ServerTcpConnection(9000);
        server.setControllerObserver(controller);

        server.startServer();

    }
}

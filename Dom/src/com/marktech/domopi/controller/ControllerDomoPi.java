package com.marktech.domopi.controller;

import com.marktech.domopi.controller.devices.DeviceManager;
import com.marktech.domopi.controller.servertcp.ServerRequest;
import com.marktech.domopi.controller.servertcp.ServerTcpConnection;
import com.marktech.domotica.servertcp.Server;

import java.net.Socket;

public class ControllerDomoPi {

    private ServerTcpConnection server;
    private DeviceManager deviceManager;

    public ControllerDomoPi(DeviceManager deviceManager) {
        this.server = server;
        this.deviceManager = deviceManager;
    }

    public void request(Socket socket){

        new ServerRequest(socket);
    }


    // avvio il server

    // attendo il comando dal modulo Request

    // creo un oggetto DevicesManager

    // invio il comando all'intefaccia di comando -> che richiede il dispositivo da comandare getDevice(ID).execute()

    // Il dato che restituisco lo invio a Response

}

package com.marktech.domopi.controller;

import com.marktech.domopi.controller.devices.DeviceManager;
import com.marktech.domopi.controller.message.OperationList;
import com.marktech.domopi.controller.servertcp.ServerRequest;
import com.marktech.domopi.controller.servertcp.ServerTcpConnection;
import com.marktech.domotica.servertcp.Server;
import sun.net.www.http.HttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Proxy {

    private ServerTcpConnection server;
    private DeviceManager deviceManager;


    public Proxy(DeviceManager deviceManager) {
        this.server = server;
        this.deviceManager = deviceManager;
    }

    /**
     * Si incarica di decriptare il messaggio in arrivo e prepararlo per il gestore dei dispositivi
     * @param socket
     * @throws IOException
     */
    public void request(Socket socket) throws IOException {

        InputStreamReader inputStreamReader = new InputStreamReader(socket.getInputStream());
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        // splitto i comandi se ce ne sono più di uno e passo un array di stringhe comando
        OperationList operationList = new OperationList(bufferedReader.readLine());

        new ServerRequest(socket);
    }


    // avvio il server

    // attendo il Comando dal modulo Request

    // creo un oggetto DevicesManager

    // invio il Comando all'intefaccia di Comando -> che richiede il dispositivo da comandare getDevice(ID).execute()

    // Il dato che restituisco lo invio a Response

}

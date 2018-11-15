package com.marktech.domopi.controller.servertcp;

import java.net.Socket;

public class ServerResponse {

    private Socket clientSocket;

    public ServerResponse(Socket clientSocket){
        this.clientSocket = clientSocket;
    }
}

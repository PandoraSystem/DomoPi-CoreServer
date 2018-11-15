package com.marktech.domopi.controller;

import com.marktech.domopi.controller.commands.InvokerComando;
import com.marktech.domopi.controller.message.Messaggio;
import com.marktech.domopi.controller.servertcp.ServerTcpConnection;


public class ControllerDomoPi {

    private ServerTcpConnection server;
    private static ControllerDomoPi gestione;
    private boolean serverStatus = false;
    private InvokerComando invokerComando = null;



    private ControllerDomoPi() {
        invokerComando = new InvokerComando();

    }

    public static ControllerDomoPi getGestione(){
        if(gestione == null){gestione = new ControllerDomoPi();}
        return gestione;
    }

    public void startServer(){
        if(serverStatus == false) {
            server = new ServerTcpConnection(9000);
            server.startServer();
        }
    }

    public void startProceses(Messaggio messaggio){
        invokerComando.executeCommandMessage(messaggio.getCrude(),messaggio.getIperiferica());
    }






}

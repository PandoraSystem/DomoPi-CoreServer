package com.marktech.domopi.controller.servertcp;


import com.marktech.domopi.controller.ControllerDomoPi;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class ServerTcpConnection implements Runnable {


    private Thread threadServer;
    private ServerSocket serverSocket;
    private boolean socketStop, debug;
    private int port;
    public static int istanzeSocketAperte = 0;


    private ControllerDomoPi controllerObserver;

    /**
     * COSTRUTTORE *
     * Configuro il server con solo la porta *
     */

    public ServerTcpConnection(int porta) {
        this.port = porta;
        threadServer = new Thread(this,"Thread Server");
    }

    /************************************
     * PROPERTY GETTER AND SETTER
     *************************************/

    public boolean isSocketStop() {
        return socketStop;
    }

    public void setSocketStop(boolean socketStop) {
        this.socketStop = socketStop;
    }

    public void setControllerObserver(ControllerDomoPi controllerObserver) {
        this.controllerObserver = controllerObserver;
    }







    @Override
    public void run() {
        synchronized(this){

            openServerSocket();
        }


        // Controllo di flusso per lasciare il processo attivo. Unico modo per killare il processo
        while(!isSocketStop()){

            try {
                Socket clientSocket = null;
                clientSocket = this.serverSocket.accept();
                istanzeSocketAperte++;
                controllerObserver.request(clientSocket);

            } catch(IOException e) {
                e.printStackTrace();
            }


        }

    }



    public boolean startServer()
    {
        try {
            threadServer.start();
        } catch(Exception e) {
            e.printStackTrace();
            return false;
        }   return true;
    }

    public void stopServer()
    {
        setSocketStop(true);
    }

    /**
     *  Funzione openServerSocket  *
     *  Istanzia e Inizializza un oggetto ServerSocket con la porta necessaria scelta dal costruttore.
     */
    private void openServerSocket() {
        try {
            this.serverSocket = new ServerSocket(this.port);
        } catch (IOException e) {
            throw new RuntimeException("Cannot open port: " + Integer.toString(port), e);
        }
    }















}


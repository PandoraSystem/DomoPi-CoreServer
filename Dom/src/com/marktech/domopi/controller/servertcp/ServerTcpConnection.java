package com.marktech.domopi.controller.servertcp;

import com.marktech.domotica.servertcp.ElaboraRichieste;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class ServerTcpConnection implements Runnable {


    private Thread threadServer;
    private ServerSocket serverSocket;
    private boolean socketStop, debug;
    private int port;
    private Thread runningThread;

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






    @Override
    public void run() {

        openServerSocket();
        Socket clientSocket = null;
        // Controllo di flusso per lasciare il processo attivo. Unico modo per killare il processo
        while(!isSocketStop()){

            try {
                clientSocket = this.serverSocket.accept();


            } catch(IOException e) {
                e.printStackTrace();
            }


        }

    }



    public boolean StartServer()
    {
        try {
            threadServer.start();
        } catch(Exception e) {
            e.printStackTrace();
            return false;
        }   return true;
    }

    public void StopServer()
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


package com.marktech.domotica.servertcp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by PC-Fisso on 12/10/2018.
 */
public class Server implements Runnable {

    private Thread threadServer;
    private ServerSocket serverSocket;
    private boolean socketStop;
    private int port;
    private Thread runningThread;

    /**
     *
     * COSTRUTTORE
     *
     * Configuro il server con solo la porta
     *
     * @param porta
     */
    public Server(int porta) {
        this.port = porta;

    }

    /************************************
     *
     *
     * PROPERTY GETTER AND SETTER
     *
     *
     *************************************/

    public boolean isSocketStop() {
        return socketStop;
    }

    public void setSocketStop(boolean socketStop) {
        this.socketStop = socketStop;
    }

    public int getPorta() {
        return port;
    }

    public void setPorta(int porta) {
        this.port = porta;
    }




    @Override
    public void run() {
        synchronized(this) {
            this.runningThread = Thread.currentThread();
        }

            openServerSocket();
            Socket clientSocket = null;
            // Controllo di flusso per lasciare il processo attivo. Unico modo per killare il processo
        while(!isSocketStop()){

            try {
                clientSocket = this.serverSocket.accept();
            } catch(IOException e) {
                e.printStackTrace();
            }

            ElaboraRichieste er = new ElaboraRichieste(clientSocket);
            Thread readWriteProcess = new Thread(er);
            readWriteProcess.start();

            //attendi una connessione
            //ricava il messaggio in arrivo
            //rispondi al messaggio


        }

    }



    public boolean StartServer()
    {
        try {
            threadServer = new Thread(this,"ThreadServer");
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
     *  ## Funzione openServerSocket
     *
     *  Istanzia e Inizializza un oggetto ServerSocket con la porta necessaria scelta dal costruttore.
     *
     */
    private void openServerSocket() {
        try {
            this.serverSocket = new ServerSocket(this.port);
        } catch (IOException e) {
            throw new RuntimeException("Cannot open port: " + Integer.toString(port), e);
        }
    }












}

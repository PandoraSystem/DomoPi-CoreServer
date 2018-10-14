package com.marktech.domotica.servertcp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

/**
 * Created by Marco N. on 12/10/2018.
 *
 * Classe Server
 * Si attiva un server Tcp/Ip che accetta richieste e risponde
 * Elabora anche il tipo di rischieste ed esegue in base agli ordini
 *
 * +++++++++++++++++++++
 * Version 1.0
 *
 * +++++++++++++++++++++
 */
public class Server implements Runnable {

    private Thread threadServer;
    private ServerSocket serverSocket;
    private boolean socketStop, debug;
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

    public Server(int porta, boolean debug) {
        this.port = porta;
        this.debug = debug;
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

                // only debug mode on
                SocketInformation(clientSocket,debug);

            } catch(IOException e) {
                e.printStackTrace();
            }

            // Inizio a gestire le richieste del socket, creo un nuovo oggetto e gli do in pasto il processo
            // che non deve finire fin tanto che gli dico di smettere.
            ElaboraRichieste er = new ElaboraRichieste(clientSocket,true);
            Thread readWriteProcess = new Thread(er);
            readWriteProcess.start();


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


    /**
     *
     * SocketInformation serve solo per debug.
     * Restituisce i valori del socket.
     *
     * @param socket
     * @param debug
     */
    private void SocketInformation(Socket socket,boolean debug)
    {
        if(debug){

            try {
                System.out.println("LocalAddress " + socket.getLocalAddress());
                System.out.println("LocalPort " + socket.getLocalPort());
                System.out.println("Channel " + socket.getChannel());
                System.out.println("ReceiveBufferSize " + socket.getReceiveBufferSize());
                System.out.println("KeepAlive " + socket.getKeepAlive());
                System.out.println("OOBInline " + socket.getOOBInline());
                System.out.println("RemoteSocketAddress " + socket.getRemoteSocketAddress());
                System.out.println("ReuseAddress " + socket.getReuseAddress());
                System.out.println("SendBufferSize " + socket.getSendBufferSize());
                System.out.println("SoTimeout " + socket.getSoTimeout());
                System.out.println("TcpNoDelay " + socket.getTcpNoDelay());
                System.out.println("TrafficClass " + socket.getTrafficClass());
            } catch(SocketException e) {
                e.printStackTrace();
            }
        }
    }












}

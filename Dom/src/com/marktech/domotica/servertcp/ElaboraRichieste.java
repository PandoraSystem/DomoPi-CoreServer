package com.marktech.domotica.servertcp;

import java.io.*;
import java.net.Socket;

/**
 *
 * ElaboraRichieste
 *
 * Necessario per gestire le richieste in arrivo e per un futuro controllo delle chiavi ricevute/inviate
 *
 *
 */
public class ElaboraRichieste implements Runnable{
    private Socket clientSocket;
    private InputStreamReader inputStreamReader;
    private BufferedReader bufferedReader;
    private PrintWriter printWriter;
    private OutputStreamWriter outputStreamWriter;
    private boolean socketConnect;
    private boolean telnet;


    /***************************************************************
     *
     *
     * Getter and Setter location
     *
     *
     ***************************************************************/
    public Socket getClientSocket() {
        return clientSocket;
    }

    public boolean isSocketConnect() {
        return socketConnect;
    }

    public void setSocketConnect(boolean socketConnect) {
        this.socketConnect = socketConnect;
    }

    /***************************************************************
     *
     *
     * Constructors location
     *
     *
     ***************************************************************/


    /**
     *
     * Costruttore base
     *
     * @param clientSocket
     * Is socket to work
     */
    public ElaboraRichieste(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    /**
     *
     * Constructor with telnet tests
     *
     * @param clientSocket
     * @param telnet
     *
     * Select telnet = true if you want tests with telnet
     */
    public ElaboraRichieste(Socket clientSocket, boolean telnet) {
        this.clientSocket = clientSocket;
        this.telnet = telnet;
    }

    /***************************************************************
     *
     *
     * Thread elaboration
     *
     *
     ***************************************************************/
    @Override
    public void run() {

        String message = null;
        setSocketConnect(clientSocket.isConnected());

        if(isSocketConnect()){
            // inizializzo gli oggetti
            try {
                inputStreamReader = new InputStreamReader(clientSocket.getInputStream());
                bufferedReader = new BufferedReader(inputStreamReader);
                printWriter = new PrintWriter(clientSocket.getOutputStream());

                // resta in ascolto
                while(isSocketConnect())
                {
                    // Reading
                    message = bufferedReader.readLine();
                    System.out.println(message);
                    // Writing
                    printWriter.write("msg rx: " + message);                                                         // restituisco il messaggio
                    if(telnet){printWriter.println("");}                                                                // nuova riga per leggere correttamente dal Telnet
                    printWriter.flush();
                }

                inputStreamReader.close();
                bufferedReader.close();
                printWriter.close();


            } catch(IOException e) {
                e.printStackTrace();
            }

        }


    }
}

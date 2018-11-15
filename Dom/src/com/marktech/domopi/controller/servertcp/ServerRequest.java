package com.marktech.domopi.controller.servertcp;

import com.marktech.domotica.devicemanager.InvocaComando;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 *
 * ServerRequest
 *
 * Necessario per gestire le richieste in arrivo e per un futuro controllo delle chiavi ricevute/inviate
 *
 * +++++++++++++++++++++
 * Version 1.3
 *
 * +++++++++++++++++++++
 *
 *
 */
public class ServerRequest implements Runnable{
    private Socket clientSocket;
    private InputStreamReader inputStreamReader;
    private BufferedReader bufferedReader;



    /***************************************************************
     * Getter and Setter location *
     ***************************************************************/
    public Socket getClientSocket() {
        return clientSocket;
    }


    /***************************************************************
     * Constructors location
     ***************************************************************
     * Costruttore base *
     * @param clientSocket
     * Is socket to work
     */
    public ServerRequest(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }


    /***************************************************************
     * Thread elaboration *
     ***************************************************************/
    @Override
    public void run() {

        String message = null;


        if(!clientSocket.isClosed()){
            // inizializzo gli oggetti


            try {
                inputStreamReader = new InputStreamReader(clientSocket.getInputStream());
                bufferedReader = new BufferedReader(inputStreamReader);


                // resta in ascolto
                while(!clientSocket.isClosed())
                {
                    // Reading
                    message = bufferedReader.readLine();
                    System.out.println(message);

                    // Elaboration
                    InvocaComando invocaComando = new InvocaComando();
                    String messageRx = invocaComando.execute(message);

                }

                inputStreamReader.close();
                bufferedReader.close();


            } catch(IOException e) {
                e.printStackTrace();
            }

        }


    }
}

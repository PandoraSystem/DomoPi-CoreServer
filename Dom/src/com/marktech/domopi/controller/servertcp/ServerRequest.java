package com.marktech.domopi.controller.servertcp;

import com.marktech.domopi.controller.ControllerDomoPi;
import com.marktech.domopi.controller.debug.Debug;
import com.marktech.domopi.controller.message.Messaggio;

import java.io.*;
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


            try (
                 ObjectInputStream objectInputStream = new ObjectInputStream(clientSocket.getInputStream())
                )

                {
                // resta in ascolto
                while(!clientSocket.isClosed())
                {
                    Debug.getIstanza().myDebug("[ServerRequest] Deserializzo il messaggio");

                    // per ogni oggetto che mi ritorna controllo che non sia null
                    while(objectInputStream.readObject() != null){
                        Messaggio messaggio = (Messaggio) objectInputStream.readObject();
                        ControllerDomoPi.getGestione().startProceses(messaggio);
                        Debug.getIstanza().myDebug("[ServerRequest] Invio a processo di elaborazione messaggio");
                    }

                }


            } catch(IOException e) {
                e.printStackTrace();
                Debug.getIstanza().myDebug(e.toString());
            } catch(ClassNotFoundException e) {
                e.printStackTrace();
                Debug.getIstanza().myDebug(e.toString());
            }

        }


    }
}

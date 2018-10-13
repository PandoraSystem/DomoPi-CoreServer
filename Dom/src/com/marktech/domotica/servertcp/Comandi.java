package com.marktech.domotica.servertcp;

import com.sun.org.apache.bcel.internal.generic.Select;

import java.io.IOException;
import java.net.Socket;

/**
 * Created by Marco on 13/10/2018.
 *
 * Questa classe ha il compito di comprendere il comandi e rispondere di conseguenza
 *
 * +++++++++++++++++++++
 * Version 1.0
 *
 * +++++++++++++++++++++
 *
 */
public class Comandi {
    private String comando;
    private Socket clientSocket;

    public String getComando() {
        return comando;
    }

    public void setComando(String comando) {
        this.comando = comando;
    }

    public Socket getClientSocket() {
        return clientSocket;
    }

    public void setClientSocket(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    public Comandi() {
    }

    public Comandi(Socket clientSocket)
    {
        this.clientSocket = clientSocket;
    }



    public String ControlloComandi(String comando) throws IOException {
        setComando(comando);
        String messaggioDiRitorno = "comando sconosciuto";

        switch(comando) {
            case "close":  clientSocket.close(); messaggioDiRitorno = "Chiusura del socket in corso";
                break;
            case "accendi": messaggioDiRitorno = AccensioneLuce();
                break;

        }

        return messaggioDiRitorno;
    }

        private String AccensioneLuce(){
            String risposta = "Sto accendendo la luce";
            System.out.println(risposta);
            System.out.println("");
            return risposta;
    }

}

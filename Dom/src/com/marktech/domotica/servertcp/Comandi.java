package com.marktech.domotica.servertcp;

import java.io.IOException;
import java.net.Socket;
import com.marktech.domotica.raspberry.*;

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
    private Test test = new Test();

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
            case "spegni" : messaggioDiRitorno = SpegniLuce();
            break;
            case "help" : messaggioDiRitorno = "I comandi sono: accendi, close.";
            break;


        }

        return messaggioDiRitorno;
    }

    private String SpegniLuce() {
        String risposta = "Accensione riuscita";

        try {
            test.spegni();

        } catch(Exception e) {
            e.printStackTrace();

            return risposta = "accensione fallita";
        }

        System.out.println(risposta);
        System.out.println("");
        return risposta;

    }

    private String AccensioneLuce(){

            String risposta = "Accensione riuscita";

            try {
                test.accendi();

            } catch(Exception e) {
                e.printStackTrace();

                return risposta = "accensione fallita";
            }

            System.out.println(risposta);
            System.out.println("");
            return risposta;


    }

}

package com.marktech.domopi.controller.message;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class OperationList {
    private String stringheComando[];
    private ArrayList<Messaggio> messaggi = new ArrayList<>();

    public OperationList(String operations)
    {
        stringheComando = operations.split(":");
        for(String s:stringheComando)
        {
           String cmd[] =  s.split(Pattern.quote("."));
           Messaggio messaggio = new Messaggio(cmd[2],cmd[0],cmd[1],cmd[3]);
           messaggi.add(messaggio);
        }
    }

    public ArrayList<Messaggio> getMessaggi() {
        return messaggi;
    }
}

package com.marktech.domopi.controller.commands;

import com.marktech.domopi.controller.interfaccia.Interfaccia;
import com.marktech.domopi.controller.periferiche.Iperiferica;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Marco on 15/11/2018.
 */
public class InvokerComando {

    private Map<String,Comando> comandi;

    public InvokerComando(){
        this.comandi = new HashMap<>();
        caricamentoComandi();
    }


    private void caricamentoComandi(){
        ComandoAdd cmdAdd = new ComandoAdd();
        ComandoDelete cmdDel = new ComandoDelete();
        ComandoExecute cmdExe = new ComandoExecute();
        ComandoRead cmdRed = new ComandoRead();
        ComandoUpdate cmdUpd = new ComandoUpdate();

        comandi.put(cmdAdd.getCommand(),cmdAdd);
        comandi.put(cmdDel.getCommand(),cmdDel);
        comandi.put(cmdExe.getCommand(),cmdExe);
        comandi.put(cmdRed.getCommand(),cmdRed);
        comandi.put(cmdUpd.getCommand(),cmdUpd);
    }

    public void executeCommandMessage(String crude, Iperiferica iperiferica){
        comandi.get(crude).execute(iperiferica);
    }
}

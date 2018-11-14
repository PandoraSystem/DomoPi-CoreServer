package com.marktech.domopi.controller.devices;

import com.marktech.domopi.controller.commands.Comando;
import com.marktech.domopi.controller.commands.ComandoAdd;
import com.marktech.domopi.controller.message.Messaggio;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * InterfacciaDevice Manager
 *  *
 * Pattern: Command
 * Carico tutti i comandi e le loro associazioni Stringa-valore attraverso al metodo caricaAssociazioniComandi
 * I comandi mi servono per impartire gli ordini.
 * Esistono due tipi di comandi, i comandi per dispositivi e i comandi per il crud.
 * CRUD_COMMAND:I comandi per il crud servono per gestire i dispositivi
 * DEVICE_COMMAND:Sono i comandi per pilotare dispositivi già esistenti
 *
 *
 */
public class DeviceManager {

    List<Comando> comandi = new ArrayList<>();
    List<Dispositivo> dispositivi = new ArrayList<>();
    Map<String,Comando> avaibleCommands = new HashMap<>();

    public DeviceManager(){

        ComandoAdd cc = new ComandoAdd();

        comandi.add(cc);


        caricaAssociazioniComandi();
    }

    // Carico le associazioni Map Stringa-Comando
    private void caricaAssociazioniComandi(){

        for(Comando cmd: comandi){
            avaibleCommands.put(cmd.getCommand(),cmd);
        }

    }




    public void elaboration(ArrayList<Messaggio> messaggi){
        for(Messaggio msg:messaggi ){

            avaibleCommands.get(msg.getComandoTipo()).execute(msg,dispositivi);


        }
    }


}

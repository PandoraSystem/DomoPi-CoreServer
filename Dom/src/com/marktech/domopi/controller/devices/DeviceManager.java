package com.marktech.domopi.controller.devices;

import com.marktech.domopi.controller.commands.CommandInterface;
import com.marktech.domopi.controller.commands.crud.crudInterface;
import com.marktech.domopi.controller.commands.device.CommandTogle;

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

    private Map<String,CommandInterface> comandi;
    private Map<String,crudInterface> crud;
    private List<CommandInterface> deviceCommand;
    private List<crudInterface> crudCommand;
    private List<InterfacciaDevice> listaDispositivi;

    public DeviceManager(){
        deviceCommand.add(new CommandTogle());

        //crudCommand.add(new )

        caricaAssociazioniComandi();
    }

    // Carico le associazioni Map Stringa-Comando
    private void caricaAssociazioniComandi(){

        try {
            for(crudInterface c: crudCommand ){
                crud.put(c.getStringCommand(),c);
            }

            for(CommandInterface c: deviceCommand ){
                comandi.put(c.getStringCommand(),c);
            }
        } catch(Exception e) {
            e.printStackTrace();
            System.out.println("Caricamento associazioni fallito");
        }
    }


    public void create() {
    }
}

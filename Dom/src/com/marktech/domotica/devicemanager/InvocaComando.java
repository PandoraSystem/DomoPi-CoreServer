package com.marktech.domotica.devicemanager;

import com.marktech.domotica.devicemanager.comandi.*;
import com.marktech.domotica.devicemanager.devices.DispositivoLuce;
import com.marktech.domotica.devicemanager.devices.DispositivoMacchinaCaffe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  INVOKER
 */
public class InvocaComando {


    Map<String, Imessaggi> avaibleMessage = new HashMap<String,Imessaggi>();
    List<Imessaggi> listaMessaggi = new ArrayList<Imessaggi>();

    DispositivoLuce dispositivoLuce = new DispositivoLuce();
    DispositivoMacchinaCaffe macchinaCaffe = new DispositivoMacchinaCaffe();



    public InvocaComando() {

        // Comandi Luce
        listaMessaggi.add(new ComandoLuceOff(dispositivoLuce));
        listaMessaggi.add(new ComandoLuceOn(dispositivoLuce));

        // Comandi caffè
        listaMessaggi.add(new ComandoAccendiMacchinaCaffe(macchinaCaffe));
        listaMessaggi.add(new ComandoSpegniMacchinaCaffe(macchinaCaffe));
        listaMessaggi.add(new ComandoFaiCaffe(macchinaCaffe));

        PrecaricaComandi();
    }

    private void PrecaricaComandi(){
        for(Imessaggi m: listaMessaggi  ) {
            avaibleMessage.put(m.GetAvaibleCommand(),m);
        }
    }

    public String execute(String incommingMessage){

        try {
            String messaggioRx;
            messaggioRx = avaibleMessage.get(incommingMessage).execute();

            // Ripuliso la memoria dagli oggetti

            return messaggioRx;
        } catch (Exception e) {
            e.printStackTrace();
            return "Comando errato";
        }
    }


}

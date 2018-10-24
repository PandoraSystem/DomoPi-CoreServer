package com.marktech.domotica.devicemanager.comandi;

import com.marktech.domotica.devicemanager.devices.DispositivoMacchinaCaffe;
import com.marktech.domotica.devicemanager.Imessaggi;

public class ComandoSpegniMacchinaCaffe implements Imessaggi {
    private DispositivoMacchinaCaffe dispositivoMacchinaCaffe;

    public ComandoSpegniMacchinaCaffe(DispositivoMacchinaCaffe dispositivoMacchinaCaffe){
        this.dispositivoMacchinaCaffe = dispositivoMacchinaCaffe;
    }


    @Override
    public String execute() {
        return dispositivoMacchinaCaffe.SpegniMacchina();
    }

    @Override
    public String GetAvaibleCommand() {
        return "mcaffe.spegni";
    }
}

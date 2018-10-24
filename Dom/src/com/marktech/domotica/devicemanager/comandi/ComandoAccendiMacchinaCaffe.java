package com.marktech.domotica.devicemanager.comandi;

import com.marktech.domotica.devicemanager.devices.DispositivoMacchinaCaffe;
import com.marktech.domotica.devicemanager.Imessaggi;

public class ComandoAccendiMacchinaCaffe implements Imessaggi {

    private DispositivoMacchinaCaffe dispositivoMacchinaCaffe;

    public ComandoAccendiMacchinaCaffe(DispositivoMacchinaCaffe dispositivoMacchinaCaffe){
        this.dispositivoMacchinaCaffe = dispositivoMacchinaCaffe;
    }

    @Override
    public String execute() {
        return this.dispositivoMacchinaCaffe.AccendiMacchina();
    }

    @Override
    public String GetAvaibleCommand() {
        return "mcaffe.accendi";
    }
}

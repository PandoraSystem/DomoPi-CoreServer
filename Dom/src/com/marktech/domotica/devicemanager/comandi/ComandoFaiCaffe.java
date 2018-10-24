package com.marktech.domotica.devicemanager.comandi;

import com.marktech.domotica.devicemanager.devices.DispositivoMacchinaCaffe;
import com.marktech.domotica.devicemanager.Imessaggi;

public class ComandoFaiCaffe implements Imessaggi {
    private DispositivoMacchinaCaffe dispositivoMacchinaCaffe;

    public ComandoFaiCaffe(DispositivoMacchinaCaffe dispositivoMacchinaCaffe){
        this.dispositivoMacchinaCaffe = dispositivoMacchinaCaffe;
    }

    @Override
    public String execute() {
        return dispositivoMacchinaCaffe.FaiCaffe();
    }

    @Override
    public String GetAvaibleCommand() {
        return "mcaffe.faicaffe";
    }
}

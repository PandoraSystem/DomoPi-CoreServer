package com.marktech.domotica.devicemanager.devices;

public class DispositivoMacchinaCaffe extends Generaldevice {
    private boolean status = false;

    public DispositivoMacchinaCaffe(){

    }

    public String AccendiMacchina(){
        this.status = true;
        return "Accendo la macchina del caffè";
    }

    public String SpegniMacchina(){
        this.status = false;
        return "Sto spegnendo la macchina del caffè";
    }

    public String FaiCaffe(){
        return "Sto facendo il caffè";
    }


}

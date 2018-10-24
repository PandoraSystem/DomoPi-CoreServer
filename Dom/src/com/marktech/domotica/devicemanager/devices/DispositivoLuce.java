package com.marktech.domotica.devicemanager.devices;

/**
 * RECEIVER
 */
public class DispositivoLuce extends Generaldevice {
    private boolean statoLuce;

    public DispositivoLuce() {}

    public String LuceAccesa(){
        this.statoLuce = true;
        return "Luce accesa";
    }

    public String LuceSpenta(){
        this.statoLuce = false;
        return "Luce spenta";
    }
}

package com.marktech.domotica.devicemanager.comandi;

import com.marktech.domotica.devicemanager.devices.DispositivoLuce;
import com.marktech.domotica.devicemanager.Imessaggi;

/**
 * CONCRETE COMMAND
 */
public class ComandoLuceOff implements Imessaggi {

    private DispositivoLuce luce;

    public ComandoLuceOff(DispositivoLuce luce) {
        this.luce = luce;
    }

    @Override
    public String execute() {
        try {
            return luce.LuceSpenta();
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String GetAvaibleCommand() {
        return "luce.spegni";
    }
}

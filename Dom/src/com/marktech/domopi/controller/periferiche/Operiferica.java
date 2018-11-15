package com.marktech.domopi.controller.periferiche;

import com.marktech.domopi.controller.periferiche.provisioning.MappaPin;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.PinState;

import java.io.Serializable;

public class Operiferica implements Serializable {
    private String pin;
    private String id;
    private String idGruppo;
    private transient GpioPinDigitalOutput provisionedPin = null;
    private boolean isProvisioned;

    public Operiferica(String pin, String id, String idGruppo) {
        this.pin = pin;
        this.id = id;
        this.idGruppo = idGruppo;
        this.isProvisioned = false;
        provisioning();
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdGruppo() {
        return idGruppo;
    }

    public void setIdGruppo(String idGruppo) {
        this.idGruppo = idGruppo;
    }

    public GpioPinDigitalOutput getProvisionedPin() {
        if(!isProvisioned) {provisioning();}
        return provisionedPin;
    }

    public void provisioning(){
        try {
            MappaPin mappa = new MappaPin();
            Pin thePin = mappa.getMappaGpio().get(getPin());
            String nomePin = getPin();

            if(!isProvisioned){
                this.provisionedPin = GpioFactory.getInstance().provisionDigitalOutputPin(thePin,nomePin, PinState.LOW);
                isProvisioned = true;
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void deProvisioning(){
        if(isProvisioned){
            GpioFactory.getInstance().unprovisionPin(provisionedPin);
        }

    }


}

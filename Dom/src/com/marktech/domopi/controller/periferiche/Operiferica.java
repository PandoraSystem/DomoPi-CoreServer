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

    public Operiferica(String pin, String id, String idGruppo) {
        this.pin = pin;
        this.id = id;
        this.idGruppo = idGruppo;
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
        return provisionedPin;
    }

    public void provisioning(){
        MappaPin mappa = new MappaPin();
        Pin pin = mappa.getMappaGpio().get(getPin());
        String nomePin = getPin();
        try {
            this.provisionedPin = GpioFactory.getInstance().provisionDigitalOutputPin(pin,nomePin, PinState.LOW);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}

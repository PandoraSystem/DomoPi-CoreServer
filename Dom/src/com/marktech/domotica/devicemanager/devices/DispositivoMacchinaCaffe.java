package com.marktech.domotica.devicemanager.devices;

import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;

public class DispositivoMacchinaCaffe extends Generaldevice {
    private GpioPinDigitalOutput myPinPower;
    private GpioPinDigitalOutput myPinAction;
    private String nomeDevice = "luceA";

    public DispositivoMacchinaCaffe(){
        LoadToDb();
    }

    public String AccendiMacchina(){
        myPinPower.high();
        return "Accendo la macchina del caffè";
    }

    public String SpegniMacchina(){
        myPinPower.low();
        return "Sto spegnendo la macchina del caffè";
    }

    public String FaiCaffe(){
        return "Sto facendo il caffè";
    }

    private void LoadToDb(){
        this.myPinPower = GpioFactory.getInstance().provisionDigitalOutputPin(RaspiPin.GPIO_01,nomeDevice, PinState.LOW);
        this.myPinAction = GpioFactory.getInstance().provisionDigitalOutputPin(RaspiPin.GPIO_02,nomeDevice, PinState.LOW);
    }


}

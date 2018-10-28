package com.marktech.domotica.devicemanager.devices;

import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;

public class DispositivoMacchinaCaffe extends Generaldevice {
    private GpioPinDigitalOutput myPinPower;
    private GpioPinDigitalOutput myPinAction;
    private String nomeDevice = "mCaffePower"; String nomeAction = "mCaffeAct";

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

        if(GpioFactory.getInstance().getProvisionedPin(RaspiPin.GPIO_02) == null){
            this.myPinAction = GpioFactory.getInstance().provisionDigitalOutputPin(RaspiPin.GPIO_02,nomeAction, PinState.LOW);
        }
        if(GpioFactory.getInstance().getProvisionedPin(RaspiPin.GPIO_03) == null){
            this.myPinAction = GpioFactory.getInstance().provisionDigitalOutputPin(RaspiPin.GPIO_03,nomeAction, PinState.LOW);
        }

    }


}

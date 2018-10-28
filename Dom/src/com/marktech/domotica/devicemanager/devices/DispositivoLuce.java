package com.marktech.domotica.devicemanager.devices;

import com.pi4j.io.gpio.*;

/**
 * RECEIVER
 */
public class   DispositivoLuce extends Generaldevice {

    private GpioPinDigitalOutput myPin;
    private String nomeDevice = "luceA";

    public DispositivoLuce() {
        LoadDb();
    }

    public String LuceAccesa(){
        // Attiva il pin
        myPin.high();
        return "Luce accesa";
    }

    public String LuceSpenta(){
        // Disattiva il pin
        myPin.low();
        return "Luce spenta";
    }

    public void LoadDb(){

        GpioController myControl = GpioFactory.getInstance();

        Pin mioPin = RaspiPin.GPIO_01;

        System.out.println(myControl.getProvisionedPin(mioPin));

        if(myControl.getProvisionedPin(mioPin) == null){
            this.myPin = GpioFactory.getInstance().provisionDigitalOutputPin(RaspiPin.GPIO_01,nomeDevice, PinState.LOW);
        }


    }


}

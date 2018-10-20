package com.marktech.domotica.raspberry;

import com.pi4j.io.gpio.*;

/**
 * Created by PC-Fisso on 20/10/2018.
 */
public class Test {

    // create gpio controller instance
    final GpioController gpio;
    GpioPinDigitalOutput pinUno;


    public Test(){
        gpio = GpioFactory.getInstance();
        pinUno = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01,"a", PinState.LOW);
    }

    public void accendi(){
        pinUno.high();// = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01,"a", PinState.HIGH);
    }

    public void spegni(){
        pinUno.low();// = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01,"a", PinState.LOW);
    }
}

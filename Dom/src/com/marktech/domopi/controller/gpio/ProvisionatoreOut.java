package com.marktech.domopi.controller.gpio;

import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.RaspiPin;

/**
 * Created by Marco on 11/11/2018.
 */
public class ProvisionatoreOut {

    public ProvisionatoreOut(int pinAddress,String nome){
        GpioFactory.getInstance().provisionAnalogOutputPin(RaspiPin.getPinByAddress(pinAddress),nome);
    }
}

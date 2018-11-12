package com.marktech.domopi.controller.gpio;

import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;

/**
 * Created by Marco on 11/11/2018.
 */
public class GpioToglePin {
    public GpioToglePin(String pin) {
        GpioPinDigitalOutput myPin = (GpioPinDigitalOutput) GpioFactory.getInstance().getProvisionedPin(pin);
        myPin.toggle();

    }


}

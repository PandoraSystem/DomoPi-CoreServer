package com.marktech.domopi.controller.periferiche.provisioning;

import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.RaspiPin;

import java.util.HashMap;
import java.util.Map;

public class MappaPin {
    Map<String, Pin> mappaGpio;

    public MappaPin() {
        mappaGpio = new HashMap<>();

        mappaGpio.put("GPIO_00", RaspiPin.GPIO_00);
        mappaGpio.put("GPIO_01", RaspiPin.GPIO_01);
        mappaGpio.put("GPIO_02", RaspiPin.GPIO_02);
        mappaGpio.put("GPIO_03", RaspiPin.GPIO_03);
        mappaGpio.put("GPIO_04", RaspiPin.GPIO_04);
        mappaGpio.put("GPIO_05", RaspiPin.GPIO_05);
        mappaGpio.put("GPIO_06", RaspiPin.GPIO_06);
        mappaGpio.put("GPIO_07", RaspiPin.GPIO_07);
        mappaGpio.put("GPIO_08", RaspiPin.GPIO_08);
        mappaGpio.put("GPIO_09", RaspiPin.GPIO_09);
        mappaGpio.put("GPIO_10", RaspiPin.GPIO_10);
        mappaGpio.put("GPIO_11", RaspiPin.GPIO_11);
        mappaGpio.put("GPIO_12", RaspiPin.GPIO_12);
        mappaGpio.put("GPIO_13", RaspiPin.GPIO_13);
        mappaGpio.put("GPIO_14", RaspiPin.GPIO_14);
        mappaGpio.put("GPIO_15", RaspiPin.GPIO_15);
        mappaGpio.put("GPIO_16", RaspiPin.GPIO_16);
        mappaGpio.put("GPIO_17", RaspiPin.GPIO_17);
        mappaGpio.put("GPIO_18", RaspiPin.GPIO_18);
        mappaGpio.put("GPIO_19", RaspiPin.GPIO_19);
        mappaGpio.put("GPIO_20", RaspiPin.GPIO_20);
    }

    public Map<String, Pin> getMappaGpio() {
        return mappaGpio;
    }
}

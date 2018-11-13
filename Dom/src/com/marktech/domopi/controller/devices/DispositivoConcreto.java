package com.marktech.domopi.controller.devices;

import com.marktech.domopi.controller.gpio.GpioToglePin;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.RaspiPin;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marco on 11/11/2018.
 */
public class DispositivoConcreto implements Dispositivo {
    private String id;
    private String nome;
    private List<String> IO = new ArrayList<>();

    public DispositivoConcreto(String id){
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void addPin(String pin){IO.add(pin);}

    public void togle(String pin){
        new GpioToglePin(pin);
    }


}

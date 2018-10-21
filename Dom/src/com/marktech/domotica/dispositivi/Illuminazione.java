package com.marktech.domotica.dispositivi;


import com.pi4j.io.gpio.GpioPin;
import com.pi4j.io.gpio.RaspiPin;

/**
 *
 * Created by Marco N. 21.10.2018
 *
 */
public class Illuminazione extends Dispositivi {



    private int id;
    private String name;
    private boolean statusLight;
    private RaspiPin gpdo;


    /***
     *
     *
     *  #### Getter and Setter ####
     *
     */

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isStatusLight() {
        return statusLight;
    }

    public void setStatusLight(boolean statusLight) {
        this.statusLight = statusLight;
    }

    public int getId() {
        return id;
    }

    public RaspiPin getGpdo() {
        return gpdo;
    }

    public void setGpdo(RaspiPin gpdo) {
        this.gpdo = gpdo;
    }









    /**
     * Default constructor
     */
    public Illuminazione(int id) {
        super(id);
    }


    /**
     * @param id
     */
    public void Illuminazione(int id) {
        // TODO implement here
    }

    /**
     * @param id 
     * @param name
     */
    public Illuminazione(int id, String name) {
        super(id);

    }




}
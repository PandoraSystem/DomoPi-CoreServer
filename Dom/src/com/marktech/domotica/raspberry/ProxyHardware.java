package com.marktech.domotica.raspberry;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;

/**
 * Created by Marco N. - 21.10.2018.
 *
 * Questa classe si occupa di gestire le chiamate hardware dai dispositivi e di riempire le richieste.
 */
public class ProxyHardware {

    final GpioController gpio;




    private GpioPinDigitalOutput interfaceOutput;



    /***
     *
     *
     * #### Getter and Setter ####
     *
     *
     */



    /***
     *
     *
     * Costructors
     *
     *
     */
    public ProxyHardware(){
        this.gpio = GpioFactory.getInstance();
    }



    /***
     * #### Methods ####
     */

    public void setInterfaceOutput(GpioPinDigitalOutput interfaceOutput) {
        this.interfaceOutput = interfaceOutput;
    }








    // preparo le funzioni di controllo degli oggetti

    // eseguo operazioni sulle uscite designate

    // funzione libera risorse uscita non più necessaria
}

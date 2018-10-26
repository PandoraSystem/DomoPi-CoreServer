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
    private GpioPinDigitalOutput uscita_0;
    private GpioPinDigitalOutput uscita_1;
    private GpioPinDigitalOutput uscita_2;
    private GpioPinDigitalOutput uscita_3;
    private GpioPinDigitalOutput uscita_4;



    private GpioPinDigitalOutput interfaceOutput;



    /***
     *
     *
     * #### Getter and Setter ####
     *
     *
     */
    public GpioPinDigitalOutput getUscita_0() {
        return uscita_0;
    }

    public void setUscita_0(GpioPinDigitalOutput uscita_0) {
        this.uscita_0 = uscita_0;
    }

    public GpioPinDigitalOutput getUscita_1() {
        return uscita_1;
    }

    public void setUscita_1(GpioPinDigitalOutput uscita_1) {
        this.uscita_1 = uscita_1;
    }

    public GpioPinDigitalOutput getUscita_2() {
        return uscita_2;
    }

    public void setUscita_2(GpioPinDigitalOutput uscita_2) {
        this.uscita_2 = uscita_2;
    }

    public GpioPinDigitalOutput getUscita_3() {
        return uscita_3;
    }

    public void setUscita_3(GpioPinDigitalOutput uscita_3) {
        this.uscita_3 = uscita_3;
    }

    public GpioPinDigitalOutput getUscita_4() {
        return uscita_4;
    }

    public void setUscita_4(GpioPinDigitalOutput uscita_4) {
        this.uscita_4 = uscita_4;
    }


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

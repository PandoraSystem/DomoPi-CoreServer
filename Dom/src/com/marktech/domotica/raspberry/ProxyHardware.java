package com.marktech.domotica.raspberry;

import com.marktech.domotica.gpiodevice.Controller;
import com.marktech.domotica.gpiodevice.device.DispositivoGpio;
import com.pi4j.io.gpio.*;
import org.jdom.JDOMException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * Created by Marco N. - 21.10.2018.
 *
 * Questa classe si occupa di gestire le chiamate hardware dai dispositivi e di riempire le richieste.
 */
public class ProxyHardware {

    final GpioController gpio;
    private Controller gpioController;
    private List<DispositivoGpio> dispositivoGpiosLista = new ArrayList<>();





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
        LoadPeriferiche();

    }



    /***
     * #### Methods ####
     */

    public void setInterfaceOutput(GpioPinDigitalOutput interfaceOutput) {
        this.interfaceOutput = interfaceOutput;
    }

    private void SetUp(){
        for(DispositivoGpio d: dispositivoGpiosLista){

            // provisioning Output
            if(d.getVersoPin() == "outperiferiche"){
                GpioFactory.getInstance().provisionDigitalOutputPin(RaspiPin.getPinByAddress(d.getAddress()), String.valueOf(d.getId()), PinState.LOW);
            }
            // provisioning Input
            if(d.getVersoPin() == "in"){
                GpioFactory.getInstance().provisionDigitalInputPin(RaspiPin.getPinByAddress(d.getAddress()), String.valueOf(d.getId()),PinPullResistance.PULL_DOWN);
            }
        }
    }

    private void LoadPeriferiche(){
        try {
            gpioController = new Controller();
        } catch(JDOMException e) {
            e.printStackTrace();
        } catch(IOException e) {
            e.printStackTrace();
        }

        dispositivoGpiosLista = gpioController.getListaGPIO();
    }









    // preparo le funzioni di controllo degli oggetti

    // eseguo operazioni sulle uscite designate

    // funzione libera risorse uscita non più necessaria
}

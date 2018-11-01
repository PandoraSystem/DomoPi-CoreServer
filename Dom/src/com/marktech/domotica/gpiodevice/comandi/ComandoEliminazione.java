package com.marktech.domotica.gpiodevice.comandi;


import com.marktech.domotica.gpiodevice.Comando;
import com.marktech.domotica.gpiodevice.device.DispositivoGpio;
import org.jdom.JDOMException;

import java.io.IOException;

/**
 * Created by PC-Fisso on 01/11/2018.
 */
public class ComandoEliminazione implements Comando {
    private DispositivoGpio dispositivoGpio;

    public ComandoEliminazione(DispositivoGpio dispositivoGpio) {
        this.dispositivoGpio = dispositivoGpio;


    }

    @Override
    public void execute() {
        try {
            dispositivoGpio.RemoveToConfiguration();
        } catch(JDOMException e) {
            e.printStackTrace();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}

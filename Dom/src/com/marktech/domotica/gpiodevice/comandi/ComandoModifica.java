package com.marktech.domotica.gpiodevice.comandi;


import com.marktech.domotica.gpiodevice.Comando;
import com.marktech.domotica.gpiodevice.device.DispositivoGpio;
import org.jdom.JDOMException;

import java.io.IOException;

/**
 * Created by PC-Fisso on 01/11/2018.
 */
public class ComandoModifica implements Comando {
    private DispositivoGpio dispositivoGpio;

    public ComandoModifica(DispositivoGpio dispositivoGpio) {
        this.dispositivoGpio = dispositivoGpio;
    }

    @Override
    public void execute() {
        try {
            dispositivoGpio.ModifyConfiguration();
        } catch(JDOMException e) {
            e.printStackTrace();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}

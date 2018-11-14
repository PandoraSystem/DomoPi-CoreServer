package com.marktech.domopi.controller.commands;

import com.marktech.domopi.controller.devices.Dispositivo;
import com.marktech.domopi.controller.devices.DispositivoConcreto;
import com.marktech.domopi.controller.interfaccia.Interfaccia;
import com.marktech.domopi.controller.message.Messaggio;
import com.marktech.domopi.controller.periferiche.Iperiferica;

import java.util.List;

/**
 * Created by Marco on 11/11/2018.
 */
public class ComandoAdd implements Comando {


    @Override
    public void execute(Iperiferica iperiferica) {
        Interfaccia.getIstanza().addPeriferica(iperiferica);
    }

    @Override
    public String getCommand() {
        return "add";
    }


}
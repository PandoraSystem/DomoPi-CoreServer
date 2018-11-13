package com.marktech.domopi.controller.commands;

import com.marktech.domopi.controller.devices.Dispositivo;
import com.marktech.domopi.controller.devices.DispositivoConcreto;
import com.marktech.domopi.controller.message.Messaggio;

import java.util.List;

/**
 * Created by Marco on 11/11/2018.
 */
public class ComandoUpdate implements Comando {


    @Override
    public void execute(Messaggio msg, List<Dispositivo> dipositivi) {
        for(Dispositivo dispositivo : dipositivi){
            if(dispositivo.getId() == msg.getId()){
                dispositivo.setNome("sdf");
            }
        }

    }

    @Override
    public String getCommand() {
        return "create";
    }


}

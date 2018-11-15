package com.marktech.domopi.controller.commands;

import com.marktech.domopi.controller.interfaccia.Interfaccia;
import com.marktech.domopi.controller.periferiche.Iperiferica;

/**
 * Created by Marco on 11/11/2018.
 */
public class ComandoExecute implements Comando {


    @Override
    public void execute(Iperiferica iperiferica) {
        Interfaccia.getIstanza().getPeriferica(iperiferica.getId()).execute();
    }

    @Override
    public Cmd getCommand() {
        return Cmd.EXE;
    }


}
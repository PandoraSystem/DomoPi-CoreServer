package com.marktech.domopi.controller.commands;

import com.marktech.domopi.controller.interfaccia.Interfaccia;
import com.marktech.domopi.controller.periferiche.Iperiferica;

/**
 * Created by Marco on 11/11/2018.
 */
public class ComandoRead implements Comando {


    @Override
    public void execute(Iperiferica iperiferica) {
        // Da inviare un Singleton Che fornirà il metodo di Response
        try {
            Iperiferica perifericaSelezionata = Interfaccia.getIstanza().getPeriferica(iperiferica.getId());
            perifericaSelezionata.read();
        } catch(NullPointerException e) {
            e.printStackTrace();
            System.out.println(e);
            System.out.println("ID non presente tra la lista delle periferiche, non è possibile leggere");
        }

    }

    @Override
    public Cmd getCommand() {
        return Cmd.RED;
    }


}
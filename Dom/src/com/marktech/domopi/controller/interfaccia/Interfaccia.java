package com.marktech.domopi.controller.interfaccia;



import com.marktech.domopi.controller.periferiche.Iperiferica;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Marco on 14/11/2018.
 */
public class Interfaccia {
    Map<String,Iperiferica> mappaPeriferiche;

    public Interfaccia() {
        this.mappaPeriferiche = new HashMap<>();
    }

    void addPeriferica(Iperiferica iperiferica){
        mappaPeriferiche.put(iperiferica.getId(),iperiferica);
    }

    void delPeriferica(Iperiferica iperiferica){
        mappaPeriferiche.remove(iperiferica.getId());
    }

    void delPeriferica(String idPeriferica){
        mappaPeriferiche.remove(idPeriferica);
    }

    Iperiferica getPeriferica(Iperiferica iperiferica){
        return mappaPeriferiche.get(iperiferica.getId());
    }

    Iperiferica getPeriferica(String idPeriferica){
        return mappaPeriferiche.get(idPeriferica);
    }
}

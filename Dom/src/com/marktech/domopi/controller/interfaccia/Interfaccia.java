package com.marktech.domopi.controller.interfaccia;



import com.marktech.domopi.controller.debug.Debug;
import com.marktech.domopi.controller.periferiche.Iperiferica;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Marco on 14/11/2018.
 * Singleton
 */
public class Interfaccia {
    private static Interfaccia istanza;
    private Map<String,Iperiferica> mappaPeriferiche;

    private Interfaccia() {
        this.mappaPeriferiche = new HashMap<>();
    }

    public static Interfaccia getIstanza(){
        if(istanza == null)
        {
            istanza = new Interfaccia();
        }
        return istanza;
    }


    public void addPeriferica(Iperiferica iperiferica){
        mappaPeriferiche.put(iperiferica.getId(),iperiferica);
        Debug.getIstanza().myDebug("[Interfaccia] : Aggiunto : id:" + iperiferica.getId() + " idgruppo:" + iperiferica.getIdGruppo() + "pin: " + iperiferica.getOperiferica().getPin());
    }

    public void delPeriferica(Iperiferica iperiferica){
        mappaPeriferiche.remove(iperiferica.getId());
    }

    public void delPeriferica(String idPeriferica){
        mappaPeriferiche.remove(idPeriferica);
    }

    public Iperiferica getPeriferica(Iperiferica iperiferica){
        Debug.getIstanza().myDebug(iperiferica.getId());
        return mappaPeriferiche.get(iperiferica.getId());
    }

    public Iperiferica getPeriferica(String idPeriferica){

        try {
            if(mappaPeriferiche.containsKey(idPeriferica)){
                Debug.getIstanza().myDebug(idPeriferica);
            return mappaPeriferiche.get(idPeriferica);}
            else{ //Response
                Debug.getIstanza().myDebug("Elemento non trovato");
                 return null; }

        } catch(Exception e) {
            e.printStackTrace();
            Debug.getIstanza().myDebug(e.toString());
            return null;
            // Response
        }
    }
}

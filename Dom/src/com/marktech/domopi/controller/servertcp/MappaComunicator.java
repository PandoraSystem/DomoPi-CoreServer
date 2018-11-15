package com.marktech.domopi.controller.servertcp;

import java.util.HashMap;
import java.util.Map;

public class MappaComunicator {
    private static MappaComunicator istanza;
    private Map<Integer,Comunicator> mappaComunicator ;

    private MappaComunicator(){
        mappaComunicator = new HashMap<>();
    }

    public static MappaComunicator getIstanza(){
        if(istanza == null){ istanza = new MappaComunicator();}
        return istanza;
    }

    public void addComunicator(Integer id,Comunicator comunicator){
        mappaComunicator.put(comunicator.getId(),comunicator);
    }

    public Comunicator getComunicator(Integer id){
        return mappaComunicator.get(id);
    }

    public void delComunicator(Integer id){
        mappaComunicator.remove(id);
    }


}

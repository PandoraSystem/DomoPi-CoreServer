package com.marktech.domopi.controller.devices;

import com.marktech.domopi.controller.message.Messaggio;

/**
 * Created by Marco on 11/11/2018.
 */
public class TestDeviceManager {

    private static String comandoRicevuto = "create.dispositivo.0001.null:update.dispositivo.0001.name.Luce";


    public static void main(String[] args) {

        DeviceManager deviceManager = new DeviceManager();
        OperationList operationList = new OperationList(comandoRicevuto);

        for(Messaggio m:operationList.getMessaggi()){
            //System.out.println(m.getComandoTipo()+m.getRiferimento()+m.getId()+m.getOpz1());
        }

        deviceManager.elaboration(operationList.getMessaggi());

    }
}

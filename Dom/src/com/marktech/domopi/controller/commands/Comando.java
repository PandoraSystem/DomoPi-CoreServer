package com.marktech.domopi.controller.commands;

import com.marktech.domopi.controller.devices.Dispositivo;
import com.marktech.domopi.controller.message.Messaggio;
import com.marktech.domopi.controller.periferiche.Iperiferica;

import java.util.List;

/**
 * Created by Marco on 11/11/2018.
 */
public interface Comando {
    void execute(Iperiferica iperiferica);
    String getCommand();
}

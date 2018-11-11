package com.marktech.domopi.controller.commands;

import com.marktech.domopi.controller.devices.Dispositivo;
import com.marktech.domopi.controller.message.Messaggio;

import java.util.List;

/**
 * Created by Marco on 11/11/2018.
 */
public interface Comando {
    void execute(Messaggio msg, List<Dispositivo> dipositivi);
    String getCommand();
}

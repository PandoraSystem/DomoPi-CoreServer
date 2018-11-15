package com.marktech.domopi.controller.commands;
import com.marktech.domopi.controller.periferiche.Iperiferica;

/**
 * Created by Marco on 11/11/2018.
 */
public interface Comando {
    void execute(Iperiferica iperiferica);
    Cmd getCommand();
}

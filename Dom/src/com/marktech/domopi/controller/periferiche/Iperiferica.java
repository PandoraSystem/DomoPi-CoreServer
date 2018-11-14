package com.marktech.domopi.controller.periferiche;

public interface Iperiferica {

    void execute();
    boolean getStatus();
    String getId();
    String getIdGruppo();
    Operiferica getOperiferica();
}

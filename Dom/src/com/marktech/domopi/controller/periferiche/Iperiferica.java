package com.marktech.domopi.controller.periferiche;

public interface Iperiferica {

    void execute();
    void read();
    void delete();
    boolean getStatus();
    String getId();
    String getIdGruppo();
    Operiferica getOperiferica();
}

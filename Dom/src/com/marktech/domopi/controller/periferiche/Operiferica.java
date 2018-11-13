package com.marktech.domopi.controller.periferiche;

import java.io.Serializable;

public class Operiferica implements Serializable {
    String pin;
    String id;
    String idGruppo;

    public Operiferica(String pin, String id, String idGruppo) {
        this.pin = pin;
        this.id = id;
        this.idGruppo = idGruppo;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdGruppo() {
        return idGruppo;
    }

    public void setIdGruppo(String idGruppo) {
        this.idGruppo = idGruppo;
    }
}

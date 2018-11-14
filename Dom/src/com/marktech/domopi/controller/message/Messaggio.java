package com.marktech.domopi.controller.message;

import com.marktech.domopi.controller.periferiche.Iperiferica;

import java.io.Serializable;

/**
 * Created by Marco on 11/11/2018.
 */
public class Messaggio implements Serializable {
    private String crude;
    private Iperiferica iperiferica;

    public String getCrude() {
        return crude;
    }

    public void setCrude(String crude) {
        this.crude = crude;
    }

    public Iperiferica getIperiferica() {
        return iperiferica;
    }

    public void setIperiferica(Iperiferica iperiferica) {
        this.iperiferica = iperiferica;
    }
}

package com.marktech.domopi.controller.message;

import com.marktech.domopi.controller.commands.Cmd;
import com.marktech.domopi.controller.periferiche.Iperiferica;

import java.io.Serializable;

/**
 * Created by Marco on 11/11/2018.
 */
public class Messaggio implements Serializable {
    private Cmd crude;
    private Iperiferica iperiferica;

    public Messaggio(int id, Cmd add) {
        this.id = id;
    }

    public Messaggio(Cmd crude, Iperiferica iperiferica, int id) {
        this.crude = crude;
        this.iperiferica = iperiferica;
        this.id = id;
    }

    private int id;

    public Cmd getCrude() {
        return crude;
    }

    public void setCrude(Cmd crude) {
        this.crude = crude;
    }

    public Iperiferica getIperiferica() {
        return iperiferica;
    }

    public void setIperiferica(Iperiferica iperiferica) {
        this.iperiferica = iperiferica;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

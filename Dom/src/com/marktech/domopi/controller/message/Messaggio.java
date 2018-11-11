package com.marktech.domopi.controller.message;

/**
 * Created by Marco on 11/11/2018.
 */
public class Messaggio {
    private String id,comandoTipo, riferimento, opz1,opz2;

    public Messaggio(String id, String comandoTipo, String riferimento, String verso) {
        this.id = id;
        this.comandoTipo = comandoTipo;
        this.riferimento = riferimento;
        this.opz1 = verso;

    }

    public String getId() {
        return id;
    }

    public String getComandoTipo() {
        return comandoTipo;
    }

    public String getRiferimento() {
        return riferimento;
    }

    public String getOpz1() {
        return opz1;
    }
}

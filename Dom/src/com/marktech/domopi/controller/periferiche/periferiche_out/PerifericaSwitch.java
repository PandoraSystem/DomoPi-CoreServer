package com.marktech.domopi.controller.periferiche.periferiche_out;

import com.marktech.domopi.controller.periferiche.Iperiferica;
import com.marktech.domopi.controller.periferiche.Operiferica;

import java.io.Serializable;

/**
 * PerifericaSwitch *
 * Questa periferica di base offre un servizio di On e Off *
 */
public class PerifericaSwitch implements Iperiferica,Serializable {

    // Oggetto generico conformazione periferica
    private Operiferica operiferica;

    /**
     * Costruttore manuale, passando gli elementi base per creare una Operiferica
     * @param pin Formato String, rappresentati su package controller.provisioning.MappaPin.
     * @param id Formato String, rappresenta l'id univoco.
     * @param idGruppo Formato String, rappresenta l'id di un raggruppamento.
     */
    public PerifericaSwitch(String pin, String id, String idGruppo) {
        this.operiferica = new Operiferica(pin,id,idGruppo);
        this.operiferica.provisioning();
    }

    /**
     * Costruttore automatico, tramite passaggio diretto di un oggetto Operiferica
     * @param operiferica
     */
    public PerifericaSwitch(Operiferica operiferica) {
        this.operiferica = operiferica;
        this.operiferica.provisioning();
    }


    //Esegue l'azione per cui è nata la Periferica
    @Override
    public void execute() {
        this.operiferica.getProvisionedPin().toggle();
    }
    // Ritorna lo stato booleano del pin
    @Override
    public boolean getStatus(){
        return this.operiferica.getProvisionedPin().getState().isHigh();
    }
    // Ritorna l'id della periferica
    @Override
    public String getId() {
        return operiferica.getId();
    }
    // Ritorna l'id di gruppo della periferica
    @Override
    public String getIdGruppo() {
        return operiferica.getIdGruppo();
    }
    // Ritorna l'oggetto operiferica
    @Override
    public Operiferica getOperiferica() {
        return this.operiferica;
    }
}

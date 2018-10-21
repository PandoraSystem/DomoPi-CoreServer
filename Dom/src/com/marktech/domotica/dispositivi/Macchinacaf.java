package com.marktech.domotica.dispositivi;


/**
 * 
 */
public class Macchinacaf extends Dispositivi {



    private String name;                                                                                                // nome della macchina
    private boolean statusMachine;                                                                                      // accesa?
    private int timer;                                                                                                  // tempo on per caffè
    private int pressione;                                                                                              // pressione pompa
    private int consumiEnergia;                                                                                         // energia comsumata ?


    /**
     * Default constructor
     */
    public Macchinacaf(int id) {
        super(id);
    }

    /**
     *
     * Contructor with id and name
     *
     * @param id 
     * @param name
     */
    public Macchinacaf(int id, String name) {
        super(id);
        this.name = name;
    }

    /**
     * Start coffe program
     */
    public void StartCoffe() {
        // TODO implement here
    }

    /**
     *  status coffe machine
     */
    public void CheckMachine() {
        // TODO implement here
    }

}
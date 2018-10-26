package com.marktech.domotica.devicemanager.devices;

/**
 * Created by PC-Fisso on 23/10/2018.
 */
public abstract class Generaldevice {

    private int id;


    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }


    public Generaldevice(){
        setId((int) Math.random());
    }

    public  Generaldevice(int id){
        setId(this.id);
    }







}

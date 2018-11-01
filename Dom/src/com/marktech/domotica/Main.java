package com.marktech.domotica;

import com.marktech.domotica.raspberry.ProxyHardware;
import com.marktech.domotica.servertcp.Server;

public class Main {

    public static void main(String[] args) {

        // attiviamo le uscite hardware del raspberry
        ProxyHardware ph = new ProxyHardware();

        Server server = new Server(9000,true);
        Thread t = new Thread(server);
        t.start();



    }
}

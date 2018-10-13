package com.marktech.domotica;

import com.marktech.domotica.servertcp.Server;

public class Main {

    public static void main(String[] args) {

        Server server = new Server(9000);
        Thread t = new Thread(server);
        t.start();
    }
}

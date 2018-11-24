package com.marktech.domopi;

import com.marktech.domopi.controller.ControllerDomoPi;
import com.marktech.domopi.controller.debug.Debug;

public class Main {
    private static ControllerDomoPi controller;


    public static void main(String[] args) {
        Debug.getIstanza().myDebug("Start Application");
        controller = ControllerDomoPi.getGestione();
        controller.startServer();

        while(true);

    }
}

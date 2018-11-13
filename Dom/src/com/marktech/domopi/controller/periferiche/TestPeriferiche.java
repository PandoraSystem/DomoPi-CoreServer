package com.marktech.domopi.controller.periferiche;

import com.marktech.domopi.controller.periferiche.out.PerifericaSwitch;

/**
 * Created by Marco on 13/11/2018.
 */
public class TestPeriferiche {

    public static void main(String[] args) {

        try {
            PerifericaSwitch perifericaSwitch = new PerifericaSwitch("GPIO_02", "out", "1", "1");

            System.out.println(perifericaSwitch.getStatus());
            perifericaSwitch.execute();
            System.out.println(perifericaSwitch.getStatus());
        } catch(Exception e) {
            e.printStackTrace();


        }

    }



}

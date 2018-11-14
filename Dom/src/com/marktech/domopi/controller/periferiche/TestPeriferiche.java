package com.marktech.domopi.controller.periferiche;

import com.marktech.domopi.controller.periferiche.out.PerifericaSwitch;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Created by Marco on 13/11/2018.
 */
public class TestPeriferiche {

    public static void main(String[] args) {

        try {

            // Test di creazione
            PerifericaSwitch perifericaSwitch = new PerifericaSwitch("GPIO_02", "1", "1");


            // Test di esecuzione
            System.out.println(perifericaSwitch.getStatus());
            perifericaSwitch.execute();
            System.out.println(perifericaSwitch.getStatus());

            // Test di serializzazione
            try(
                    FileOutputStream f = new FileOutputStream(new File("serialize.class"));
                    ObjectOutputStream s = new ObjectOutputStream(f)
                )
            {
                s.writeObject(perifericaSwitch);
                System.out.println("oggetto serializzato");

            } catch(IOException e) {
                e.printStackTrace();
            }


        } catch(Exception e) {
            e.printStackTrace();


        }

    }



}

package com.marktech.domopi.controller.debug;

import com.marktech.domopi.controller.commands.Cmd;
import com.marktech.domopi.controller.message.Messaggio;
import com.marktech.domopi.controller.periferiche.outperiferiche.PerifericaSwitch;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by Marco on 16/11/2018.
 */
public class ServerClientTester {

    public static void main(String[] args) throws IOException {
        Socket echoSocket = null;

        // Test di creazione
        PerifericaSwitch perifericaSwitch = new PerifericaSwitch("GPIO_02", "1", "1");


        // Test di esecuzione
        System.out.println(perifericaSwitch.getStatus());

        Messaggio messaggio = new Messaggio(Cmd.ADD , perifericaSwitch , 10);

        try {
            echoSocket = new Socket("127.0.0.1", 9000);
            echoSocket.setSoTimeout(10000);
            ObjectOutputStream s = new ObjectOutputStream(echoSocket.getOutputStream());
            s.writeObject(messaggio);
            s.flush();
            s.close();

            System.out.println("oggetto serializzato e spedito");
            echoSocket.close();
        } catch(IOException e) {
            e.printStackTrace();
        }

        Messaggio messaggio1 = new Messaggio(Cmd.RED, perifericaSwitch , 10);
        try {
            echoSocket = new Socket("127.0.0.1", 9000);
            echoSocket.setSoTimeout(10000);
            ObjectOutputStream s = new ObjectOutputStream(echoSocket.getOutputStream());
            s.writeObject(messaggio1);
            s.flush();
            s.close();

            System.out.println("oggetto serializzato e spedito");
            echoSocket.close();
        } catch(IOException e) {
            e.printStackTrace();
        }




    }
}

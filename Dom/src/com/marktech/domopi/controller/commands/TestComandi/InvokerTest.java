package com.marktech.domopi.controller.commands.TestComandi;

import com.marktech.domopi.controller.commands.Cmd;
import com.marktech.domopi.controller.commands.InvokerComando;
import com.marktech.domopi.controller.message.Messaggio;
import com.marktech.domopi.controller.periferiche.outperiferiche.PerifericaSwitch;

/**
 * Created by Marco on 15/11/2018.
 */
public class InvokerTest {

    public static void main(String[] args) throws InterruptedException {

        InvokerComando invoker = new InvokerComando();
        PerifericaSwitch lampada = new PerifericaSwitch("GPIO_01","1","1");
        Messaggio messaggio = new Messaggio(Cmd.ADD,lampada,10);

        // aggiungo
        invoker.executeCommandMessage(messaggio.getCrude(),messaggio.getIperiferica());
        System.out.println("Aggiunto dispositivo");
        Thread attualeThread = Thread.currentThread();
        attualeThread.sleep(3000);

        // leggo
        messaggio.setCrude(Cmd.RED);
        invoker.executeCommandMessage(messaggio.getCrude(),messaggio.getIperiferica());
        System.out.println("Letto Dispositivo");
        attualeThread.sleep(3000);

        // Aggiorno
        Messaggio messaggio2 = new Messaggio(Cmd.DEL,lampada,11);
        invoker.executeCommandMessage(messaggio2.getCrude(),messaggio2.getIperiferica());
        System.out.println("Eliminato Dispositivo");
        attualeThread.sleep(3000);



        // leggo
        // Aggiungere un controllo nel caso che non trovo il dispositivo cercato.
        messaggio.setCrude(Cmd.RED);
        invoker.executeCommandMessage(messaggio.getCrude(),messaggio.getIperiferica());
        System.out.println("Letto Dispositivo");
        attualeThread.sleep(3000);



    }
}

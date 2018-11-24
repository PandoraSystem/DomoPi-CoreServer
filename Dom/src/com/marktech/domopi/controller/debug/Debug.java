package com.marktech.domopi.controller.debug;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Date;

/**
 * Created by Marco on 18/11/2018.
 */
public class Debug {
    private static Debug istanza = null;

    private Debug(){

    }

    public static Debug getIstanza(){
        if(istanza == null){istanza = new Debug();}
        return istanza;
    }

    public void myDebug(String log){
        try {
            File myFile = new File("Log.txt");
            myFile.createNewFile();
            PrintWriter printWriter = new PrintWriter(new FileOutputStream(myFile) , true);
            Date data = new Date();
            String logTime = data.toString();
            printWriter.println();
            printWriter.write(logTime + " :" + log);

            System.out.println(log);
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

}

package com.marktech.domotica.gpiodevice;


import com.marktech.domotica.gpiodevice.comandi.ComandoEliminazione;
import com.marktech.domotica.gpiodevice.comandi.ComandoModifica;
import com.marktech.domotica.gpiodevice.comandi.ComandoScrittura;
import com.marktech.domotica.gpiodevice.device.DispositivoGpio;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marco on 01/11/2018.
 *
 * La classe Controller di gpiodevice permette di gestire il CRUD su xml.
 * Viene generato un file di nome GPIO_config.xml .
 *
 * Il Comando "ComandoLettura non esiste perchè è disponibile direttamente da questa classe
 * la lista degli oggetti caricati all'avvio dell'applicazione.
 * Ogni volta che si modifica uno stato dei pin occorre riavviare l'applicazione
 *
 * Ho usato il Pattern Command per gestire i tre stati
 */
public class Controller {
    private List<DispositivoGpio> listaGPIO = new ArrayList<DispositivoGpio>();
    private String configFileString;
    private File configFileXml;

    public List<DispositivoGpio> getListaGPIO() {
        return listaGPIO;
    }

    public Controller() throws JDOMException, IOException {

        // Check File ------------------------------------------------------------------------------------------##
        try {

            this.configFileString = new File(".").getCanonicalFile() + "/GPIO_config.xml";
            this.configFileXml = new File(configFileString);
            if(!configFileXml.exists()){
                NewFileXml();
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
        // ---------------------------------------------------------------------------------------------------- ##



        // Load objects ----------------------------------------------------------------------------------------##

        SAXBuilder builder = new SAXBuilder();
        Document document = builder.build(configFileXml);
        Element rootNode = document.getRootElement();
        List gpioList = rootNode.getChildren("gpio");

        for(int i = 0; i < gpioList.size(); i++) {

            Element node = (Element) gpioList.get(i);

            DispositivoGpio dg = new DispositivoGpio(
                Integer.valueOf( node.getAttribute("Id").getValue() ),
                node.getChildText("verso"),
                Integer.valueOf(node.getChildText("address")) ,
                configFileXml
            );


            System.out.println("gpio caricate :" + node.getChildText("verso"));

            listaGPIO.add(dg);

        }


    }

    public void EseguiComandi(Comando comando){
        try {
            comando.execute();
        } catch(JDOMException e) {
            e.printStackTrace();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void AggiungiDispositivo(DispositivoGpio dispositivoGpio){
        EseguiComandi(new ComandoScrittura(dispositivoGpio));
    }

    public void EliminaDispositivo(DispositivoGpio dispositivoGpio){
        EseguiComandi(new ComandoEliminazione(dispositivoGpio));
    }

    public void ModificaDispositivo(DispositivoGpio dispositivoGpio){
        EseguiComandi(new ComandoModifica(dispositivoGpio));
    }



    public void NewFileXml(){
        try {

            Element gpioElement = new Element("GPIO");
            Document doc = new Document(gpioElement);
            doc.setRootElement(gpioElement);

            // new XMLOutputter().output(doc, System.outperiferiche);
            XMLOutputter xmlOutput = new XMLOutputter();

            // display nice nice
            xmlOutput.setFormat(Format.getPrettyFormat());
            xmlOutput.output(doc, new FileWriter(configFileString));

            System.out.println("File Saved! " + configFileString);
        } catch (IOException io) {
            System.out.println(io.getMessage());
        }
    }
}

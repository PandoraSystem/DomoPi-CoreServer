package com.marktech.domotica.gpiodevice.device;

import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Created by PC-Fisso on 01/11/2018.
 */
public class DispositivoGpio {
    private int id;
    private int address;
    private String versoPin;
    private File file;
    private final String VERSO_OUT = "out";
    private final String VERSO_IN = "in";
    private final String[] VERSO = {VERSO_OUT,VERSO_IN};

    public DispositivoGpio(int id, String versoPin, int address, File file) {
        this.id = id;
        this.versoPin = versoPin;
        this.address = address;
        this.file = file;
    }


    public int getAddress() {
        return address;
    }

    public int getId() {
        return id;
    }

    public String getVersoPin() {
        return versoPin;
    }

    public File getFile() {
        return file;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAddress(int address) {
        this.address = address;
    }

    public void setVersoPin(String versoPin) {
        this.versoPin = versoPin;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String[] getVERSO() {
        return VERSO;
    }

    public void AddToConfiguration() throws JDOMException, IOException {
        SAXBuilder builder = new SAXBuilder();
        Document document = builder.build(getFile());
        Element rootNode = document.getRootElement();

        Element elemento = new Element("gpioPin");
        elemento.setAttribute(new Attribute("id",String.valueOf(getId())));
        elemento.addContent(new Element("verso").setText(getVersoPin()));
        elemento.addContent(new Element("address").setText(String.valueOf(getAddress())));

        document.getRootElement().addContent(elemento);

        // new XMLOutputter().output(doc, System.out);
        XMLOutputter xmlOutput = new XMLOutputter();

        // display nice nice
        xmlOutput.setFormat(Format.getPrettyFormat());
        String path = new File(".").getCanonicalPath();
        xmlOutput.output(document, new FileWriter(path + "\\GPIO_config.xml"));

        System.out.println("File Saved!");
    }

    public void RemoveToConfiguration() throws JDOMException, IOException {
        SAXBuilder builder = new SAXBuilder();
        Document document = builder.build(getFile());
        Element rootNode = document.getRootElement();
        List<Element> elements =  rootNode.getChildren("gpioPin");

        for(int i = 0; i < elements.size(); i++) {

            Element node =  elements.get(i);


            try {
                System.out.println("Attributo: " + elements.get(i).getAttribute("id").getValue());
                System.out.println("Match: " + String.valueOf(getId()));
                //System.out.println(new Attribute("id",String.valueOf(getId())));

                if(node.getAttribute("id").getValue().equals(String.valueOf(getId())) ){

                    node.detach();

                }
            } catch(Exception e) {
                e.printStackTrace();
            }


        }


        // new XMLOutputter().output(doc, System.out);
        XMLOutputter xmlOutput = new XMLOutputter();

        // display nice nice
        xmlOutput.setFormat(Format.getPrettyFormat());
        String path = new File(".").getCanonicalPath();
        xmlOutput.output(document, new FileWriter(path + "\\GPIO_config.xml"));

        System.out.println("File Saved!");
    }

    public void ModifyConfiguration() throws JDOMException, IOException {
        SAXBuilder builder = new SAXBuilder();
        Document document = builder.build(getFile());
        Element rootNode = document.getRootElement();
        List<Element> elements =  rootNode.getChildren("gpioPin");

        for(int i = 0; i < elements.size(); i++) {

            Element node =  elements.get(i);


            //System.out.println("Uscita :" + node.getChildText("OutName"));

            try {
                System.out.println("Attributo: " + elements.get(i).getAttribute("id").getValue());
                System.out.println("Match: " + String.valueOf(getId()));
                //System.out.println(new Attribute("id",String.valueOf(getId())));

                if(node.getAttribute("id").getValue().equals(String.valueOf(getId())) ){

                    node.getChild("address").setText(String.valueOf(getAddress()));
                    node.getChild("verso").setText(getVersoPin());

                }
            } catch(Exception e) {
                e.printStackTrace();
            }


        }


        // new XMLOutputter().output(doc, System.out);
        XMLOutputter xmlOutput = new XMLOutputter();

        // display nice nice
        xmlOutput.setFormat(Format.getPrettyFormat());
        String path = new File(".").getCanonicalPath();
        xmlOutput.output(document, new FileWriter(path + "\\GPIO_config.xml"));

        System.out.println("File Saved!");
    }


}

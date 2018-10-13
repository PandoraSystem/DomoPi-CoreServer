package com.marktech.domotica.servertcp;

/**
 * Created by PC-Fisso on 12/10/2018.
 */
public class Server implements Runnable {

    private Thread threadServer;
    private boolean socketStop;
    private int porta;

    /**
     *
     * COSTRUTTORE
     *
     * Configuro il server con solo la porta
     *
     * @param porta
     */
    public Server(int porta) {
        this.porta = porta;
    }

    /************************************
     *
     *
     * PROPERTY GETTER AND SETTER
     *
     *
     *************************************/

    public boolean isSocketStop() {
        return socketStop;
    }

    public void setSocketStop(boolean socketStop) {
        this.socketStop = socketStop;
    }

    public int getPorta() {
        return porta;
    }

    public void setPorta(int porta) {
        this.porta = porta;
    }




    @Override
    public void run() {

        // Controllo di flusso per lasciare il processo attivo. Unico modo per killare il processo
        while(!isSocketStop()){

            //attendi una connessione
            //ricava il messaggio in arrivo
            //rispondi al messaggio

            //Sviluppando
            // test
        }

    }



    public boolean StartServer()
    {
        try {
            threadServer = new Thread(this,"ThreadServer");
        } catch(Exception e) {
            e.printStackTrace();
            return false;
        }   return true;
    }

    public void StopServer()
    {
        setSocketStop(true);
    }












}

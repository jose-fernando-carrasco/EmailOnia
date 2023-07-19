/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saludsc;

import Negocio.NCasosBrigadas;

import Comunicacion.MailVerificationThread;
import Comunicacion.SendEmailThread;
import Conexion.IEmailEventListener;
import Metodos.CasoBrigada;
import Metodos.CasoHospital;
import Metodos.Mapa;
import Negocio.NCasosHospitales;
import interpreter.analex.Interpreter;
import interpreter.analex.interfaces.ITokenEventListener;
import interpreter.analex.utils.Token;
import interpreter.events.TokenEvent;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import Utils.Email;
import Utils.Handler;
import Utils.Validator;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 
 */
public class MailAplication implements IEmailEventListener, ITokenEventListener {

    private MailVerificationThread mailVerificationThread;
    
    private CasoHospital casoHospital;
    private CasoBrigada casoBrigada;
    private Mapa mapa;

    public MailAplication() {
        mailVerificationThread = new MailVerificationThread();
        mailVerificationThread.setEmailEventListener(MailAplication.this);
        casoBrigada = new CasoBrigada();
        casoHospital = new CasoHospital();
        mapa = new Mapa();

    }

    public void start() throws InterruptedException {
        Thread thread = new Thread(mailVerificationThread);
        thread.setName("Mail Verfication Thread");
        thread.start();
        //-------eliminar------ ya está add
       /*List<Email> em = new ArrayList<>();
        String coma = "mapa get ";
        em.add(new Email("fernandocarrasc591@gmail.com", coma, "Hulala"));
        onReceiveEmailEvent(em);*/
        //-------hasta aqui----
    }

    @Override
    public void onReceiveEmailEvent(List<Email> emails) {
        System.out.println("onReceiveEmailEvent()");
        for (Email email : emails) {
            Interpreter interpreter = new Interpreter(email.getSubject(), email.getFrom());
            interpreter.setListener(MailAplication.this);
            Thread thread = new Thread(interpreter);
            thread.setName("Interpreter Thread");
            thread.start();
        }
    }

    @Override
    public void user(TokenEvent event) {
    }

    @Override
    public void error(TokenEvent event) {
        Handler.handleError(event.getAction(), event.getSender(), event.getParams());
    }
    
   
    
    @Override
    public void mapa(TokenEvent event) {
        System.out.println("mapa() -> " + event.getAction());
        switch (event.getAction()) {
            case Token.ADD:
                mapa.agregar((ArrayList<String>) event.getParams(), event.getSender());
                break;
            case Token.MODIFY:
                mapa.modificar((ArrayList<String>) event.getParams(), event.getSender());
                break;
            case Token.DELETE:
                mapa.eliminar((ArrayList<String>) event.getParams(), event.getSender());
                break;
            case Token.VERIFY:
                mapa.ver((ArrayList<String>) event.getParams(), event.getSender());
                break;
            case Token.GET:
                mapa.listar((ArrayList<String>) event.getParams(), event.getSender());
                break;
        }
    }

    
    @Override
    public void casohospital(TokenEvent event) {
        System.out.println("casohospital() -> " + event.getAction());
        switch (event.getAction()) {
            case Token.ADD:
                casoHospital.agregar((ArrayList<String>) event.getParams(), event.getSender());
                break;
            case Token.MODIFY:
                casoHospital.modificar((ArrayList<String>) event.getParams(), event.getSender());
                break;
            case Token.DELETE:
                casoHospital.eliminar((ArrayList<String>) event.getParams(), event.getSender());
                break;
            case Token.VERIFY:
                casoHospital.ver((ArrayList<String>) event.getParams(), event.getSender());
                break;
            case Token.GET:
                casoHospital.listar((ArrayList<String>) event.getParams(), event.getSender());
                break;
        }
    }
    
    
    @Override
    public void casobrigada(TokenEvent event) {
        System.out.println("casobrigada() -> " + event.getAction());
        switch (event.getAction()) {
            case Token.ADD:
                casoBrigada.agregar((ArrayList<String>) event.getParams(), event.getSender());
                break;
            case Token.MODIFY:
                casoBrigada.modificar((ArrayList<String>) event.getParams(), event.getSender());
                break;
            case Token.DELETE:
                casoBrigada.eliminar((ArrayList<String>) event.getParams(), event.getSender());
                break;
            case Token.VERIFY:
                casoBrigada.ver((ArrayList<String>) event.getParams(), event.getSender());
                break;
            case Token.GET:
                casoBrigada.listar((ArrayList<String>) event.getParams(), event.getSender());
                break;
        }
    }

}

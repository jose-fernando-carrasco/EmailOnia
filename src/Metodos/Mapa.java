/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metodos;

import Negocio.NCasosBrigadas;
import Negocio.NMapas;
import Utils.Email;
import Utils.Handler;
import Utils.HtmlBuilder;
import Utils.Utiles;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import saludsc.MailAplication;

public class Mapa {

    private NMapas nmapa;

    public Mapa() {
        this.nmapa = new NMapas();
    }

    public void listar(ArrayList<String> parametros, String correo) {
        try {
            String mensaje = "No tiene los permisos, No es un Usuario registrado";
            //if (brigada.permiso(correo)) {
            ArrayList<ArrayList<String[]>> mapasConEnfermedades = nmapa.listar();
            mensaje = "Mapa Listar Correctamente";
            //}
            String[] headers = {"Id", "Titulo", "Detalle", "Latitud", "Longitud", "Enfermedades"};
            ArrayList<String[]> filas = Utiles.filasMapas(mapasConEnfermedades.get(0),mapasConEnfermedades.get(1));
            Email emailObject = new Email(correo, "GRUPO 13 SC", HtmlBuilder.generateTabla(headers,filas));
            Email.sendEmail(emailObject);
            
        } catch (SQLException ex) {
            System.out.println("entre a SQLException");
            Logger.getLogger(MailAplication.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IndexOutOfBoundsException ex) {
            Handler.handleError(Handler.INDEX_OUT_OF_BOUND_ERROR, correo, null);
        } catch (NumberFormatException ex) {
            Handler.handleError(Handler.NUMBER_FORMAT_ERROR, correo, null);
        } catch (RuntimeException ex) {
            Handler.handleError(Handler.CONSTRAINTS_ERROR, correo, null);
        }

    }

    public void ver(ArrayList<String> parametros, String correo) {
        try {
            String mensaje = "No tiene los permisos, No es un Usuario registrado";
            //if (brigada.permiso(correo)) {
            ArrayList<String[]> mapa = nmapa.ver(parametros);
            mensaje = "Mapa Ver Correctamente";
            //}
            Email emailObject = new Email(correo, "GRUPO 13 SC", HtmlBuilder.generateMapa());
            Email.sendEmail(emailObject);
            System.out.println(mensaje);
            System.out.println(mapa);
        } catch (SQLException ex) {
            System.out.println("entre a SQLException");
            Logger.getLogger(MailAplication.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Handler.handleError(Handler.PARSE_ERROR, correo, null);
        } catch (IndexOutOfBoundsException ex) {
            Handler.handleError(Handler.INDEX_OUT_OF_BOUND_ERROR, correo, null);
        } catch (NumberFormatException ex) {
            Handler.handleError(Handler.NUMBER_FORMAT_ERROR, correo, null);
        } catch (RuntimeException ex) {
            Handler.handleError(Handler.CONSTRAINTS_ERROR, correo, null);
        }

    }

    public void eliminar(ArrayList<String> parametros, String correo) {
        try {
            String mensaje = "No tiene los permisos, No es un Usuario registrado";
            //if (brigada.permiso(correo)) {
            nmapa.eliminar(parametros);
            mensaje = "Mapa Eliminado Correctamente";
            //}
            Email emailObject = new Email(correo, "GRUPO 13 SC", HtmlBuilder.generateSuccess("Muy Bien", mensaje));
            Email.sendEmail(emailObject);
            System.out.println(mensaje);
        } catch (SQLException ex) {
            System.out.println("entre a SQLException");
            Logger.getLogger(MailAplication.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Handler.handleError(Handler.PARSE_ERROR, correo, null);
        } catch (IndexOutOfBoundsException ex) {
            Handler.handleError(Handler.INDEX_OUT_OF_BOUND_ERROR, correo, null);
        } catch (NumberFormatException ex) {
            Handler.handleError(Handler.NUMBER_FORMAT_ERROR, correo, null);
        } catch (RuntimeException ex) {
            Handler.handleError(Handler.CONSTRAINTS_ERROR, correo, null);
        }

    }

    public void modificar(ArrayList<String> parametros, String correo) {
        try {
            String mensaje = "No tiene los permisos, No es un Usuario registrado";
            //if (brigada.permiso(correo)) {
            nmapa.modificar(parametros);
            mensaje = "Mapa Modificado Correctamente";
            //}
            Email emailObject = new Email(correo, "GRUPO 13 SC", HtmlBuilder.generateSuccess("Muy Bien", mensaje));
            Email.sendEmail(emailObject);
            System.out.println(mensaje);
        } catch (SQLException ex) {
            System.out.println("entre a SQLException");
            Logger.getLogger(MailAplication.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Handler.handleError(Handler.PARSE_ERROR, correo, null);
        } catch (IndexOutOfBoundsException ex) {
            Handler.handleError(Handler.INDEX_OUT_OF_BOUND_ERROR, correo, null);
        } catch (NumberFormatException ex) {
            Handler.handleError(Handler.NUMBER_FORMAT_ERROR, correo, null);
        } catch (RuntimeException ex) {
            Handler.handleError(Handler.CONSTRAINTS_ERROR, correo, null);
        }

    }

    public void agregar(ArrayList<String> parametros, String correo) {
        try {
            String mensaje = "No tiene los permisos, No es un Usuario registrado";
            //if (brigada.permiso(correo)) {
            nmapa.guardar(parametros);
            mensaje = "Mapa Guardado Correctamente";
            //}
            Email emailObject = new Email(correo, "GRUPO 13 SC", HtmlBuilder.generateSuccess("Muy Bien", mensaje));
            Email.sendEmail(emailObject);
            System.out.println(mensaje);
        } catch (SQLException ex) {
            System.out.println("entre a SQLException");
            Logger.getLogger(MailAplication.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Handler.handleError(Handler.PARSE_ERROR, correo, null);
        } catch (IndexOutOfBoundsException ex) {
            Handler.handleError(Handler.INDEX_OUT_OF_BOUND_ERROR, correo, null);
        } catch (NumberFormatException ex) {
            Handler.handleError(Handler.NUMBER_FORMAT_ERROR, correo, null);
        }
    }
}
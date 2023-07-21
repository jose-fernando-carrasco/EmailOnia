
package Metodos;

import Negocio.NTipoPunto;
import Utils.Handler;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import saludsc.MailAplication;


public class TipoPunto {
    NTipoPunto nTipoPunto;
     
     public TipoPunto() {
        this.nTipoPunto = new NTipoPunto();
    }
    public void agregar(ArrayList<String> parametros, String correo) {
        try {
            String mensaje = "No tiene los permisos, No es un Usuario registrado";
            //if (brigada.permiso(correo)) {
            nTipoPunto.guardar(parametros);
            
            mensaje = "Caso Tipo Punto Guardado Correctamente";
            //}
            //Email emailObject = new Email(correo, Email.SUBJECT, mensaje);
            //sendEmail(emailObject);
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
     
     public void listar(ArrayList<String> parametros, String correo) {
        try {
            String mensaje = "No tiene los permisos, No es un Usuario registrado";
            //if (brigada.permiso(correo)) {
            ArrayList<String[]> casos = nTipoPunto.listar();
            mensaje = "Caso Tipo Punto Listar Correctamente";
            //}
            //Email emailObject = new Email(correo, Email.SUBJECT, mensaje);
            //sendEmail(emailObject);
            System.out.println(mensaje);
            for (int i = 0; i < casos.size(); i++) {
                System.out.println("Caso[" + i + "]: " + Arrays.toString(casos.get(i)));
            }
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

   
    public void eliminar(ArrayList<String> parametros, String correo) {
        try {
            String mensaje = "No tiene los permisos, No es un Usuario registrado";
            //if (brigada.permiso(correo)) {
            nTipoPunto.eliminar(parametros);
            mensaje = "Caso Tipo Punto Eliminado Correctamente";
            //}
            //Email emailObject = new Email(correo, Email.SUBJECT, mensaje);
            //sendEmail(emailObject);
            System.out.println(mensaje);
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

    public void modificar(ArrayList<String> parametros, String correo) {
        try {
            String mensaje = "No tiene los permisos, No es un Usuario registrado";
            //if (brigada.permiso(correo)) {
            nTipoPunto.modificar(parametros);
            mensaje = "Caso Tipo Punto Modificado Correctamente";
            //}
            //Email emailObject = new Email(correo, Email.SUBJECT, mensaje);
            //sendEmail(emailObject);
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
}

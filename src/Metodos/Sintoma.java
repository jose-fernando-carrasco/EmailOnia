
package Metodos;

import Negocio.NSintoma;
import Utils.Handler;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import saludsc.MailAplication;


public class Sintoma {
    
    NSintoma nSintoma;
     
     public Sintoma() {
        this.nSintoma = new NSintoma();
    }
     
    public void agregar(ArrayList<String> parametros, String correo) {
        try {
            String mensaje = "No tiene los permisos, No es un Usuario registrado";
            //if (brigada.permiso(correo)) {
            nSintoma.guardar(parametros);
            
            mensaje = "Caso Sintoma Guardado Correctamente";
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
            ArrayList<String[]> casos = nSintoma.listar();
            mensaje = "Caso Sintoma Listar Correctamente";
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
            nSintoma.eliminar(parametros);
            mensaje = "Caso Sintoma Eliminado Correctamente";
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
            nSintoma.modificar(parametros);
            mensaje = "Caso Sintoma Modificado Correctamente";
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

package Metodos;

import Negocio.NCasosHospitales;
import Utils.Handler;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import saludsc.MailAplication;


public class CasoHospital {
    
    private NCasosHospitales ncasohospital;

    public CasoHospital() {
        this.ncasohospital = new NCasosHospitales();
    }
    
    
    public void listar(ArrayList<String> parametros, String correo) {
        try {
            String mensaje = "No tiene los permisos, No es un Usuario registrado";
            //if (brigada.permiso(correo)) {
            ArrayList<String[]> casos = ncasohospital.listar();
            mensaje = "Caso Brigada Listar Correctamente";
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

    public void ver(ArrayList<String> parametros, String correo) {
        try {
            String mensaje = "No tiene los permisos, No es un Usuario registrado";
            //if (brigada.permiso(correo)) {
            String[] caso = ncasohospital.ver(parametros);
            mensaje = "Caso Brigada Ver Correctamente";
            //}
            //Email emailObject = new Email(correo, Email.SUBJECT, mensaje);
            //sendEmail(emailObject);
            System.out.println(mensaje);
            System.out.println(Arrays.toString(caso));
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
            ncasohospital.eliminar(parametros);
            mensaje = "Caso Brigada Eliminado Correctamente";
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

    public void modificar(ArrayList<String> parametros, String correo) {
        try {
            String mensaje = "No tiene los permisos, No es un Usuario registrado";
            //if (brigada.permiso(correo)) {
            ncasohospital.modificar(parametros);
            mensaje = "Caso Brigada Modificado Correctamente";
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

    public void agregar(ArrayList<String> parametros, String correo) {
        try {
            String mensaje = "No tiene los permisos, No es un Usuario registrado";
            //if (brigada.permiso(correo)) {
            ncasohospital.guardar(parametros);
            mensaje = "Caso Brigada Guardado Correctamente";
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
}

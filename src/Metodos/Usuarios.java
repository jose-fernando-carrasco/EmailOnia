/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metodos;

import Negocio.NUsuario;
import Utils.Email;
import Utils.Handler;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import saludsc.MailAplication;


public class Usuarios {
    
    NUsuario nUsuario;

    public Usuarios() {
        nUsuario = new NUsuario();
    }

    public void agregar(ArrayList<String> parametros, String correo) {
        try {
            String mensaje = "No tiene los permisos, No es un Usuario registrado";
//            if (nUsuario.permiso(correo)) {
//                if (nUsuario.isAdministrador(correo)) {
            nUsuario.guardar(parametros);
            //mensaje = HtmlBuilder.generateSuccess("CU Usuarios, agregar usuario", "Se agregó correctamente un usuario al sistema");
//                } else {
//                    mensaje = "No tienes los permisos de un administrador";
//                }
//            }

//            Email emailObject = new Email(correo, Email.SUBJECT, mensaje);
//            MailAplication.sendEmail(emailObject);
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
        } catch (IllegalArgumentException ex) {
            Handler.handleError(Handler.PARSE_ERROR, correo, null);
        }
    }

    public void modificar(ArrayList<String> parametros, String correo) {
        try {
            String titulo = "CU Usuario, modificar usuario";
            String mensaje = "No tiene los permisos, No es un Usuario registrado";
//            if (nUsuario.permiso(correo)) {
            nUsuario.modificar(parametros);
            mensaje = "Se modificó correctamente un usuario del sistema";
//            }
//            mensaje = HtmlBuilder.generateSuccess(titulo, mensaje);
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
        } catch (IllegalArgumentException ex) {
            Handler.handleError(Handler.PARSE_ERROR, correo, null);
        }
    }

    public void eliminar(ArrayList<String> parametros, String correo) {
        try {
            String titulo = "CU Usuarios, eliminar usuario";
            String mensaje = "No tiene los permisos, No es un Usuario registrado";
//            if (nUsuario.permiso(correo)) {
            nUsuario.eliminar(parametros);
            mensaje = "Se eliminó correctamente del sistema un usuario";
//            }
//            mensaje = HtmlBuilder.generateSuccess(titulo, mensaje);
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

    public void ver(ArrayList<String> parametros, String correo) {
        try {
            String titulo = "CU Usuarios, ver usuario";
//            String mensaje = HtmlBuilder.generateError(titulo, "No tiene los permisos, No es un Usuario registrado");
//            if (nUsuario.permiso(correo)) {
            String[] usuario = nUsuario.ver(parametros);
            List<String[]> usuarios = new ArrayList<>();

            if (usuario != null) {
                usuarios.add(usuario);
            }

            String[] headers = new String[]{
                "Id",
                "Ci",
                "Nombre",
                "Email",
                "Apellido paterno",
                "Apellido materno",
                "Telefono",
                "Ubicacion",
                "Longitud",
                "Latitud",
                "Estado",
                "Genero",
                "Fecha de nacimiento",
                "Contraseña"
            };
//            mensaje = HtmlBuilder.generateTable(titulo, "Listar Usuarios", headers, usuarios);
//            }-
            
            //Email emailObject = new Email(correo, Email.SUBJECT, mensaje);
            //sendEmail(emailObject);
//            System.out.println(mensaje);
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

    public void listar(ArrayList<String> parametros, String correo) {
        try {
            String mensaje = "No tiene los permisos, No es un Usuario registrado";
//            if (nUsuario.permiso(correo)) {
            List<String[]> usuarios = nUsuario.listar();
            String[] headers = new String[]{
                "Id",
                "Ci",
                "Nombre",
                "Email",
                "Apellido paterno",
                "Apellido materno",
                "Telefono",
                "Ubicacion",
                "Longitud",
                "Latitud",
                "Estado",
                "Genero",
                "Fecha de nacimiento",
                "Contraseña"
            };
//            mensaje = HtmlBuilder.generateTable("CU Usuario", "Listar Usuarios", headers, usuarios);
//            }
//            Email emailObject = new Email(correo, Email.SUBJECT, mensaje);
//            MailApplication.sendEmail(emailObject);
            System.out.println(mensaje);
        } catch (SQLException ex) {
            System.out.println("entre a SQLException");
            Logger.getLogger(MailAplication.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NumberFormatException ex) {
            Handler.handleError(Handler.NUMBER_FORMAT_ERROR, correo, null);
        } catch (RuntimeException ex) {
            Handler.handleError(Handler.CONSTRAINTS_ERROR, correo, null);
        }
    }
}

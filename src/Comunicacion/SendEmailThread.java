package Comunicacion;

import Utils.Email;
import java.net.*;
import java.io.*;

public class SendEmailThread implements Runnable {

    String servidor = "mail.tecnoweb.org.bo";
    int puerto = 25;
    String user_emisor = "grupo24sc@tecnoweb.org.bo";
    String user_receptor;
    String comando = "";
    private Email email;

    /*
    String servidor = "smtp.googlemail.com";
    int puerto = 465;
    String user_emisor = "fernandocarrasc591@gmail.com";
    String user_receptor;
    String comando = "";
    private Email email;*/

    public SendEmailThread(Email email) {
        this.email = email;
        this.user_receptor = email.getTo();
    }

    @Override
    public void run() {

        try {
            Socket skCliente = new Socket(servidor, puerto);
            BufferedReader entrada = new BufferedReader(new InputStreamReader(skCliente.getInputStream()));
            DataOutputStream salida = new DataOutputStream(skCliente.getOutputStream());

            if ((skCliente != null) && (entrada != null) && (salida != null)) {
                System.out.println(" S: " + entrada.readLine());

                comando = "EHLO " + servidor + "\n";
                System.out.print("C : " + comando);
                salida.writeBytes(comando);
                System.out.println("S : " + entrada.readLine());

                comando = "MAIL FROM : " + user_emisor + "\n";
                System.out.print("C : " + comando);
                salida.writeBytes(comando);
                System.out.println("S : " + entrada.readLine());

                comando = "RCPT TO : " + user_receptor + "\n";
                System.out.print("C : " + comando);
                salida.writeBytes(comando);
                System.out.println("S : " + entrada.readLine());

                comando = "DATA\n";
                System.out.print("C : " + comando);
                salida.writeBytes(comando);
                System.out.println("S : " + entrada.readLine());
                    
                comando = "SUBJECT: " + email.getSubject() + "\n";
                comando += "Content-Type: text/html; charset=UTF-8\n";
                comando += email.getMessage() + "\n";
                comando += ".\n"; // No mandar espacios, solo punto

                System.out.print("C : " + comando);
                salida.writeBytes(comando);
                System.out.println("S : " + entrada.readLine());

                //cerrar la conexion
                comando = "QUIT\n";
                System.out.print("C :" + comando);
                salida.writeBytes(comando);
                System.out.println("S :" + entrada.readLine());

                skCliente.close();
                entrada.close();
                salida.close();
            }

        } catch (Exception e) {
            System.out.println(" C : " + e.getMessage());
        }

        /*email.getTo();
         email.getSubject();
        email.getMessage();*/
    }

    public static void main(String[] args) {

    }
}

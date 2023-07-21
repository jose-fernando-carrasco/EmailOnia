
package Negocio;


import Datos.DPuntoAtencion;
import Datos.DTipoPunto;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;


public class NPuntoAtencion {
    private DPuntoAtencion dPuntoAtencion;
    private DTipoPunto dTipoPunto;

    public NPuntoAtencion() {
        dPuntoAtencion = new DPuntoAtencion();
        dTipoPunto = new DTipoPunto();
    }
    
    
    public void guardar(List<String> parametros) throws SQLException, ParseException {
        if(parametros.size()>7){
            throw new IndexOutOfBoundsException("Muchos Parametros: ");
        }
        int idx = dTipoPunto.existe(Integer.parseInt(parametros.get(6)));
        if (idx != -1) {
            dPuntoAtencion.guardar(parametros.get(0), parametros.get(1),Double.parseDouble(parametros.get(2)),Double.parseDouble(parametros.get(3)),
                Integer.parseInt(parametros.get(4)),Integer.parseInt(parametros.get(5)),Integer.parseInt(parametros.get(6)));
            dPuntoAtencion.desconectar();
            System.out.println("NEGOCIO: CASO HOSPITAL GUARDADO");
        }else{
            System.out.println("No existe llave foranea");
            
        }
        
        
    }
    
    public void modificar(List<String> parametros) throws SQLException, ParseException {
        if(parametros.size()>8){
            throw new IndexOutOfBoundsException("Muchos Parametros: ");
        }
        int id = Integer.parseInt(parametros.get(0));
        
        if(dPuntoAtencion.existe(id)== -1){
            throw new RuntimeException ("id no existente");
        }
        
        int idx = dTipoPunto.existe(Integer.parseInt(parametros.get(7)));
        if (idx != -1) {
            dPuntoAtencion.modificar(Integer.parseInt(parametros.get(0)), parametros.get(1), 
                    parametros.get(2),Double.parseDouble(parametros.get(3)),Double.parseDouble(parametros.get(4)),
                    Integer.parseInt(parametros.get(5)),Integer.parseInt(parametros.get(6)),Integer.parseInt(parametros.get(7)));
            dPuntoAtencion.desconectar();
            System.out.println("NEGOCIO: CASO HOSPITAL MODIFICADO");
        }else{
            System.out.println("no existe llave foranea");
            
        }
        
    }
    
    public void eliminar(List<String> parametros) throws SQLException {
        if(parametros.size()>1){
            throw new IndexOutOfBoundsException("Muchos Parametros: ");
        }
        dPuntoAtencion.eliminar(Integer.parseInt(parametros.get(0)));
        dPuntoAtencion.desconectar();
        System.out.println("NEGOCIO: CASO HOSPITAL ELIMINADO");
    }
    
    public ArrayList<String[]> listar() throws SQLException {
        ArrayList<String[]> usuarios = (ArrayList<String[]>) dPuntoAtencion.listar();
        dPuntoAtencion.desconectar();
        System.out.println("NEGOCIO: CASO HOSPITAL LISTAR");
        return usuarios;
    }
    
}

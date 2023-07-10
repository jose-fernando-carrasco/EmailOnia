package Negocio;

import Datos.DEnfermedadViralMapa;
import Datos.DEstadiaEnfermedad;
import Datos.DMapas;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import Utils.Utiles;
import Utils.Validator;

public class NCasosBrigadas {

    private DEstadiaEnfermedad dEstadiaEnfermedad;

    public NCasosBrigadas() {
        this.dEstadiaEnfermedad = new DEstadiaEnfermedad();
    }

    public boolean permiso(String correo) throws SQLException {
        int usuarioId = dEstadiaEnfermedad.getIdByCorreo(correo);
        return usuarioId != -1;
    }

    public void guardar(ArrayList<String> parametros) throws SQLException, ParseException {
        
        if(parametros.size()>7)
            throw new IndexOutOfBoundsException("Muchos Parametros: ");
        Date fecha_ini = Utiles.StringToDate(parametros.get(0));
        Date fecha_fin = Utiles.StringToDate(parametros.get(1));
        String detalle = parametros.get(2);
        int user_id = Integer.parseInt(parametros.get(3));
        int estado_id = Integer.parseInt(parametros.get(4));
        int enfermedad_id = Integer.parseInt(parametros.get(5));
        int estadia_enfermedable_id = Integer.parseInt(parametros.get(6));
        String estadia_enfermedable_type = "App\\Models\\brigada";

        dEstadiaEnfermedad.guardar(fecha_ini, fecha_fin, detalle, user_id, estado_id, enfermedad_id, estadia_enfermedable_id, estadia_enfermedable_type);
        System.out.println("NEGOCIO: CASO GUARDADO");

    }

    public void modificar(ArrayList<String> parametros) throws SQLException, ParseException {

        if(parametros.size()>8)
            throw new IndexOutOfBoundsException("Muchos Parametros");
       
        int id = Integer.parseInt(parametros.get(0));
        
        if(dEstadiaEnfermedad.existeID(id)== -1)
            throw new RuntimeException ("id no existente");
        
        Date fecha_ini = Utiles.StringToDate(parametros.get(1));
        Date fecha_fin = Utiles.StringToDate(parametros.get(2));
        String detalle = parametros.get(3);
        int user_id = Integer.parseInt(parametros.get(4));
        int estado_id = Integer.parseInt(parametros.get(5));
        int enfermedad_id = Integer.parseInt(parametros.get(6));
        int estadia_enfermedable_id = Integer.parseInt(parametros.get(7));
        String estadia_enfermedable_type = "App\\Models\\brigada";

        dEstadiaEnfermedad.modificar(id,fecha_ini, fecha_fin, detalle, user_id, estado_id, enfermedad_id, estadia_enfermedable_id, estadia_enfermedable_type);
        System.out.println("NEGOCIO: CASO BRIGADA MODIFICADO");
    }

    
    public void eliminar(ArrayList<String> parametros) throws SQLException, ParseException {
        
        if(parametros.size()>1)
            throw new IndexOutOfBoundsException("Muchos Parametros");
        
        int estadiaId = Integer.parseInt(parametros.get(0));
        if(dEstadiaEnfermedad.existeID(estadiaId)== -1)
            throw new RuntimeException ("id no existente");
        
        dEstadiaEnfermedad.eliminar(estadiaId);
        System.out.println("NEGOCIO: CASO BRIGADA ELIMINADO");
    }
    
    
    public String[] ver(ArrayList<String> parametros) throws SQLException, ParseException {
        
        if(parametros.size()>1)
            throw new IndexOutOfBoundsException("Muchos Parametros");
        
        int mapa_id = Integer.parseInt(parametros.get(0));
        
        if(dEstadiaEnfermedad.existeID(mapa_id)== -1)
            throw new RuntimeException ("id no existente");
        
        String[] mapa = dEstadiaEnfermedad.ver(mapa_id);
        
        System.out.println("NEGOCIO: CASO BRIGADA VER");
        return mapa;
    }
    
    
    public ArrayList<String[]> listar() throws SQLException {
        ArrayList<String[]> casos = new ArrayList<>();
        casos = dEstadiaEnfermedad.listarRegistradasPorBrigadas();
        return casos;
    }
    

    public static void main(String[] args) throws SQLException, ParseException {
        NCasosBrigadas brigada = new NCasosBrigadas();

        //ArrayList<String> parametros = new ArrayList<>(Arrays.asList("2023-11-02", "2023-12-02", "detalle", "1", "6", "4", "2"));
        //brigada.guardar(parametros);
        //System.out.println(parametros);
        ArrayList<String[]> casos = brigada.listar();
        for (int i = 0; i < casos.size(); i++) {
            System.out.println("Caso["+i+"]: "+Arrays.toString(casos.get(i)));
        }

    }

}

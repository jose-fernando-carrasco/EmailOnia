/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Datos.DEnfermedadViralMapa;
import Datos.DMapas;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Usuario
 */
public class NMapas {

    private DMapas d_mapas;
    private DEnfermedadViralMapa d_enfermedad_viral_mapa;

    
    public NMapas() {
        this.d_mapas = new DMapas();
        this.d_enfermedad_viral_mapa = new DEnfermedadViralMapa();
    }

    
    public void guardar(ArrayList<String> parametros, ArrayList<String> enfermedadesID) throws SQLException, ParseException {

        String name = parametros.get(0);
        String detalle = parametros.get(1);
        Double latitud = Double.parseDouble(parametros.get(2));
        Double longitud = Double.parseDouble(parametros.get(3));

        long mapa_id = d_mapas.guardar(name, detalle, latitud, longitud);
        int enfermedad_id;
        
        for (int i = 0; i < enfermedadesID.size(); i++) {
            enfermedad_id = Integer.parseInt(enfermedadesID.get(i));
            d_enfermedad_viral_mapa.guardar(enfermedad_id, (int) mapa_id);
        }

        System.out.println("NEGOCIO: MAPA GUARDADO");
    }
    

    public void modificar(String mapaId, ArrayList<String> parametros, ArrayList<String> enfermedadesID) throws SQLException, ParseException {

        int mapa_id = Integer.parseInt(mapaId);
        String name = parametros.get(0);
        String detalle = parametros.get(1);
        Double latitud = Double.parseDouble(parametros.get(2));
        Double longitud = Double.parseDouble(parametros.get(3));

        d_mapas.modificar(mapa_id, name, detalle, latitud, longitud);
        d_enfermedad_viral_mapa.eliminar(mapa_id);
        int enfermedad_id;
        
        for (int i = 0; i < enfermedadesID.size(); i++) {
            enfermedad_id = Integer.parseInt(enfermedadesID.get(i));
            d_enfermedad_viral_mapa.guardar(enfermedad_id, mapa_id);
        }

        System.out.println("NEGOCIO: MAPA MODIFICADO");
    }
    
    
    public void eliminar(String mapaId) throws SQLException, ParseException {
        
        int mapa_id = Integer.parseInt(mapaId);
        d_enfermedad_viral_mapa.eliminar(mapa_id);
        d_mapas.eliminar(mapa_id);
        
        System.out.println("NEGOCIO: MAPA ELIMINADO");
    }
    
    
    public ArrayList<String[]> ver(String mapaId) throws SQLException, ParseException {
        
        int mapa_id = Integer.parseInt(mapaId);
        String[] mapa = d_mapas.ver(mapa_id);
        String[] enfermedadesId = d_enfermedad_viral_mapa.ver(mapa_id);
        
        ArrayList<String[]> mapaConEnfermedades = new ArrayList<>();
        mapaConEnfermedades.add(mapa);
        mapaConEnfermedades.add(enfermedadesId);
        
        System.out.println("NEGOCIO: MAPA VER");
        return mapaConEnfermedades;
    }
    
    
    public ArrayList<ArrayList<String[]>> listar() throws SQLException {
        ArrayList<ArrayList<String[]>> mapasConEnfermedades = new ArrayList<>();
        ArrayList<String[]> mapas = d_mapas.listar();
        ArrayList<String[]> enfermedadesId = new ArrayList<>();
        
        int mapa_id;
        for (String[] mapa : mapas) {
            mapa_id = Integer.parseInt(mapa[0]);
            enfermedadesId.add(d_enfermedad_viral_mapa.ver(mapa_id));
        }
        
        mapasConEnfermedades.add(mapas);
        mapasConEnfermedades.add(enfermedadesId);
        
        return mapasConEnfermedades;
    }
    
    
    /*Probando listar
        ArrayList<ArrayList<String[]>> Lista = A.listar();
        ArrayList<String[]> mapas = Lista.get(0);
        ArrayList<String[]> enfermedadesId = Lista.get(1);
        
        for (int i = 0; i < mapas.size(); i++) {
            System.out.println("Mapa["+i+"]: "+Arrays.toString(mapas.get(i)));
            System.out.println("EnfermedadesId["+i+"]: "+Arrays.toString(enfermedadesId.get(i)));
        }*/
    

    public static void main(String[] args) throws SQLException, ParseException {
        DMapas A = new DMapas();

        ArrayList<String> datos = new ArrayList<>();
        datos.add("mapa2");
        datos.add("detalle de mapa 2");
        datos.add("10.57");
        datos.add("19.457");

        ArrayList<String> enfermedadID = new ArrayList<>();
        enfermedadID.add("3");
        enfermedadID.add("5");
        //A.guardar(datos, enfermedadID);
        //A.modificar("7",datos, enfermedadID);
        //A.eliminar("3");
        //System.out.println("Mapa es: "+Arrays.toString(A.ver("7").get(0)));
        //System.out.println("Enfermedades id son: "+Arrays.toString(A.ver("7").get(1)));
        
        /*ArrayList<ArrayList<String[]>> Lista = A.listar();
        ArrayList<String[]> mapas = Lista.get(0);
        ArrayList<String[]> enfermedadesId = Lista.get(1);
        
        for (int i = 0; i < mapas.size(); i++) {
            System.out.println("Mapa["+i+"]: "+Arrays.toString(mapas.get(i)));
            System.out.println("EnfermedadesId["+i+"]: "+Arrays.toString(enfermedadesId.get(i)));
        }*/
        //estaba probando el listar del negocio

    }

}

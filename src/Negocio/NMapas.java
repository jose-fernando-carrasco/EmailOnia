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

    private DMapas dmapas;
    private DEnfermedadViralMapa denfermedadviralmapa;

    
    public NMapas() {
        this.dmapas = new DMapas();
        this.denfermedadviralmapa = new DEnfermedadViralMapa();
    }

    
    public void guardar(ArrayList<String> parametros) throws SQLException, ParseException {

        String name = parametros.get(0);
        String detalle = parametros.get(1);
        Double latitud = Double.parseDouble(parametros.get(2));
        Double longitud = Double.parseDouble(parametros.get(3));

        long mapa_id = dmapas.guardar(name, detalle, latitud, longitud);
        int enfermedad_id;
        
        ArrayList<String> enfermedadesID = new ArrayList<>(parametros.subList(4, parametros.size()));
        
        for (int i = 0; i < enfermedadesID.size(); i++) {
            enfermedad_id = Integer.parseInt(enfermedadesID.get(i));
            denfermedadviralmapa.guardar(enfermedad_id, (int) mapa_id);
        }

        System.out.println("NEGOCIO: MAPA GUARDADO");
    }
    

    public void modificar(ArrayList<String> parametros) throws SQLException, ParseException {

        int mapa_id = Integer.parseInt(parametros.get(0));
        String name = parametros.get(1);
        String detalle = parametros.get(2);
        Double latitud = Double.parseDouble(parametros.get(3));
        Double longitud = Double.parseDouble(parametros.get(4));
        
        if(!dmapas.existeID(mapa_id))
            throw new RuntimeException ("id no existente");

        dmapas.modificar(mapa_id, name, detalle, latitud, longitud);
        denfermedadviralmapa.eliminar(mapa_id);
        
        int enfermedad_id;
        ArrayList<String> enfermedadesID = new ArrayList<>(parametros.subList(5, parametros.size()));
        for (int i = 0; i < enfermedadesID.size(); i++) {
            enfermedad_id = Integer.parseInt(enfermedadesID.get(i));
            denfermedadviralmapa.guardar(enfermedad_id, mapa_id);
        }

        System.out.println("NEGOCIO: MAPA MODIFICADO");
    }
    
    
    public void eliminar(ArrayList<String> parametros) throws SQLException, ParseException {
        
        int mapa_id = Integer.parseInt(parametros.get(0));
        denfermedadviralmapa.eliminar(mapa_id);
        dmapas.eliminar(mapa_id);
        
        System.out.println("NEGOCIO: MAPA ELIMINADO");
    }
    
    
    public ArrayList<String[]> ver(ArrayList<String> parametros) throws SQLException, ParseException {
        
        int mapa_id = Integer.parseInt(parametros.get(0));
        String[] mapa = dmapas.ver(mapa_id);
        String[] enfermedadesId = denfermedadviralmapa.ver(mapa_id);
        
        ArrayList<String[]> mapaConEnfermedades = new ArrayList<>();
        mapaConEnfermedades.add(mapa);
        mapaConEnfermedades.add(enfermedadesId);
        
        System.out.println("NEGOCIO: MAPA VER");
        return mapaConEnfermedades;
    }
    
    
    public ArrayList<ArrayList<String[]>> listar() throws SQLException {
        ArrayList<ArrayList<String[]>> mapasConEnfermedades = new ArrayList<>();
        ArrayList<String[]> mapas = dmapas.listar();
        ArrayList<String[]> enfermedadesId = new ArrayList<>();
        
        int mapa_id;
        for (String[] mapa : mapas) {
            mapa_id = Integer.parseInt(mapa[0]);
            enfermedadesId.add(denfermedadviralmapa.ver(mapa_id));
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
        NMapas A = new NMapas();

        //ArrayList<String> datos = new ArrayList<>(Arrays.asList("mapa2X","detalle de mapa 2X","10.57","19.457","2","3"));
        //ArrayList<String> datos = new ArrayList<>(Arrays.asList("2","mapa2XL","detalle de mapa 2X","10.57","19.457","1","3"));
        
        //ArrayList<String> datosver = new ArrayList<>(Arrays.asList("2"));
        
        //A.guardar(datos);
        //A.modificar(datos);
        //A.eliminar("3");
        //System.out.println("Mapa es: "+Arrays.toString(A.ver(datosver).get(0)));
        //System.out.println("Enfermedades id son: "+Arrays.toString(A.ver(datosver).get(1)));
        
        ArrayList<ArrayList<String[]>> Lista = A.listar();
        ArrayList<String[]> mapas = Lista.get(0);
        ArrayList<String[]> enfermedadesId = Lista.get(1);
        
        for (int i = 0; i < mapas.size(); i++) {
            System.out.println("-----------------------------------------------");
            System.out.println("Mapa["+i+"]: "+Arrays.toString(mapas.get(i)));
            System.out.println("EnfermedadesId["+i+"]: "+Arrays.toString(enfermedadesId.get(i)));
        }
        //estaba probando el listar del negocio

    }

}

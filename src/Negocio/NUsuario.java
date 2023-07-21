/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Datos.DUsuario;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author USUARIO
 */
public class NUsuario {
     private final DUsuario dUsuario;

    private static final Map<String, Integer> ROLES;

    // Bloque estático de inicialización
    static {
        ROLES = new HashMap<>();
        ROLES.put("Administrador", 1);
        ROLES.put("Funcionario", 2);
        ROLES.put("Personal Médico", 3);
        ROLES.put("Paciente", 4);

    }

    public NUsuario() {
        dUsuario = new DUsuario();
    }

    public boolean isAdministrador(String correo) throws SQLException {
        int usuarioId = dUsuario.getRolByCorreo(correo);
        dUsuario.desconectar();
        return usuarioId == 1;
    }

    public boolean isFuncionario(String correo) throws SQLException {
        int usuarioId = dUsuario.getRolByCorreo(correo);
        dUsuario.desconectar();
        return usuarioId == 2;
    }

    public boolean isPersonalM(String correo) throws SQLException {
        int usuarioId = dUsuario.getRolByCorreo(correo);
        dUsuario.desconectar();
        return usuarioId == 3;
    }

    public boolean isPaciente(String correo) throws SQLException {
        int usuarioId = dUsuario.getRolByCorreo(correo);
        dUsuario.desconectar();
        return usuarioId == 4;
    }

    public boolean permiso(String correo) throws SQLException {
        int usuarioId = dUsuario.getIdByCorreo(correo);
        dUsuario.desconectar();
        return usuarioId != -1;
    }

    public void guardar(List<String> usuario) throws SQLException, ParseException, IllegalArgumentException {
        dUsuario.guardar(usuario.get(0), usuario.get(1), usuario.get(2),
                usuario.get(3), usuario.get(4), usuario.get(5), usuario.get(6),
                usuario.get(7), usuario.get(8), usuario.get(9), usuario.get(10), usuario.get(11), ROLES.get(usuario.get(12)));
        dUsuario.desconectar();
    }

    public void modificar(List<String> usuario) throws SQLException, ParseException, IllegalArgumentException {
        dUsuario.modificar(Integer.valueOf(usuario.get(0)), usuario.get(1), usuario.get(2),
                usuario.get(3), usuario.get(4), usuario.get(5), usuario.get(6),
                usuario.get(7), usuario.get(8), usuario.get(9), usuario.get(10), usuario.get(11), usuario.get(12), ROLES.get(usuario.get(13)));
        dUsuario.desconectar();
    }

    public void eliminar(List<String> parametros) throws SQLException, ParseException {
        dUsuario.eliminar(Integer.valueOf(parametros.get(0)));
        dUsuario.desconectar();
    }

    public void habilitar(List<String> parametros) throws SQLException, ParseException {
        dUsuario.habilitar(Integer.valueOf(parametros.get(0)));
        dUsuario.desconectar();
    }

    public List<String[]> listar() throws SQLException {
        List<String[]> usuarios = new ArrayList<>();
        usuarios = dUsuario.listar();
        return usuarios;
    }

    public String[] ver(List<String> parametros) throws SQLException, ParseException {
        String[] usuario = dUsuario.ver(Integer.valueOf(parametros.get(0)));
        dUsuario.desconectar();
        return usuario;
    }

}

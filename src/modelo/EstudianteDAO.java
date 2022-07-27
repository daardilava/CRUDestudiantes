/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Connection;
import controlador.ConexionBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author diego
 */
public class EstudianteDAO {
    ConexionBD conexion = new ConexionBD(); //instancia de conexionBD
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public List Listar () {
        String sql = "select * from estudiante";
        List<Estudiante> lista = new ArrayList<>();
        try {
            con = conexion.conectarBaseDatos();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {                
                Estudiante estudiante = new Estudiante();
                estudiante.setCode(rs.getInt(1));
                estudiante.setTipoID(rs.getString(2));
                estudiante.setNumeroID(rs.getInt(3));
                estudiante.setNombre(rs.getString(4));
                estudiante.setApellido(rs.getString(5));
                estudiante.setUsuario(rs.getString(6));
                estudiante.setContraseña(rs.getString(7));
                estudiante.setMovil(rs.getString(8));
                estudiante.setEmail(rs.getString(9));
                lista.add(estudiante);
            }
        } catch (SQLException e) {
            System.out.println("Error listar:" + e);
        }
        return lista;
        
    }//fin del metodo listar
    
    //Metodo agregar
    public void agregar(Estudiante estudiante){
        String sql = "insert into estudiante(tipoID, numeroID, Nombre, Apellido, Usuario, Contraseña, Movil, Email) values(?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            con = conexion.conectarBaseDatos();
            ps = con.prepareStatement(sql);
            ps.setString(1, estudiante.getTipoID());
            ps.setInt(2, estudiante.getNumeroID());
            ps.setString(3, estudiante.getNombre());
            ps.setString(4, estudiante.getApellido());
            ps.setString(5, estudiante.getUsuario());
            ps.setString(6, estudiante.getContraseña());
            ps.setString(7, estudiante.getMovil());
            ps.setString(8, estudiante.getEmail());
            ps.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println("Error en agregar: " + e);
        }
    }//fin del metodo agregar
    
    //Metodo actualizar
    public void actualizar(Estudiante estudiante){
        String sql = "update estudiante set tipoID=?, numeroID=?, nombre=?, apellido=?, usuario=?, contraseña=?, movil=?, email=? where id=?";
        try {
            con = conexion.conectarBaseDatos();
            ps = con.prepareStatement(sql);
            ps.setString(1, estudiante.getTipoID());
            ps.setInt(2, estudiante.getNumeroID());
            ps.setString(3, estudiante.getNombre());
            ps.setString(4, estudiante.getApellido());
            ps.setString(5, estudiante.getUsuario());
            ps.setString(6, estudiante.getContraseña());
            ps.setString(7, estudiante.getMovil());
            ps.setString(8, estudiante.getEmail());
            ps.setInt(9, estudiante.getCode());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error en actualizarDAO: " + e);
        }
  
    } //fin del metodo actualizar
    
    //Metodo Borrar
    public void borrar(int id) {
        String sql = "delete from estudiante where code="+id;
        try {
            con = conexion.conectarBaseDatos();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e){
            System.out.println("Error al borrarDAO: " + e);
        }
          
    }//fin del metodo borrar
    
} //fin de la clase EstudianteDAO

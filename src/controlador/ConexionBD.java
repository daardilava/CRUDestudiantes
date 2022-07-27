/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author diego
 */
public class ConexionBD {
    Connection con;
    String driver = "com.mysql.cj.jdbc.Driver";
    String dbName = "escuela";
    String url = "jdbc:mysql://localhost:3307/"+dbName+"?useSSL=false";
    String usuario = "root";
    String clave = "123456";
    
    public Connection conectarBaseDatos(){
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, usuario, clave);
            System.out.println("Conexion exitosa");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error en la conexion: "+ e);
        }
        return con;
    }
}

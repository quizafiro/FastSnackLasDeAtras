/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import utilidades.DAOException;

/**
 *
 * @author fl1pc24
 */
public class Conexion {
    private static Conexion instancia;
    private Connection conexion;
    private final String url = "jdbc:mysql://localhost:3306/fastsnack";
    private final String user = "root";
    private final String password = "FastSnack2025";

    private Conexion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(url, user, password);
            System.out.println("Conexión exitosa,mi estimad@");
        } catch (ClassNotFoundException | SQLException error) {
            System.out.println("ERROR DE CONEXIÓN" + error.getMessage());
        }
    }

    //metodo para establecer una instancia única
    public static synchronized Conexion getInstance() {
        if (instancia == null) {
            instancia = new Conexion();
        }
        return instancia;
    }

    public Connection getConnection() throws DAOException{
        try {
            if (conexion == null || conexion.isClosed()) {
                conexion = DriverManager.getConnection(url, user, password);
            }
            return conexion;
        } catch (SQLException error) {
           throw new DAOException("Error de conexion, fregaste", error);
        }
    }

    public void CloseConexion() {
        try{
            if (conexion != null && !conexion.isClosed()) {
                conexion.close();
                instancia = null;
            }
        }catch(SQLException error){
            System.err.println("Error de conexion: " + error.getMessage());
        }
        
    }







}  
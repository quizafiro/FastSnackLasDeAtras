/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Config.*;
import java.util.Optional;
import modelo.Cliente;
import utilidades.DAOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;



public class ClienteDAOImpl implements ClienteDAO {
    private static ClienteDAOImpl instance;
    
    private final Conexion conexion;

    public ClienteDAOImpl() {
        this.conexion=Conexion.getInstance();
    }
    
    
    @Override
    public Optional<Cliente> findByCodigo(String codigo) throws DAOException {
          try {

        Connection con = conexion.getConnection();

        String sql = "SELECT * FROM cliente WHERE codigo = ?";

        PreparedStatement ps = con.prepareStatement(sql);    
        ps.setString(1, codigo);
        
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
    
        Cliente cliente = new Cliente(
                "",
            rs.getString("nombre"),
            rs.getString("telefono")
        );

    return Optional.of(cliente);
    }       
    
return Optional.empty();

    } catch (SQLException error) {

        throw new DAOException(
                "Error al buscar cliente",
                error
        );

    }
}
@Override
    public Optional<Cliente> findByName(String nombre) throws DAOException {
        
    try {

        Connection con = conexion.getConnection();

        String sql = "SELECT * FROM cliente WHERE nombre = ?";

        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, nombre);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {

            Cliente cliente = new Cliente(
                    rs.getString("codigo"),
                    rs.getString("nombre"),
                    rs.getString("telefono")
            );

            return Optional.of(cliente);
        }

        return Optional.empty();

    } catch (SQLException error) {

        throw new DAOException(
                "Error al buscar cliente",
                error
        );
    }
}
    @Override
    public boolean existByPhone(String telefono) throws DAOException {
       try {

        Connection con = conexion.getConnection();

        String sql = "SELECT * FROM cliente WHERE telefono = ?";

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, telefono);

        ResultSet rs = ps.executeQuery();

        return rs.next();

    } catch (SQLException error) {

        throw new DAOException(
                "Error al verificar teléfono",
                error
        );
    }
}
    
    @Override
    public void guardar(Cliente cliente) throws DAOException {

    try {
        Connection con = conexion.getConnection();
        String sql = "INSERT INTO cliente(codigo, nombre, telefono) VALUES (?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, cliente.getCodigo());
        ps.setString(2, cliente.getNombre());
        ps.setString(3, cliente.getTelefono());
        
        ps.executeUpdate();

        System.out.println("Cliente recibido: "
                + cliente.getNombre()
                + " - "
                + cliente.getTelefono());

    } catch (SQLException error) {

        throw new DAOException(
                "Error al preparar la consulta",
                error
        );

    }
 }
}
   
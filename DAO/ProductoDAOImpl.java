/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import Config.*;
import java.util.Optional;
import modelo.Producto;
import utilidades.DAOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;

/**
 *
 * @author Dell
 */
public class ProductoDAOImpl implements ProductoDAO {

    private final Conexion conexion;

    public ProductoDAOImpl() {
        this.conexion = Conexion.getInstance();
    }

    @Override
    public Optional<Producto> findByCodigo(String codigo) throws DAOException {

        try {

            Connection con = conexion.getConnection();

            String sql = "SELECT * FROM producto WHERE codigo = ?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, codigo);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                Producto producto = new Producto(
                rs.getString("codigo"),
                rs.getString("nombre"),
                rs.getDouble("precio")

                );

                return Optional.of(producto);
            }

            return Optional.empty();

        } catch (SQLException error) {

            throw new DAOException(
                    "Error al buscar producto",
                    error
            );
        }
    }

    @Override
    public void guardar(Producto producto) throws DAOException {

        try {

            Connection con = conexion.getConnection();

            String sql = "INSERT INTO producto(codigo, nombre, precio) VALUES (?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, producto.getCodigo());
            ps.setString(2, producto.getNombre());
            ps.setDouble(3, producto.getPrecio());

            ps.executeUpdate();

            System.out.println(
                    "Producto recibido: "
                    + producto.getNombre()
                    + " - "
                    + producto.getPrecio()
            );

        } catch (SQLException error) {

            throw new DAOException(
                    "Error al guardar producto",
                    error
            );
        }
    }
    
       
}
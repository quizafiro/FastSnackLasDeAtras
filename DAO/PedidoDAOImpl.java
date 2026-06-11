/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Config.*;
import modelo.Pedido;
import utilidades.DAOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Optional;
/**
 *
 * @author Dell
 */
public class PedidoDAOImpl implements PedidoDAO {

    private final Conexion conexion;

    public PedidoDAOImpl() {
        this.conexion = Conexion.getInstance();
    }

    @Override
    public void guardar(Pedido pedido) throws DAOException {

        try {

            Connection con = conexion.getConnection();

            String sql = "INSERT INTO pedido(cliente, producto, cantidad, total) VALUES (?, ?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, pedido.getCliente());
            ps.setString(2, pedido.getProducto());
            ps.setInt(3, pedido.getCantidad());
            ps.setDouble(4, pedido.calcularTotal());

            ps.executeUpdate();

            System.out.println("Pedido guardado correctamente");

        } catch (SQLException error) {

            throw new DAOException("Error al guardar pedido", error);
        }
    }

    @Override
    public Optional<Pedido> findByCliente(String cliente) throws DAOException {

        // opcional (lo haremos después si quieres)
        return Optional.empty();
    }
}
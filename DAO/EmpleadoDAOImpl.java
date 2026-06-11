/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Config.*;
import java.util.Optional;
import modelo.Empleado;
import utilidades.DAOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
/**
 *
 * @author Dell
 */
public class EmpleadoDAOImpl implements EmpleadoDAO {

    private final Conexion conexion;

    public EmpleadoDAOImpl() {
        this.conexion = Conexion.getInstance();
    }

    @Override
    public void guardar(Empleado empleado) throws DAOException {

        try {

            Connection con = conexion.getConnection();

            String sql = "INSERT INTO empleado(codigo, nombre, cargo) VALUES (?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, empleado.getCodigo());
            ps.setString(2, empleado.getNombre());
            ps.setString(3, empleado.getCargo());

            ps.executeUpdate();

            System.out.println("Empleado guardado: " + empleado.getNombre());

        }catch (SQLException error) {
            error.printStackTrace(); // 👈 IMPORTANTE
            throw new DAOException("Error al guardar empleado: " + error.getMessage(), error);
}
    }

    @Override
    public Optional<Empleado> findByCodigo(String codigo) throws DAOException {

    try {

        Connection con = conexion.getConnection();

        String sql = "SELECT * FROM empleado WHERE codigo = ?";

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, codigo);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {

            Empleado empleado = new Empleado(
                    rs.getString("codigo"),
                    rs.getString("nombre"),
                    rs.getString("cargo")
            );

            return Optional.of(empleado);
        }

        return Optional.empty();

    } catch (SQLException error) {

        throw new DAOException("Error al buscar empleado", error);
    }
}
    public boolean existeCodigo(String codigo) throws DAOException {

    try {

        Connection con = conexion.getConnection();

        String sql = "SELECT * FROM empleado WHERE codigo = ?";

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, codigo);

        ResultSet rs = ps.executeQuery();

        return rs.next();

    } catch (SQLException error) {

        throw new DAOException(
                "Error al verificar código",
                error
        );
    }
}
}

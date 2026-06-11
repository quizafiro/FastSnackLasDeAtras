/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import modelo.Empleado;
import java.util.Optional;
import utilidades.DAOException;

/**
 *
 * @author Dell
 */
public interface EmpleadoDAO {

    void guardar(Empleado empleado) throws DAOException;

    Optional<Empleado> findByCodigo(String codigo) throws DAOException;
}
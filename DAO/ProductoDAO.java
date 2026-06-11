/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import modelo.Producto;
import java.util.Optional;
import utilidades.DAOException;

/**
 *
 * @author Dell
 */
public interface ProductoDAO {
     void guardar(Producto producto) throws DAOException;
    Optional<Producto> findByCodigo(String codigo) throws DAOException;

}

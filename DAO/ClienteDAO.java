/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.util.Optional;
import modelo.Cliente;

/**
 *
 * @author fl1pc24
 */
public interface ClienteDAO {
    Optional<Cliente> findByCodigo(String codigo) throws utilidades.DAOException;
    Optional<Cliente> findByName(String nombre) throws utilidades.DAOException;
    
    boolean existByPhone(String telefono) throws utilidades.DAOException;
    
     void guardar(Cliente cliente)throws utilidades.DAOException;
            
}

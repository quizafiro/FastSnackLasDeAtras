/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import modelo.Pedido;
import java.util.Optional;
import utilidades.DAOException;

/**
 *
 * @author Dell
 */
public interface PedidoDAO {

    void guardar(Pedido pedido) throws DAOException;

    Optional<Pedido> findByCliente(String cliente) throws DAOException;
}
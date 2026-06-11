/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;
import java.time.LocalDateTime;
/**
 *
 * @author fl1pc24
 */
public class Pedido {

    private String cliente;
    private String producto;
    private int cantidad;
    private double precio;

    public Pedido(String cliente, String producto, int cantidad, double precio) {
        this.cliente = cliente;
        this.producto = producto;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public String getCliente() {
        return cliente;
    }

    public String getProducto() {
        return producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public double calcularTotal() {
        return cantidad * precio;
    }
}

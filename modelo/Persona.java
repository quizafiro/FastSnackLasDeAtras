/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author fl1pc24
 */
public abstract class Persona {
    private String nombre;
    private String telefono;
    
    public Persona(String nombre, String telefono) {
        this.nombre = nombre;
        this.telefono = telefono;
    }
    
    public String getNombre() {
    return nombre;
    }

    public void setNombre(String nombre) {
    this.nombre = nombre;
    }

    public String getTelefono() {
    return telefono;
    }

    public void setTelefono(String telefono) {
    this.telefono = telefono;
    }

    abstract void accederCliente();
}

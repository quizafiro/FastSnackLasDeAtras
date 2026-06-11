/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author fl1pc24
 */
public class Cliente extends Persona {

    private String codigo;
    

    public Cliente(String codigo, String nombre, String telefono) {
    super(nombre, telefono);
    this.codigo = codigo;
    }
        

    public String getCodigo() {
    return codigo;
    }

    public void setCodigo(String codigo) {
    this.codigo = codigo;
    }

    @Override
    void accederCliente() {
       System.out.println("Esto es un cliente: "  );  
    }
    
}

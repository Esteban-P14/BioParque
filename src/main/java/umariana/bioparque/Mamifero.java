/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package umariana.bioparque;

/**
 *
 * @author esteb
 */
public class Mamifero extends Animal {

    private String tipoPelaje;

    public Mamifero() {
    }

    public Mamifero(String codigo, String nombre, int edad, double peso,String sexo, String estadoSalud, String estadoInventario,String fechaIngreso, String habitatAsignado, String tipoPelaje) {

        super(codigo, nombre, edad, peso, sexo, estadoSalud, estadoInventario, fechaIngreso, habitatAsignado);

        this.tipoPelaje = tipoPelaje;
    }

    public String getTipoPelaje() {
        return tipoPelaje;
    }

    public void setTipoPelaje(String tipoPelaje) {
        this.tipoPelaje = tipoPelaje;
    }
}

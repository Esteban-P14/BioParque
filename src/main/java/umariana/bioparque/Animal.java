/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package umariana.bioparque;

/**
 *
 * @author esteb
 */
public class Animal {

    private String codigo;
    private String nombre;
    private int edad;
    private double peso;
    private String sexo;
    private String estadoSalud;
    private String estadoInventario;
    private String fechaIngreso;
    private String habitatAsignado;

    public Animal() {
    }

    public Animal(String codigo, String nombre, int edad, double peso,
                  String sexo, String estadoSalud, String estadoInventario,
                  String fechaIngreso, String habitatAsignado) {

        this.codigo = codigo;
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
        this.sexo = sexo;
        this.estadoSalud = estadoSalud;
        this.estadoInventario = estadoInventario;
        this.fechaIngreso = fechaIngreso;
        this.habitatAsignado = habitatAsignado;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public double getPeso() {
        return peso;
    }

    public String getSexo() {
        return sexo;
    }

    public String getEstadoSalud() {
        return estadoSalud;
    }

    public String getEstadoInventario() {
        return estadoInventario;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public String getHabitatAsignado() {
        return habitatAsignado;
    }
}

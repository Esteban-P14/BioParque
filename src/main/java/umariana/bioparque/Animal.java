/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package umariana.bioparque;

/**
 *
 * @author esteb
 */
public abstract class Animal {

    private final String codigo;
    private String nombre;
    private int edad;
    private double peso;
    private String sexo;
    private String estadoSalud;
    private String estadoInventario;
    private final String fechaIngreso;
    private String habitatAsignado;

    public Animal(String codigo, String nombre, int edad, double peso,String sexo, String estadoSalud, String estadoInventario,String fechaIngreso, String habitatAsignado) {

        if (codigo == null || codigo.isBlank()) {
            throw new IllegalArgumentException("El codigo no puede estar vacio.");
        }
        if (edad < 0) {
            throw new IllegalArgumentException("La edad no puede ser negativa.");
        }
        if (peso < 0) {
            throw new IllegalArgumentException("El peso no puede ser negativo.");
        }

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

    public abstract String emitirSonido();

    public String resumenBasico() {
        return "Codigo: " + codigo
                + " | Nombre: " + nombre
                + " | Categoria: " + this.getClass().getSimpleName()
                + " | Estado: " + estadoInventario;
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

    
    public void actualizarPeso(double nuevoPeso) {
        if (nuevoPeso < 0) {
            throw new IllegalArgumentException("El peso no puede ser negativo.");
        }
        this.peso = nuevoPeso;
    }

    public void actualizarEstadoSalud(String nuevoEstadoSalud) {
        if (nuevoEstadoSalud == null || nuevoEstadoSalud.isBlank()) {
            throw new IllegalArgumentException("El estado de salud no puede estar vacio.");
        }
        this.estadoSalud = nuevoEstadoSalud;
    }

    public void trasladarHabitat(String nuevoHabitat) {
        if (nuevoHabitat == null || nuevoHabitat.isBlank()) {
            throw new IllegalArgumentException("El habitat no puede estar vacio.");
        }
        this.habitatAsignado = nuevoHabitat;
    }

    public void ponerEnObservacion() {
        if ("RETIRADO".equalsIgnoreCase(this.estadoInventario)) {
            throw new IllegalStateException("No se puede observar un animal retirado.");
        }
        this.estadoInventario = "EN_OBSERVACION";
    }

    public void retirar() {
        this.estadoInventario = "RETIRADO";
    }
}
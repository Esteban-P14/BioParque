/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package umariana.bioparque;

/**
 *
 * @author esteb
 */
public class Ave extends Animal {

    private double envergadura;

    public Ave() {
    }

    public Ave(String codigo, String nombre, int edad, double peso,
               String sexo, String estadoSalud, String estadoInventario,
               String fechaIngreso, String habitatAsignado,
               double envergadura) {

        super(codigo, nombre, edad, peso, sexo, estadoSalud,
              estadoInventario, fechaIngreso, habitatAsignado);

        this.envergadura = envergadura;
    }

    public double getEnvergadura() {
        return envergadura;
    }

    public void setEnvergadura(double envergadura) {
        this.envergadura = envergadura;
    }
}

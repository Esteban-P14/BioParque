/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package umariana.bioparque;

/**
 *
 * @author esteb
 */
public class Reptil extends Animal {

    private String tipoEscamas;

    public Reptil() {
    }

    public Reptil(String codigo, String nombre, int edad, double peso,
                  String sexo, String estadoSalud, String estadoInventario,
                  String fechaIngreso, String habitatAsignado,
                  String tipoEscamas) {

        super(codigo, nombre, edad, peso, sexo, estadoSalud,
              estadoInventario, fechaIngreso, habitatAsignado);

        this.tipoEscamas = tipoEscamas;
    }

    public String getTipoEscamas() {
        return tipoEscamas;
    }

    public void setTipoEscamas(String tipoEscamas) {
        this.tipoEscamas = tipoEscamas;
    }
}

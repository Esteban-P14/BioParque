/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package umariana.bioparque;

/**
 *
 * @author esteb
 */
import java.util.ArrayList;

public class InventarioAnimales {

    private ArrayList<Animal> misAnimales;

    public InventarioAnimales() {
        this.misAnimales = new ArrayList<>();
    }

    public void registrar(Animal animal) {
        if (existeCodigo(animal.getCodigo())) {
            throw new IllegalArgumentException("Ya existe un animal registrado con el codigo " + animal.getCodigo());
        }
        misAnimales.add(animal);
    }


    public boolean existeCodigo(String codigo) {
        return buscarPorCodigo(codigo) != null;
    }


    public Animal buscarPorCodigo(String codigo) {
        for (Animal a : misAnimales) {
            if (a.getCodigo().equalsIgnoreCase(codigo)) {
                return a;
            }
        }
        return null;
    }


    public ArrayList<Animal> listar() {
        return misAnimales;
    }


    public ArrayList<Animal> filtrarPorCategoria(String categoria) {
        ArrayList<Animal> filtrados = new ArrayList<>();
        for (Animal a : misAnimales) {
            if (a.getClass().getSimpleName().equalsIgnoreCase(categoria)) {
                filtrados.add(a);
            }
        }
        return filtrados;
    }


    public void actualizarPeso(String codigo, double nuevoPeso) {
        Animal animal = buscarPorCodigo(codigo);
        if (animal == null) {
            throw new IllegalArgumentException("No existe un animal con el codigo " + codigo);
        }
        animal.actualizarPeso(nuevoPeso);
    }


    public void trasladarHabitat(String codigo, String nuevoHabitat) {
        Animal animal = buscarPorCodigo(codigo);
        if (animal == null) {
            throw new IllegalArgumentException("No existe un animal con el codigo " + codigo);
        }
        animal.trasladarHabitat(nuevoHabitat);
    }


    public void actualizarEstadoSalud(String codigo, String nuevoEstadoSalud) {
        Animal animal = buscarPorCodigo(codigo);
        if (animal == null) {
            throw new IllegalArgumentException("No existe un animal con el codigo " + codigo);
        }
        animal.actualizarEstadoSalud(nuevoEstadoSalud);
    }


    public void ponerEnObservacion(String codigo) {
        Animal animal = buscarPorCodigo(codigo);
        if (animal == null) {
            throw new IllegalArgumentException("No existe un animal con el codigo " + codigo);
        }
        animal.ponerEnObservacion();
    }


    public void retirar(String codigo) {
        Animal animal = buscarPorCodigo(codigo);
        if (animal == null) {
            throw new IllegalArgumentException("No existe un animal con el codigo " + codigo);
        }
        animal.retirar();
    }


    public int contar() {
        return misAnimales.size();
    }
}
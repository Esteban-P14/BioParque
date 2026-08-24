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
import java.util.LinkedHashMap;
import java.util.Map;

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

 
    public void ejecutarComportamientos() {
        if (misAnimales.isEmpty()) {
            System.out.println("No hay animales registrados para ejecutar comportamientos.");
            return;
        }

        for (Animal animal : misAnimales) {
            System.out.println(animal.resumenBasico());
            System.out.println("Sonido: " + animal.emitirSonido());

            if (animal instanceof Alimentable alimentable) {
                System.out.printf("Racion diaria estimada: %.2f%n", alimentable.calcularRacionDiaria());
            }

            System.out.println("-----------------------------");
        }
    }


    public String generarResumen() {
        if (misAnimales.isEmpty()) {
            return "No hay animales registrados.";
        }

        Map<String, Integer> conteoPorCategoria = new LinkedHashMap<>();
        for (Animal animal : misAnimales) {
            String categoria = animal.getClass().getSimpleName();
            conteoPorCategoria.merge(categoria, 1, Integer::sum);
        }

        StringBuilder resumen = new StringBuilder();
        resumen.append("Total de animales registrados: ").append(misAnimales.size()).append("\n");
        resumen.append("Conteo por categoria:\n");
        for (Map.Entry<String, Integer> entrada : conteoPorCategoria.entrySet()) {
            resumen.append(" - ").append(entrada.getKey()).append(": ").append(entrada.getValue()).append("\n");
        }

        return resumen.toString();
    }
}
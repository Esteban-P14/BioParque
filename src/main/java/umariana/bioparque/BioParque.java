/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package umariana.bioparque;

/**
 *
 * @author esteb
 */

import java.util.ArrayList;
import java.util.Scanner;

public class BioParque {

    public static void main(String[] args) {

        Scanner lector = new Scanner(System.in);

        InventarioAnimales inventario = new InventarioAnimales();
        

        int opcion;

        do {

            System.out.println("====== BIOPARQUE PASTO ======");
            System.out.println("1. Registrar animal");
            System.out.println("2. Listar animales");
            System.out.println("3. Buscar animal por codigo");
            System.out.println("4. Actualizar animal");
            System.out.println("5. Retirar animal");
            System.out.println("6. Filtrar animales por categoria");
            System.out.println("0. Salir");

            opcion = leerEntero(lector, "Seleccione una opcion:");

            switch (opcion) {

                case 1 -> registrarAnimal(lector, inventario);

                case 2 -> listarAnimales(inventario);

                case 3 -> buscarAnimal(lector, inventario);

                case 4 -> actualizarAnimal(lector, inventario);

                case 5 -> retirarAnimal(lector, inventario);

                case 6 -> filtrarAnimales(lector, inventario);

                case 0 -> System.out.println("Usted ha salido del sistema.");

                default -> System.out.println("Opcion no valida.");
            }

        } while (opcion != 0);

        lector.close();
    }

    private static void registrarAnimal(Scanner lector, InventarioAnimales inventario) {

        try {
            System.out.println("Ingrese el codigo:");
            String codigo = lector.nextLine();

            if (inventario.existeCodigo(codigo)) {
                System.out.println("Ya existe un animal registrado con el codigo " + codigo + ". Registro cancelado.");
                return;
            }

            System.out.println("Ingrese el nombre:");
            String nombre = lector.nextLine();

            int edad = leerEntero(lector, "Ingrese la edad:");

            if (edad < 0) {
                System.out.println("La edad no puede ser negativa. Registro cancelado.");
                return;
            }

            double peso = leerDecimal(lector, "Ingrese el peso:");

            if (peso < 0) {
                System.out.println("El peso no puede ser negativo. Registro cancelado.");
                return;
            }

            System.out.println("Ingrese el sexo:");
            String sexo = lector.nextLine();

            System.out.println("Ingrese el estado de salud:");
            String estadoSalud = lector.nextLine();

            System.out.println("Ingrese el estado del inventario (ACTIVO, EN_OBSERVACION, RETIRADO):");
            String estadoInventario = lector.nextLine();

            System.out.println("Ingrese la fecha de ingreso:");
            String fechaIngreso = lector.nextLine();

            System.out.println("Ingrese el habitat:");
            String habitat = lector.nextLine();

            int categoria = leerEntero(lector,"Seleccione la categoria:\n1. Mamifero\n2. Ave\n3. Reptil");

            switch (categoria) {

                case 1 -> {
                    System.out.println("Ingrese el tipo de pelaje:");
                    String tipoPelaje = lector.nextLine();

                    Mamifero mamifero = new Mamifero(codigo, nombre, edad, peso, sexo,estadoSalud, estadoInventario,fechaIngreso, habitat, tipoPelaje);

                    inventario.registrar(mamifero);

                    System.out.println("Mamifero registrado correctamente.");
                }

                case 2 -> {
                    double envergadura = leerDecimal(lector, "Ingrese la envergadura:");

                    Ave ave = new Ave(codigo, nombre, edad, peso, sexo,estadoSalud, estadoInventario, fechaIngreso, habitat, envergadura);

                    inventario.registrar(ave);

                    System.out.println("Ave registrada correctamente.");
                }

                case 3 -> {
                    System.out.println("Ingrese el tipo de escamas:");
                    String tipoEscamas = lector.nextLine();

                    Reptil reptil = new Reptil(codigo, nombre, edad, peso, sexo,estadoSalud, estadoInventario, fechaIngreso, habitat, tipoEscamas);

                    inventario.registrar(reptil);

                    System.out.println("Reptil registrado correctamente.");
                }

                default -> System.out.println("Categoria no valida. No se registro el animal.");
            }

        } catch (IllegalArgumentException e) {
            System.out.println("No se pudo registrar el animal: " + e.getMessage());
        }
    }

    private static void listarAnimales(InventarioAnimales inventario) {

        ArrayList<Animal> misAnimales = inventario.listar();

        if (misAnimales.isEmpty()) {

            System.out.println("No hay animales registrados.");

        } else {

            System.out.println("====== LISTADO DE ANIMALES ======");

            for (Animal a : misAnimales) {
                imprimirAnimal(a);
                System.out.println("-----------------------------");
            }
        }
    }

    private static void buscarAnimal(Scanner lector, InventarioAnimales inventario) {

        System.out.println("Ingrese el codigo del animal que desea buscar:");
        String codigoBuscar = lector.nextLine();

        Animal encontrado = inventario.buscarPorCodigo(codigoBuscar);

        if (encontrado != null) {
            System.out.println("Animal encontrado:");
            imprimirAnimal(encontrado);
        } else {
            System.out.println("No se encontro un animal con ese codigo.");
        }
    }

    private static void actualizarAnimal(Scanner lector, InventarioAnimales inventario) {

        System.out.println("Ingrese el codigo del animal a actualizar:");
        String codigo = lector.nextLine();

        if (!inventario.existeCodigo(codigo)) {
            System.out.println("No existe un animal con ese codigo.");
            return;
        }

        int opcion = leerEntero(lector,"Que desea actualizar?\n1. Peso\n2. Habitat\n3. Estado de salud\n4. Poner en observacion");

        try {
            switch (opcion) {

                case 1 -> {
                    double nuevoPeso = leerDecimal(lector, "Ingrese el nuevo peso:");
                    inventario.actualizarPeso(codigo, nuevoPeso);
                    System.out.println("Peso actualizado correctamente.");
                }

                case 2 -> {
                    System.out.println("Ingrese el nuevo habitat:");
                    String nuevoHabitat = lector.nextLine();
                    inventario.trasladarHabitat(codigo, nuevoHabitat);
                    System.out.println("Habitat actualizado correctamente.");
                }

                case 3 -> {
                    System.out.println("Ingrese el nuevo estado de salud:");
                    String nuevoEstado = lector.nextLine();
                    inventario.actualizarEstadoSalud(codigo, nuevoEstado);
                    System.out.println("Estado de salud actualizado correctamente.");
                }

                case 4 -> {
                    inventario.ponerEnObservacion(codigo);
                    System.out.println("El animal quedo en observacion.");
                }

                default -> System.out.println("Opcion no valida.");
            }
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println("No se pudo actualizar: " + e.getMessage());
        }
    }

    private static void retirarAnimal(Scanner lector, InventarioAnimales inventario) {

        System.out.println("Ingrese el codigo del animal a retirar:");
        String codigo = lector.nextLine();

        try {
            inventario.retirar(codigo);
            System.out.println("El animal quedo en estado RETIRADO.");
        } catch (IllegalArgumentException e) {
            System.out.println("No se pudo retirar: " + e.getMessage());
        }
    }

    private static void filtrarAnimales(Scanner lector, InventarioAnimales inventario) {

        System.out.println("Ingrese la categoria (Mamifero, Ave, Reptil):");
        String categoria = lector.nextLine();

        ArrayList<Animal> filtrados = inventario.filtrarPorCategoria(categoria);

        if (filtrados.isEmpty()) {
            System.out.println("No hay animales de la categoria " + categoria + ".");
        } else {
            System.out.println("====== ANIMALES DE LA CATEGORIA " + categoria.toUpperCase() + " ======");
            for (Animal a : filtrados) {
                System.out.println(a.resumenBasico());
            }
        }
    }

    private static void imprimirAnimal(Animal a) {
        System.out.println("Codigo: " + a.getCodigo());
        System.out.println("Nombre: " + a.getNombre());
        System.out.println("Edad: " + a.getEdad());
        System.out.println("Peso: " + a.getPeso());
        System.out.println("Sexo: " + a.getSexo());
        System.out.println("Estado de salud: " + a.getEstadoSalud());
        System.out.println("Estado inventario: " + a.getEstadoInventario());
        System.out.println("Fecha de ingreso: " + a.getFechaIngreso());
        System.out.println("Habitat: " + a.getHabitatAsignado());
        System.out.println("Sonido: " + a.emitirSonido());
    }

    private static int leerEntero(Scanner lector, String mensaje) {
        int valor;
        while (true) {
            System.out.println(mensaje);
            try {
                valor = Integer.parseInt(lector.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Entrada no valida. Debe ingresar un numero entero.");
            }
        }
        return valor;
    }

    private static double leerDecimal(Scanner lector, String mensaje) {
        double valor;
        while (true) {
            System.out.println(mensaje);
            try {
                valor = Double.parseDouble(lector.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Entrada no valida. Debe ingresar un numero.");
            }
        }
        return valor;
    }
}
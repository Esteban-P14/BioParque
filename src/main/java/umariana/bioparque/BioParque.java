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

        ArrayList<Animal> misAnimales = new ArrayList<>();

        int opcion;

        do {

            System.out.println("====== BIOPARQUE PASTO ======");
            System.out.println("1. Registrar animal");
            System.out.println("2. Listar animales");
            System.out.println("3. Buscar animal por codigo");
            System.out.println("0. Salir");

            opcion = leerEntero(lector, "Seleccione una opcion:");

            switch (opcion) {

                case 1 -> {

                    System.out.println("Ingrese el codigo:");
                    String codigo = lector.nextLine();

                    System.out.println("Ingrese el nombre:");
                    String nombre = lector.nextLine();

                    int edad = leerEntero(lector, "Ingrese la edad:");

                    double peso = leerDecimal(lector, "Ingrese el peso:");

                    System.out.println("Ingrese el sexo:");
                    String sexo = lector.nextLine();

                    System.out.println("Ingrese el estado de salud:");
                    String estadoSalud = lector.nextLine();

                    System.out.println("Ingrese el estado del inventario:");
                    String estadoInventario = lector.nextLine();

                    System.out.println("Ingrese la fecha de ingreso:");
                    String fechaIngreso = lector.nextLine();

                    System.out.println("Ingrese el habitat:");
                    String habitat = lector.nextLine();

                    int categoria = leerEntero(lector,
                            "Seleccione la categoria:\n1. Mamifero\n2. Ave\n3. Reptil");

                    switch (categoria) {

                        case 1 -> {
                            System.out.println("Ingrese el tipo de pelaje:");
                            String tipoPelaje = lector.nextLine();

                            Mamifero mamifero = new Mamifero(
                                    codigo, nombre, edad, peso, sexo,
                                    estadoSalud, estadoInventario,
                                    fechaIngreso, habitat, tipoPelaje
                            );

                            misAnimales.add(mamifero);

                            System.out.println("Mamifero registrado correctamente.");
                        }

                        case 2 -> {
                            double envergadura = leerDecimal(lector, "Ingrese la envergadura:");

                            Ave ave = new Ave (codigo, nombre, edad, peso, sexo,estadoSalud, estadoInventario,fechaIngreso, habitat, envergadura);

                            misAnimales.add(ave);

                            System.out.println("Ave registrada correctamente.");
                        }

                        case 3 -> {
                            System.out.println("Ingrese el tipo de escamas:");
                            String tipoEscamas = lector.nextLine();

                            Reptil reptil = new Reptil (codigo, nombre, edad, peso, sexo, estadoSalud, estadoInventario,fechaIngreso, habitat, tipoEscamas);

                            misAnimales.add(reptil);

                            System.out.println("Reptil registrado correctamente.");
                        }

                        default -> System.out.println("Categoria no valida.");
                    }
                }

                case 2 -> {

                    if (misAnimales.isEmpty()) {

                        System.out.println("No hay animales registrados.");

                    } else {

                        System.out.println("====== LISTADO DE ANIMALES ======");

                        for (Animal a : misAnimales) {

                            System.out.println("Codigo: " + a.getCodigo());
                            System.out.println("Nombre: " + a.getNombre());
                            System.out.println("Edad: " + a.getEdad());
                            System.out.println("Peso: " + a.getPeso());
                            System.out.println("Sexo: " + a.getSexo());
                            System.out.println("Estado de salud: " + a.getEstadoSalud());
                            System.out.println("Estado inventario: " + a.getEstadoInventario());
                            System.out.println("Fecha de ingreso: " + a.getFechaIngreso());
                            System.out.println("Habitat: " + a.getHabitatAsignado());
                            System.out.println("-----------------------------");
                        }
                    }
                }

                case 3 -> {

                    System.out.println("Ingrese el codigo del animal que desea buscar:");
                    String codigoBuscar = lector.nextLine();

                    boolean encontrado = false;

                    for (Animal a : misAnimales) {

                        if (a.getCodigo().equalsIgnoreCase(codigoBuscar)) {

                            System.out.println("Animal encontrado:");
                            System.out.println("Codigo: " + a.getCodigo());
                            System.out.println("Nombre: " + a.getNombre());
                            System.out.println("Edad: " + a.getEdad());
                            System.out.println("Peso: " + a.getPeso());

                            encontrado = true;
                            break;
                        }
                    }

                    if (!encontrado) {
                        System.out.println("No se encontro un animal con ese codigo.");
                    }
                }

                case 0 -> System.out.println("Usted ha salido del sistema.");

                default -> System.out.println("Opcion no valida.");
            }

        } while (opcion != 0);

        lector.close();
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
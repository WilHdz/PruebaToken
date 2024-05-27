import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArbolBinario arbol = new ArbolBinario();
        Scanner scanner = new Scanner(System.in);

        // creamos un arreglos con 5 empleados 3 con direccion y dos sin direccion
        Empleado[] empleadosIniciales = {
            new Empleado("Juan Perez", 123456, "Calle 123"),
            new Empleado("Ana Gomez", 234567, null),
            new Empleado("Luis Martinez", 345678, "Avenida 45"),
            new Empleado("Maria Lopez", 456789, "Boulevard 67"),
            new Empleado("Pedro Sanchez", 567890, null)
        };

        for (Empleado empleados : empleadosIniciales) {
            arbol.agregarEmpleado(empleados);
        }

        while (true) {
            System.out.println("------------------------------------");
            System.out.println("|               Menú               |");
            System.out.println("------------------------------------");
            System.out.println("| 1. Agregar un nuevo empleado      |");
            System.out.println("| 2. Ver empleados con dirección    |");
            System.out.println("| 3. Ver empleados sin dirección    |");
            System.out.println("| 4. Guardar y salir                |");
            System.out.println("------------------------------------");
            System.out.print("Seleccione una opción: ");
            int opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el nombre del empleado:");
                    String nombre = scanner.nextLine();
                    while (nombre.trim().isEmpty()) {
                        System.out.println("Nombre no válido. Ingrese el nombre del empleado:");
                        nombre = scanner.nextLine();
                    }
            
                    System.out.println("Ingrese el número de afiliación (6 dígitos):");
                    int numeroAfiliacion = 0;
                    boolean numeroValido = false;
                    while (!numeroValido) {
                        try {
                            numeroAfiliacion = Integer.parseInt(scanner.nextLine());
                            if (String.valueOf(numeroAfiliacion).length() == 6) {
                                numeroValido = true;
                            } else {
                                System.out.println("El número de afiliación debe tener 6 dígitos. Ingrese nuevamente:");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Número no válido. Ingrese el número de afiliación (6 dígitos):");
                        }
                    }
            
                    System.out.println("Ingrese la dirección (o deje vacío si no tiene):");
                    String direccion = scanner.nextLine();
                    if (direccion.trim().isEmpty()) {
                        direccion = null;
                    }
                    Empleado nuevoEmpleado = new Empleado(nombre, numeroAfiliacion, direccion);
                    arbol.agregarEmpleado(nuevoEmpleado);
                    break;
                case 2:
                    List<Empleado> empleadosConDireccion = arbol.obtenerEmpleadosConDireccion();
                    if (empleadosConDireccion.isEmpty()) {
                        System.out.println("No hay empleados con dirección registrada.");
                    } else {
                        System.out.println("Empleados con dirección registrada:");
                        for (Empleado emp : empleadosConDireccion) {
                            System.out.println(emp.getNombre());
                        }
                    }
                    break;
                case 3:
                    List<Empleado> empleadosSinDireccion = arbol.obtenerEmpleadosSinDireccion();
                    if (empleadosSinDireccion.isEmpty()) {
                        System.out.println("No hay empleados sin dirección registrada.");
                    } else {
                        System.out.println("Empleados sin dirección registrada:");
                        for (Empleado emp : empleadosSinDireccion) {
                            System.out.println(emp.getNombre());
                        }
                    }
                    break;
                case 4:
                    System.out.println("Ingrese el nombre del archivo para guardar la información:");
                    String nombreArchivo = scanner.nextLine();
                    while (nombreArchivo.trim().isEmpty()) {
                        System.out.println("Nombre de archivo no válido. Ingrese el nombre del archivo para guardar la información:");
                        nombreArchivo = scanner.nextLine();
                    }
                    arbol.guardarEnArchivo(nombreArchivo);
                    System.out.println("Información guardada en el archivo. Saliendo del programa.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
            
    }
    }}

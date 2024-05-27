import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class ArbolBinario {
    private Nodo raiz;

    public ArbolBinario() {
        this.raiz = null;
    }

    public void agregarEmpleado(Empleado empleado) {
        if (raiz == null) {
            raiz = new Nodo(empleado);
        } else {
            agregarNodo(raiz, empleado);
        }
    }

    private void agregarNodo(Nodo nodoActual, Empleado empleado) {
        if (empleado.getNumeroAfiliacion() < nodoActual.empleado.getNumeroAfiliacion()) {
            if (nodoActual.izquierdo == null) {
                nodoActual.izquierdo = new Nodo(empleado);
            } else {
                agregarNodo(nodoActual.izquierdo, empleado);
            }
        } else {
            if (nodoActual.derecho == null) {
                nodoActual.derecho = new Nodo(empleado);
            } else {
                agregarNodo(nodoActual.derecho, empleado);
            }
        }
    }


    
    public List<Empleado> obtenerEmpleadosConDireccion() {
        List<Empleado> empleados = new ArrayList<>();
        inordenConDireccion(raiz, empleados);
        return empleados;
    }

    private void inordenConDireccion(Nodo nodo, List<Empleado> empleados) {
        if (nodo != null) {
            inordenConDireccion(nodo.izquierdo, empleados);
            if (nodo.empleado.tieneDireccion()) {
                empleados.add(nodo.empleado);
            }
            inordenConDireccion(nodo.derecho, empleados);
        }
    }

    public List<Empleado> obtenerEmpleadosSinDireccion() {
        List<Empleado> empleados = new ArrayList<>();
        inordenSinDireccion(raiz, empleados);
        return empleados;
    }

    private void inordenSinDireccion(Nodo nodo, List<Empleado> empleados) {
        if (nodo != null) {
            inordenSinDireccion(nodo.izquierdo, empleados);
            if (!nodo.empleado.tieneDireccion()) {
                empleados.add(nodo.empleado);
            }
            inordenSinDireccion(nodo.derecho, empleados);
        }
    }

    // Aqui guardamos los datos para imprimirlos en un txt
public void guardarEnArchivo(String nombreArchivo) {
    if (!nombreArchivo.endsWith(".txt")) {
        nombreArchivo += ".txt";
    }
    
    try (PrintWriter writer = new PrintWriter(new FileWriter(nombreArchivo))) {
        List<Empleado> empleadosConDireccion = obtenerEmpleadosConDireccion();
        List<Empleado> empleadosSinDireccion = obtenerEmpleadosSinDireccion();
        writer.println("|DATOS PERSONALES DE TODOS LOS EMPLEADOS | \n"); 
         writer.println("DATOS DE LOS EMPLEADOS QUE TINEN DIRECCION \n");
        for (Empleado empleado : empleadosConDireccion) {
            writer.println("Nombre: "+empleado.getNombre() + ", "+"Numero de Afiliacion: " + empleado.getNumeroAfiliacion() + ", " +"Direccion: " + empleado.getDireccion()+"\n");
        }
         writer.println(" DATOS DE LOS EMPLEADOS QUE NO TIENEN DIRECCION AUN \n");
        for (Empleado empleado : empleadosSinDireccion) {
            writer.println("Nombre: "+empleado.getNombre() + ", "+"Numero de Afiliacion: " + empleado.getNumeroAfiliacion() + ", "+"Direccion: " + empleado.getDireccion()+"\n");
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}

}



public class Nodo {
    Empleado empleado;
    Nodo izquierdo;
    Nodo derecho;

    Nodo(Empleado empleado) {
        this.empleado = empleado;
        this.izquierdo = null;
        this.derecho = null;
    }
}

public class Empleado {
    private String nombre;
    private int numeroAfiliacion;
    private String direccion;

    public Empleado(String nombre, int numeroAfiliacion, String direccion) {
        this.nombre = nombre;
        this.numeroAfiliacion = numeroAfiliacion;
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNumeroAfiliacion() {
        return numeroAfiliacion;
    }

    public String getDireccion() {
        return direccion;
    }

    public boolean tieneDireccion() {
        return direccion != null && !direccion.isEmpty();
    }
}

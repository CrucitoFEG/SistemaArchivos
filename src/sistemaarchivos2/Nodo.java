
package sistemaarchivos2;

public class Nodo {
    String nombre;
    boolean esDirectorio;
    Nodo izquierdo, derecho;  // Hijo izquierdo e Hijo derecho
    String[] permisos;
    int tamaño; // En KB
    String fechaCreacion;
    String fechaModificacion;

    public Nodo(String nombre, boolean esDirectorio,String[] permisos, int tamaño, String fechaCreacion, String fechaModificacion) {
        this.nombre = nombre;
        this.esDirectorio = esDirectorio;
        this.permisos = permisos;
        this.tamaño = tamaño;
        this.fechaCreacion = fechaCreacion;
        this.fechaModificacion = fechaModificacion;
        this.izquierdo = null;
        this.derecho = null;
    }
    
    public boolean tienePermiso(String permiso) {
        for (String p : permisos) {
            if (p.equals(permiso)) return true;
        }
        return false;
    }

    public void cambiarPermisos(String[] nuevosPermisos) {
        this.permisos = nuevosPermisos;
    }

    public void mostrarPermisos() {
        System.out.println("Permisos de " + nombre + ": " + String.join(", ", permisos));
    }
}

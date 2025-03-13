
package sistemaarchivos2;

/**
 *
 * @author festrada
 */
public class Nodo {
    String nombre;
    boolean esDirectorio;
    Nodo izquierdo;  // Hijo izquierdo
    Nodo derecho;    // Hijo derecho

    public Nodo(String nombre, boolean esDirectorio) {
        this.nombre = nombre;
        this.esDirectorio = esDirectorio;
        this.izquierdo = null;
        this.derecho = null;
    }
}

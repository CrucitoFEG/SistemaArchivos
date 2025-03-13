
package sistemaarchivos2;

/**
 *
 * @author festrada
 */
public class ArbolBinario {
    private Nodo raiz;

    public ArbolBinario() {
        raiz = null;
    }

    // 🔹 Insertar un archivo o directorio en una ubicación específica
    public void insertar(String rutaPadre, String nombre) {
        boolean esDirectorio = !nombre.contains(".");

        if (raiz == null) {
            raiz = new Nodo(nombre, esDirectorio);
        } else {
            Nodo padre = buscarNodo(raiz, rutaPadre);
            if (padre == null || !padre.esDirectorio) {
                throw new IllegalArgumentException("El directorio padre no existe o no es válido.");
            }
            insertarEnNodo(padre, nombre, esDirectorio);
        }
    }

    private Nodo buscarNodo(Nodo nodo, String nombre) {
        if (nodo == null) return null;
        if (nodo.nombre.equals(nombre)) return nodo;

        Nodo izq = buscarNodo(nodo.izquierdo, nombre);
        return (izq != null) ? izq : buscarNodo(nodo.derecho, nombre);
    }

    private void insertarEnNodo(Nodo padre, String nombre, boolean esDirectorio) {
        Nodo nuevo = new Nodo(nombre, esDirectorio);

        if (padre.izquierdo == null) {
            padre.izquierdo = nuevo;
        } else if (padre.derecho == null) {
            padre.derecho = nuevo;
        } else {
            throw new IllegalArgumentException("No se pueden agregar más de 2 elementos en un directorio.");
        }
    }

    // 🔹 Listar el contenido de un directorio
    public void listar(String nombreDirectorio) {
        Nodo directorio = buscarNodo(raiz, nombreDirectorio);
        if (directorio == null || !directorio.esDirectorio) {
            System.out.println("Directorio no encontrado.");
            return;
        }

        System.out.println("Contenido de " + nombreDirectorio + ":");
        if (directorio.izquierdo != null) System.out.println("- " + directorio.izquierdo.nombre);
        if (directorio.derecho != null) System.out.println("- " + directorio.derecho.nombre);
    }

    // 🔹 Buscar un archivo o directorio
    public boolean buscar(String nombre) {
        return buscarNodo(raiz, nombre) != null;
    }

    // 🔹 Eliminar un archivo o directorio
    public void eliminar(String nombre) {
        raiz = eliminarRec(raiz, nombre);
    }

    private Nodo eliminarRec(Nodo nodo, String nombre) {
        if (nodo == null) return null;

        if (nodo.nombre.equals(nombre)) {
            // Verifica si tiene hijos
            if (nodo.izquierdo == null && nodo.derecho == null) {
                return null; // Elimina el nodo si es hoja
            } else {
                throw new IllegalArgumentException("No se puede eliminar un directorio con contenido.");
            }
        }

        nodo.izquierdo = eliminarRec(nodo.izquierdo, nombre);
        nodo.derecho = eliminarRec(nodo.derecho, nombre);

        return nodo;
    }

    // 🔹 Recorrido inorden
    public void inorden() {
        inordenRec(raiz);
        System.out.println();
    }

    private void inordenRec(Nodo nodo) {
        if (nodo != null) {
            inordenRec(nodo.izquierdo);
            System.out.print(nodo.nombre + " ");
            inordenRec(nodo.derecho);
        }
    }

    // 🔹 Recorrido preorden
    public void preorden() {
        preordenRec(raiz);
        System.out.println();
    }

    private void preordenRec(Nodo nodo) {
        if (nodo != null) {
            System.out.print(nodo.nombre + " ");
            preordenRec(nodo.izquierdo);
            preordenRec(nodo.derecho);
        }
    }

    // 🔹 Recorrido postorden
    public void postorden() {
        postordenRec(raiz);
        System.out.println();
    }

    private void postordenRec(Nodo nodo) {
        if (nodo != null) {
            postordenRec(nodo.izquierdo);
            postordenRec(nodo.derecho);
            System.out.print(nodo.nombre + " ");
        }
    }

    // 🔹 Imprimir estructura jerárquica del sistema de archivos
    public void imprimirEstructura() {
        imprimirEstructuraRec(raiz, 0);
    }

    private void imprimirEstructuraRec(Nodo nodo, int nivel) {
        if (nodo != null) {
            imprimirEstructuraRec(nodo.derecho, nivel + 1);
            System.out.println(" ".repeat(nivel * 4) + nodo.nombre);
            imprimirEstructuraRec(nodo.izquierdo, nivel + 1);
        }
    }
}



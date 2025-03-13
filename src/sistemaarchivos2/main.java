
package sistemaarchivos2;

/**
 *
 * @author Grupo1
 */
public class main {

    public static void main(String[] args) {
        ArbolBinario sistema = new ArbolBinario();

        // Crear la raíz del sistema de archivos
        sistema.insertar("", "Raiz");

        // Crear directorios
        sistema.insertar("Raiz", "Documentos");
        sistema.insertar("Raiz", "Fotos");

        // Agregar archivos dentro de Documentos
        sistema.insertar("Documentos", "reporte.txt");
        sistema.insertar("Documentos", "tareas.doc");

        // Agregar archivos dentro de Fotos
        sistema.insertar("Fotos", "vacaciones.jpg");
        sistema.insertar("Fotos", "familia.png");

        // Imprimir la estructura del sistema de archivos
        System.out.println("\n📂 Estructura del Sistema de Archivos:");
        sistema.imprimirEstructura();

//        // Listar contenido de un directorio
//        System.out.println("\n📂 Listar contenido de 'Documentos':");
//        sistema.listar("Documentos");
//
//        // Buscar archivos
//        System.out.println("\n🔍 Buscar 'reporte.txt': " + sistema.buscar("reporte.txt"));
//        System.out.println("🔍 Buscar 'viaje.pdf': " + sistema.buscar("viaje.pdf"));
//
//        // Eliminar un archivo
//        System.out.println("\n🗑️ Eliminando 'tareas.doc'...");
//        sistema.eliminar("tareas.doc");
//        sistema.listar("Documentos");
    }
    
}

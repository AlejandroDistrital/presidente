package herenciaFiguras;

import javax.swing.JOptionPane;
import java.util.Scanner;

/**
 * Clase de prueba para la clase Punto y Conjunto.
 * <p>
 * La clase {@code TestPunto} permite al usuario interactuar con objetos
 * {@link Punto} y la clase {@link Conjunto}. Solicita un nombre al usuario,
 * crea un conjunto de puntos con coordenadas aleatorias, y demuestra
 * operaciones como cálculo de distancias, búsqueda de vecinos y
 * manipulación del conjunto.
 * </p>
 *
 * <p><b>Funcionalidades:</b></p>
 * <ul>
 *   <li>Solicitar nombre al usuario mediante consola</li>
 *   <li>Crear conjunto de puntos con coordenadas aleatorias</li>
 *   <li>Calcular y mostrar distancias entre todos los pares de puntos</li>
 *   <li>Agregar nuevos puntos al conjunto</li>
 *   <li>Eliminar puntos del conjunto por índice</li>
 *   <li>Buscar puntos vecinos dentro de un radio específico</li>
 * </ul>
 *
 * <p><b>Ejemplo de uso:</b></p>
 * <pre>
 *     El programa solicitará:
 *     - Nombre del usuario (por consola)
 *     - Cantidad de puntos a crear (por diálogo)
 *     
 *     Luego mostrará:
 *     - Todos los puntos del conjunto
 *     - Distancias entre cada par de puntos
 *     - Puntos vecinos a una distancia dada
 * </pre>
 *
 * @author @rhashito
 * @version 1.0
 * @since 1.0
 * @see Punto
 * @see Conjunto
 */
public class TestPunto {

    /**
     * Método principal que ejecuta las pruebas de la clase Punto y Conjunto.
     * <p>
     * Este método es el punto de entrada del programa. Solicita al usuario
     * su nombre y la cantidad de puntos a crear. Luego demuestra las
     * funcionalidades de las clases {@link Punto} y {@link Conjunto},
     * incluyendo creación, manipulación y búsqueda de puntos.
     * </p>
     *
     * @param args Argumentos de línea de comandos (no utilizados)
     */
    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);
        System.out.print("\nIngrese el nombre: ");
        String nombre = leer.nextLine();
        System.out.println("\nHola " + nombre);
        leer.close();
    
        System.out.println(ColorConsola.AZUL.getValor() + "Inicio de ejecución del programa.");
        int n = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la cantidad de puntos:", "PUNTOS....", JOptionPane.INFORMATION_MESSAGE));
        Conjunto c = new Conjunto(n);
        System.out.println(c.toString());
        System.out.println("Cantidad de Puntos: " + c.tamanoConjunto());
        c.distanciaConjunto();
        System.out.println("\nPunto en la posición 1 del array: " + c.puntoAt(1));
        System.out.println("Eliminando punto Posición 1:");
        c.removeAt(1);
        System.out.println("Cantidad de Puntos: " + c.tamanoConjunto());
        System.out.println(c.toString());
        c.distanciaConjunto();
        System.out.println("\nPunto en la posición 1 del array: " + c.puntoAt(1));
        System.out.println("Eliminando punto Posición 1:");
        c.removeAt(1);
        System.out.println("Cantidad de Puntos: " + c.tamanoConjunto());
        System.out.println(c.toString());
        c.distanciaConjunto();

        for(int i=n+1; i<n+5; i++){
            c.addPunto(new Punto("punto " + i));
        }
        
        System.out.println(c.toString());
        System.out.println("Cantidad de Puntos: " + c.tamanoConjunto());
    
        System.out.println("Vecinos de " + c.puntoAt(0));
        c.imprimirArreglo(c.vecinos(c.puntoAt(0), 3000));
    }
           
}
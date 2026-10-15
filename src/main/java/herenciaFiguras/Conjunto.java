package herenciaFiguras;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * Clase que representa un conjunto de puntos.
 * <p>
 * La clase {@code Conjunto} proporciona funcionalidad para almacenar y manipular
 * una colección de objetos {@link Punto}. Permite crear puntos con coordenadas
 * aleatorias, calcular distancias entre pares de puntos, buscar puntos vecinos
 * dentro de una distancia dada, y manipular la colección de puntos.
 * </p>
 * <p>
 * Esta clase utiliza un {@link ArrayList} interno para almacenar los puntos,
 * lo que permite un acceso eficiente y redimensionamiento dinámico.
 * </p>
 *
 * <p><b>Ejemplo de uso:</b></p>
 * <pre>
 *     Conjunto conjunto = new Conjunto(5);
 *     conjunto.distanciaConjunto();
 *     ArrayList<Punto> vecinos = conjunto.vecinos(puntoOrigen, 100);
 * </pre>
 *
 * @author @rhashito
 * @version 1.0
 * @since 1.0
 * @see Punto
 * @see ArrayList
 */
public class Conjunto {


    private final ArrayList<Punto> puntos = new ArrayList<>();

    /**
     * Constructor que crea un conjunto con el número especificado de puntos.
     * <p>
     * Crea puntos con coordenadas aleatorias y etiquetas "punto i" donde i
     * es el número secuencial del punto.
     * </p>
     *
     * @param n Número de puntos a crear
     */
    public Conjunto(int n) {
        for (int i = 1; i <= n; i++) {
            puntos.add(new Punto("punto " + i));
        }
    }

    /**
     * Retorna una representación en cadena del conjunto de puntos.
     *
     * @return Cadena con la representación de todos los puntos en el conjunto
     */
    @Override
    public String toString() {
        String a = new String();
        for (Punto x : puntos) {
            a += x.toString() + "\n";
        }
        return a;
    }

    /**
     * Calcula e imprime la distancia entre cada par de puntos del conjunto.
     * <p>
     * Itera sobre todos los pares de puntos y muestra la distancia euclidiana
     * entre ellos en la consola.
     * </p>
     */
    public void distanciaConjunto() {
        for (int i = 0; i < tamanoConjunto() - 1; i++) {
            for (int j = i + 1; j < tamanoConjunto(); j++) {
                System.out.println(
                        "la distancia entre " + puntos.get(i).toString() + " Y "
                        + puntos.get(j).toString() + " es " +
                        ColorConsola.VERDE.getValor() + 
                        puntos.get(i).distanciaEuclides(puntos.get(j)) + 
                        ColorConsola.NEGRO.getValor() 
                );
            }
        }

    }
    
    /**
     * Obtiene el punto en el índice especificado.
     *
     * @param i Índice del punto a obtener
     * @return Punto en el índice especificado, o null si el índice está fuera de rango
     */
    public Punto puntoAt(int i){
        if(i >=0 && i < tamanoConjunto()){
            return this.puntos.get(i);
        }
        else{
            JOptionPane.showMessageDialog(null, "La posición se encuentra fuera del rango válido", "Error en la entrada", JOptionPane.ERROR_MESSAGE);
        }
       return null;
    }

    /**
     * Elimina el punto en el índice especificado.
     *
     * @param i Índice del punto a eliminar
     * @return null (retorno no significativo)
     */
    public String removeAt(int i){
        if(i >=0 && i < tamanoConjunto()){
            this.puntos.remove(i);
        }
        else{
            JOptionPane.showMessageDialog(null, "La posición se encuentra fuera del rango válido", "Error en la entrada", JOptionPane.ERROR_MESSAGE);
        }
       return null;
    }
     
     /**
      * Agrega un nuevo punto al conjunto.
      *
      * @param nuevo Punto a agregar
      */
     public void addPunto(Punto nuevo){
         this.puntos.add(nuevo);
     }
     
     /**
      * Obtiene el tamaño del conjunto.
      *
      * @return Número de puntos en el conjunto
      */
    public int tamanoConjunto(){
         return this.puntos.size();
     }
    
    /**
     * Obtiene los puntos vecinos a un punto de origen dentro de una distancia especificada.
     * <p>
     * Itera sobre todos los puntos del conjunto (excepto el punto de origen) y
     * retorna aquellos cuya distancia euclidiana al origen sea menor o igual a
     * la distancia especificada.
     * </p>
     *
     * @param origen Punto de origen para calcular las distancias
     * @param distancia Distancia máxima para considerar un punto como vecino
     * @return Lista de puntos vecinos dentro de la distancia especificada
     */
    public ArrayList<Punto> vecinos(Punto origen, int distancia){
        ArrayList<Punto> vecindad = new ArrayList<>();
        for( Punto otro: puntos){
            if(!origen.equals(otro)){
                if(origen.distanciaEuclides(otro) <= distancia){
                    vecindad.add(otro);
                }
            }
        }
        return vecindad;
    }
    
    /**
     * Imprime en consola los puntos de un ArrayList.
     *
     * @param x ArrayList de puntos a imprimir
     */
    public void imprimirArreglo(ArrayList<Punto> x){
        for(Punto p: x){
            System.out.println(p);
        }
    }
    /* 
     // Esta acción no esta permitida por el modificador final del arrayList
     public void removePuntos(){
      this.puntos =  new ArrayList<>();
     }
   */
}

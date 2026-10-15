package herenciaFiguras;

import java.util.Random;

/**
 * Clase que representa un punto bidimensional en el sistema de coordenadas cartesianas.
 * <p>
 * La clase {@code Punto} encapsula las coordenadas X e Y de un punto, así como una etiqueta
 * identificadora. Proporciona métodos para manipular las coordenadas, calcular distancias
 * euclidianas entre puntos, y realizar translaciones en el plano cartesiano.
 * </p>
 * <p>
 * Esta clase utiliza el patrón de diseño con métodos getters y setters para garantizar
 * el encapsulamiento de los datos. Los valores de coordenadas son almacenados como
 * enteros, permitiendo representar posiciones exactas en el plano.
 * </p>
 *
 * <p><b>Ejemplo de uso:</b></p>
 * <pre>
 *     Punto p1 = new Punto(10, 20, "Punto A");
 *     Punto p2 = new Punto();
 *     double distancia = p1.distanciaEuclides(p2);
 * </pre>
 *
 * @author @rhashito
 * @version 1.0
 * @since 1.0
 */
public class Punto {

    private int x;
    private int y;
    private String etiqueta;

    // Constructors

    /**
     * Constructor que crea un punto con las coordenadas y etiqueta especificadas.
     * <p>
     * Este constructor permite especificar todos los atributos del punto:
     * coordenadas X e Y, y una etiqueta identificadora.
     * </p>
     *
     * @param a Coordenada X del punto
     * @param b Coordenada Y del punto
     * @param c Etiqueta identificadora del punto
     */
    public Punto(int a, int b, String c) {
        setX(a);
        setY(b);
        setEtiqueta(c);
    }

    /**
     * Constructor predeterminado que crea un punto en el origen (0, 0)
     * con la etiqueta "origen".
     */
    public Punto() {
        this(0, 0, "origen");
    }

    /**
     * Constructor que crea un punto con coordenadas aleatorias y la etiqueta especificada.
     * <p>
     * Las coordenadas se generan utilizando un generador de números aleatorios
     * con una semilla basada en el tiempo del sistema.
     * </p>
     *
     * @param etiqueta Etiqueta identificadora del punto
     */
    private static final int RANGO_COORDENADAS = 10000;

    public Punto(String etiqueta) {
        Random r = new Random(System.nanoTime());
        setX(r.nextInt(RANGO_COORDENADAS));
        setY(r.nextInt(RANGO_COORDENADAS));
        setEtiqueta(etiqueta);
    }

    // Métodos de acceso y modificación

    /**
     * Establece la coordenada X del punto.
     *
     * @param a Nueva coordenada X
     */
    public final void setX(int a) {
        x = a;
    }

    /**
     * Establece la coordenada Y del punto.
     *
     * @param a Nueva coordenada Y
     */
    public final void setY(int a) {
        y = a;
    }

    /**
     * Establece la etiqueta del punto.
     *
     * @param a Nueva etiqueta
     */
    public final void setEtiqueta(String a) {
        etiqueta = a;
    }

    /**
     * Obtiene la coordenada X del punto.
     *
     * @return Coordenada X del punto
     */
    public int getX() {
        return x;
    }

    /**
     * Obtiene la coordenada Y del punto.
     *
     * @return Coordenada Y del punto
     */
    public int getY() {
        return y;
    }

    /**
     * Obtiene la etiqueta del punto.
     *
     * @return Etiqueta del punto
     */
    public String getEtiqueta() {
        return etiqueta;
    }

    /**
     * Calcula la distancia euclidiana entre este punto y otro.
     * <p>
     * La distancia euclidiana se calcula utilizando la fórmula:
     * d = √((x₂-x₁)² + (y₂-y₁)²)
     * </p>
     *
     * @param p2 Punto con el cual se calculará la distancia
     * @return Distancia euclidiana entre los dos puntos
     */
    public double distanciaEuclides(Punto p2) {
        return (Math.sqrt((getX() - p2.getX()) * ((getX() - p2.getX()))
                + (getY() - p2.getY()) * (getY() - p2.getY())));
    }

    /**
     * Retorna una representación en cadena del punto.
     * <p>
     * La cadena incluye la etiqueta y las coordenadas del punto,
     * formateadas con colores ANSI para consola.
     * </p>
     *
     * @return Representación en cadena del punto
     */
    @Override
    public String toString() {
        return ColorConsola.ROJO.getValor() + 
               getEtiqueta() + 
               ColorConsola.NEGRO.getValor() + 
               ColorConsola.AZUL.getValor() + 
               " [" + 
               ColorConsola.NEGRO.getValor() + 
               getX() + 
               ColorConsola.ROJO.getValor() + 
               ","  +
               ColorConsola.NEGRO.getValor() + 
               getY() + 
               ColorConsola.AZUL.getValor() + 
               "]" + 
               ColorConsola.NEGRO.getValor();
    }

    /**
     * Translada el punto a lo largo del eje X por la cantidad especificada.
     *
     * @param x Cantidad a transladar en el eje X
     */
    public void trasladarX(int x) {
        this.x += x;
    }

    /**
     * Translada el punto a lo largo del eje Y por la cantidad especificada.
     *
     * @param y Cantidad a transladar en el eje Y
     */
    public void trasladarY(int y) {
        this.y += y;
    }

    /**
     * Translada el punto por las cantidades especificadas a lo largo de ambos ejes.
     *
     * @param x Cantidad a transladar en el eje X
     * @param y Cantidad a transladar en el eje Y
     */
    public void trasladar(int x, int y) {
        trasladarX(x);
        trasladarY(y);
    }

    
    /**
     * Compara este punto con otro para determinar si son iguales.
     * <p>
     * Dos puntos se consideran iguales si sus coordenadas X e Y son iguales
     * y sus etiquetas son iguales.
     * </p>
     *
     * @param otro Punto con el cual comparar
     * @return true si los puntos son iguales, false en caso contrario
     */
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Punto otro = (Punto) obj;
        return this.getX() == otro.getX() && 
               this.getY() == otro.getY() &&
               this.getEtiqueta().equals(otro.getEtiqueta());
    }
    
    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        result = 31 * result + (etiqueta != null ? etiqueta.hashCode() : 0);
        return result;
    }
    
    /**
     * Verifica si el punto actual está en la misma línea vertical que el punto dado.
     * <p>
     * Dos puntos están en la misma línea vertical cuando tienen la misma coordenada X.
     * </p>
     *
     * @param otro Punto con el cual comparar
     * @return true si los puntos están en la misma línea vertical, false en caso contrario
     */
    public boolean enLineaCoordenadaX(Punto otro){
       return this.getX() == otro.getX();
    }
    
    /**
     * Verifica si el punto actual está en la misma línea horizontal que el punto dado.
     * <p>
     * Dos puntos están en la misma línea horizontal cuando tienen la misma coordenada Y.
     * </p>
     *
     * @param otro Punto con el cual comparar
     * @return true si los puntos están en la misma línea horizontal, false en caso contrario
     */
    public boolean enLineaCoordenadaY(Punto otro){
       return this.getY() == otro.getY();
    }
    
}

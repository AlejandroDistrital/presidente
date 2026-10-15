package herenciaFiguras;

/**
 * Clase que representa una línea en el sistema geométrico.
 * <p>
 * La clase {@code Linea} extiende {@link Geometria} y representa una línea
 * definida por dos puntos (p1 y p2). Proporciona métodos para calcular el perímetro
 * (que equivale a la longitud de la línea) y el área (que siempre es 0 para una línea).
 * </p>
 * <p>
 * El perímetro se calcula como la distancia euclidiana entre los dos puntos.<br>
 * El área siempre es 0 ya que una línea no tiene área.
 * </p>
 *
 * <p><b>Ejemplo de uso:</b></p>
 * <pre>
 *     Punto p1 = new Punto(0, 0, "Inicio");
 *     Punto p2 = new Punto(5, 5, "Fin");
 *     Linea l = new Linea(p1, p2);
 *     double longitud = l.perimetro();
 * </pre>
 *
 * @author @rhashito
 * @version 1.0
 * @since 1.0
 * @see Geometria
 * @see Punto
 */
public class Linea extends Geometria {
    private Punto p1, p2;

    /**
     * Constructor que crea una línea con los dos puntos especificados.
     *
     * @param p1 Punto inicial de la línea
     * @param p2 Punto final de la línea
     */
    public Linea(Punto p1, Punto p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    /**
     * Constructor predeterminado que crea una línea con valores por defecto.
     * <p>
     * La línea se inicializa con puntos en (0,0) y (1,1).
     * </p>
     */
    public Linea() {
        this(new Punto(0, 0, "P1"), new Punto(1, 1, "P2"));
    }

    /**
     * Calcula el perímetro de la línea.
     * <p>
     * Para una línea, el perímetro equivale a su longitud, calculada
     * como la distancia euclidiana entre los dos puntos.
     * </p>
     *
     * @return Longitud de la línea
     */
    @Override
    public double perimetro() {
        return longitud();
    }

    /**
     * Calcula el área de la línea.
     * <p>
     * Una línea no tiene área, por lo que siempre retorna 0.
     * </p>
     *
     * @return Área de la línea (siempre 0)
     */
    @Override
    public double area() {
        return 0;
    }

    /**
     * Calcula la longitud de la línea.
     * <p>
     * La longitud se calcula como la distancia euclidiana entre los dos puntos.
     * </p>
     *
     * @return Longitud de la línea
     */
    public double longitud() {
        return p1.distanciaEuclides(p2);
    }

    /**
     * Obtiene el punto inicial de la línea.
     *
     * @return Punto inicial de la línea
     */
    public Punto getP1() {
        return p1;
    }

    /**
     * Obtiene el punto final de la línea.
     *
     * @return Punto final de la línea
     */
    public Punto getP2() {
        return p2;
    }
}

package herenciaFiguras;

/**
 * Clase que representa una elipse en el sistema geométrico.
 * <p>
 * La clase {@code Elipse} extiende {@link Geometria} y representa una elipse
 * definida por su centro y los radios en los ejes X e Y. Proporciona métodos
 * para calcular el perímetro (usando una aproximación) y el área de la elipse.
 * </p>
 * <p>
 * El perímetro se calcula usando una aproximación: 2π√((rx² + ry²)/2)<br>
 * El área se calcula como: π * rx * ry
 * </p>
 *
 * <p><b>Ejemplo de uso:</b></p>
 * <pre>
 *     Punto centro = new Punto(0, 0, "Centro");
 *     Elipse e = new Elipse(centro, 5.0, 3.0);
 *     double perimetro = e.perimetro();
 *     double area = e.area();
 * </pre>
 *
 * @author @rhashito
 * @version 1.0
 * @since 1.0
 * @see Geometria
 * @see Punto
 */
public class Elipse extends Geometria {
    private Punto centro;
    private double radioX, radioY;

    /**
     * Constructor que crea una elipse con el centro y radios especificados.
     *
     * @param centro Punto centro de la elipse
     * @param radioX Radio de la elipse en el eje X
     * @param radioY Radio de la elipse en el eje Y
     */
    public Elipse(Punto centro, double radioX, double radioY) {
        this.centro = centro;
        this.radioX = radioX;
        this.radioY = radioY;
    }

    /**
     * Constructor predeterminado que crea una elipse unitaria con valores por defecto.
     * <p>
     * La elipse se inicializa con centro en (0,0) y radios X e Y iguales a 1.0.
     * </p>
     */
    public Elipse() {
        this(new Punto(0, 0, "Centro"), 1.0, 1.0);
    }

    /**
     * Calcula el perímetro de la elipse.
     * <p>
     * Se utiliza una aproximación del perímetro de la elipse:
     * 2π√((rx² + ry²)/2)
     * </p>
     *
     * @return Perímetro aproximado de la elipse
     */
    @Override
    public double perimetro() {
        return 2 * Math.PI * Math.sqrt((radioX * radioX + radioY * radioY) / 2);
    }

    /**
     * Calcula el área de la elipse.
     * <p>
     * El área se calcula como: π * radioX * radioY
     * </p>
     *
     * @return Área de la elipse
     */
    @Override
    public double area() {
        return Math.PI * radioX * radioY;
    }

    /**
     * Obtiene el punto centro de la elipse.
     *
     * @return Punto centro de la elipse
     */
    public Punto getCentro() {
        return centro;
    }

    /**
     * Obtiene el radio de la elipse en el eje X.
     *
     * @return Radio en el eje X
     */
    public double getRadioX() {
        return radioX;
    }

    /**
     * Obtiene el radio de la elipse en el eje Y.
     *
     * @return Radio en el eje Y
     */
    public double getRadioY() {
        return radioY;
    }
}

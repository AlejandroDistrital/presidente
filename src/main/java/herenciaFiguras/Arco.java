package herenciaFiguras;

/**
 * Clase que representa un arco en el sistema geométrico.
 * <p>
 * La clase {@code Arco} extiende {@link Geometria} y representa un arco
 * (porción de una elipse) definido por su centro, radios en los ejes X e Y,
 * y los ángulos inicial y final. Proporciona métodos para calcular el perímetro
 * y el área del arco.
 * </p>
 * <p>
 * El perímetro se calcula proporcional al ángulo abarcado:<br>
 * (ángulo / 360) * 2π√((rx² + ry²)/2)<br>
 * El área se calcula proporcional al ángulo abarcado:<br>
 * (ángulo / 360) * π * rx * ry
 * </p>
 *
 * <p><b>Ejemplo de uso:</b></p>
 * <pre>
 *     Punto centro = new Punto(0, 0, "Centro");
 *     Arco arco = new Arco(centro, 10.0, 10.0, 0, 90);
 *     double perimetro = arco.perimetro();
 *     double area = arco.area();
 * </pre>
 *
 * @author @rhashito
 * @version 1.0
 * @since 1.0
 * @see Geometria
 * @see Punto
 */
public class Arco extends Geometria {
    private Punto centro;
    private double radioX, radioY;
    private double anguloInicial, anguloFinal;

    /**
     * Constructor que crea un arco con los parámetros especificados.
     *
     * @param centro Punto centro del arco
     * @param radioX Radio del arco en el eje X
     * @param radioY Radio del arco en el eje Y
     * @param anguloInicial Ángulo inicial del arco en grados
     * @param anguloFinal Ángulo final del arco en grados
     */
    public Arco(Punto centro, double radioX, double radioY, double anguloInicial, double anguloFinal) {
        this.centro = centro;
        this.radioX = radioX;
        this.radioY = radioY;
        this.anguloInicial = anguloInicial;
        this.anguloFinal = anguloFinal;
    }

    /**
     * Constructor predeterminado que crea un arco con valores por defecto.
     * <p>
     * El arco se inicializa con centro en (0,0), radios de 50, y ángulos de 0 a 90 grados.
     * </p>
     */
    public Arco() {
        this(new Punto(0, 0, "Centro"), 50, 50, 0, 90);
    }

    /**
     * Calcula el perímetro del arco.
     * <p>
     * El perímetro se calcula proporcional al ángulo abarcado:
     * (ángulo / 360) * 2π√((rx² + ry²)/2)
     * </p>
     *
     * @return Perímetro del arco
     */
    @Override
    public double perimetro() {
        double diff = Math.abs(anguloFinal - anguloInicial);
        return (diff / 360) * 2 * Math.PI * Math.sqrt((radioX * radioX + radioY * radioY) / 2);
    }

    /**
     * Calcula el área del arco.
     * <p>
     * El área se calcula proporcional al ángulo abarcado:
     * (ángulo / 360) * π * rx * ry
     * </p>
     *
     * @return Área del arco
     */
    @Override
    public double area() {
        double diff = Math.abs(anguloFinal - anguloInicial);
        return (diff / 360) * Math.PI * radioX * radioY;
    }

    /**
     * Obtiene el punto centro del arco.
     *
     * @return Punto centro del arco
     */
    public Punto getCentro() {
        return centro;
    }

    /**
     * Obtiene el radio del arco en el eje X.
     *
     * @return Radio en el eje X
     */
    public double getRadioX() {
        return radioX;
    }

    /**
     * Obtiene el radio del arco en el eje Y.
     *
     * @return Radio en el eje Y
     */
    public double getRadioY() {
        return radioY;
    }

    /**
     * Obtiene el ángulo inicial del arco.
     *
     * @return Ángulo inicial en grados
     */
    public double getAnguloInicial() {
        return anguloInicial;
    }

    /**
     * Obtiene el ángulo final del arco.
     *
     * @return Ángulo final en grados
     */
    public double getAnguloFinal() {
        return anguloFinal;
    }
}

package herenciaFiguras;

/**
 * Clase que representa un rectángulo en el sistema geométrico.
 * <p>
 * La clase {@code Rectangulo} extiende {@link Geometria} y representa un rectángulo
 * definido por dos puntos diagonalmente opuestos (p1 y p2). Proporciona métodos
 * para calcular el perímetro y el área del rectángulo.
 * </p>
 * <p>
 * El perímetro se calcula como: 2 * (|x₂-x₁| + |y₂-y₁|)<br>
 * El área se calcula como: |x₂-x₁| * |y₂-y₁|
 * </p>
 * <p>
 * El constructor valida que los dos puntos no sean iguales ni estén en la misma
 * línea (ni horizontal ni vertical), ya que en ese caso no se formaría un rectángulo válido.
 * </p>
 *
 * <p><b>Ejemplo de uso:</b></p>
 * <pre>
 *     Punto p1 = new Punto(0, 0, "Esquina1");
 *     Punto p2 = new Punto(10, 5, "Esquina2");
 *     Rectangulo r = new Rectangulo(p1, p2);
 *     double perimetro = r.perimetro();
 *     double area = r.area();
 * </pre>
 *
 * @author @rhashito
 * @version 1.0
 * @since 1.0
 * @see Geometria
 * @see Punto
 */
public class Rectangulo extends Geometria {

    private static final int DEFAULT_X1 = 0;
    private static final int DEFAULT_Y1 = 0;
    private static final int DEFAULT_X2 = 1;
    private static final int DEFAULT_Y2 = 2;
    private Punto p1;
    private Punto p2;

    public Rectangulo(Punto p1, Punto p2) {
        if (p1.equals(p2) || p1.enLineaCoordenadaX(p2) || p1.enLineaCoordenadaY(p2)) {
            this.p1 = new Punto(DEFAULT_X1, DEFAULT_Y1, "Punto 1");
            this.p2 = new Punto(DEFAULT_X2, DEFAULT_Y2, "Punto 2");
        } else {
            this.p1 = p1;
            this.p2 = p2;
        }
    }

    /**
     * Constructor predeterminado que crea un rectángulo con valores por defecto.
     * <p>
     * El rectángulo se inicializa con puntos en (0,0) y (1,2).
     * </p>
     */
    public Rectangulo() {
        this(new Punto(0, 0, "Punto 1"), new Punto(1, 2, "Punto 2"));
    }

    /**
     * Calcula el perímetro del rectángulo.
     * <p>
     * El perímetro se calcula como: 2 * (ancho + alto)
     * </p>
     *
     * @return Perímetro del rectángulo
     */
    @Override
    public double perimetro() {
        return 2.0 * (Math.abs(this.p1.getX() - this.p2.getX()) + Math.abs(this.p1.getY() - this.p2.getY()));
    }

    /**
     * Calcula el área del rectángulo.
     * <p>
     * El área se calcula como: ancho * alto
     * </p>
     *
     * @return Área del rectángulo
     */
    @Override
    public double area() {
        return (Math.abs(this.p1.getX() - this.p2.getX()) * Math.abs(this.p1.getY() - this.p2.getY()));
    }

    /**
     * Obtiene el primer punto del rectángulo.
     *
     * @return Primer punto diagonalmente opuesto
     */
    public Punto getP1() {
        return p1;
    }

    /**
     * Establece el primer punto del rectángulo.
     *
     * @param p1 Nuevo primer punto diagonalmente opuesto
     */
    public void setP1(Punto p1) {
        this.p1 = p1;
    }

    /**
     * Obtiene el segundo punto del rectángulo.
     *
     * @return Segundo punto diagonalmente opuesto
     */
    public Punto getP2() {
        return p2;
    }

    /**
     * Establece el segundo punto del rectángulo.
     *
     * @param p2 Nuevo segundo punto diagonalmente opuesto
     */
    public void setP2(Punto p2) {
        this.p2 = p2;
    }

}

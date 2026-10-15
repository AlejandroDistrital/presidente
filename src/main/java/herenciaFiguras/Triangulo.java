package herenciaFiguras;

/**
 * Clase que representa un triángulo en el sistema geométrico.
 * <p>
 * La clase {@code Triangulo} extiende {@link Geometria} y representa un triángulo
 * definido por tres puntos (vértices). Proporciona métodos para calcular el perímetro
 * utilizando la distancia euclidiana entre los vértices, y el área utilizando la
 * fórmula de Herón.
 * </p>
 * <p>
 * El perímetro se calcula como la suma de las distancias entre los tres vértices.<br>
 * El área se calcula utilizando la fórmula de Herón: √(s(s-a)(s-b)(s-c)), donde
 * s = (a + b + c) / 2 es el semiperímetro.
 * </p>
 *
 * <p><b>Ejemplo de uso:</b></p>
 * <pre>
 *     Punto p1 = new Punto(0, 0, "V1");
 *     Punto p2 = new Punto(3, 0, "V2");
 *     Punto p3 = new Punto(0, 4, "V3");
 *     Triangulo t = new Triangulo(p1, p2, p3);
 *     double perimetro = t.perimetro();
 *     double area = t.area();
 * </pre>
 *
 * @author @rhashito
 * @version 1.0
 * @since 1.0
 * @see Geometria
 * @see Punto
 */
public class Triangulo extends Geometria {
    private Punto p1, p2, p3;

    /**
     * Constructor que crea un triángulo con los tres vértices especificados.
     *
     * @param p1 Primer vértice del triángulo
     * @param p2 Segundo vértice del triángulo
     * @param p3 Tercer vértice del triángulo
     */
    public Triangulo(Punto p1, Punto p2, Punto p3) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }

    /**
     * Constructor predeterminado que crea un triángulo rectángulo con valores por defecto.
     * <p>
     * El triángulo se inicializa con vértices en (0,0), (3,0) y (0,4), formando
     * un triángulo rectángulo con lados de longitud 3, 4 y 5.
     * </p>
     */
    public Triangulo() {
        this(new Punto(0, 0, "P1"), new Punto(3, 0, "P2"), new Punto(0, 4, "P3"));
    }

    /**
     * Calcula el perímetro del triángulo.
     * <p>
     * El perímetro se calcula como la suma de las distancias euclidianas
     * entre los tres vértices del triángulo.
     * </p>
     *
     * @return Perímetro del triángulo
     */
    @Override
    public double perimetro() {
        return p1.distanciaEuclides(p2) + p2.distanciaEuclides(p3) + p3.distanciaEuclides(p1);
    }

    /**
     * Calcula el área del triángulo utilizando la fórmula de Herón.
     * <p>
     * Se calculan las longitudes de los tres lados (a, b, c) y se aplica
     * la fórmula de Herón: √(s(s-a)(s-b)(s-c)), donde s = (a+b+c)/2
     * </p>
     *
     * @return Área del triángulo
     */
    @Override
    public double area() {
        double a = p1.distanciaEuclides(p2);
        double b = p2.distanciaEuclides(p3);
        double c = p3.distanciaEuclides(p1);
        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    /**
     * Obtiene el primer vértice del triángulo.
     *
     * @return Primer vértice del triángulo
     */
    public Punto getP1() {
        return p1;
    }

    /**
     * Obtiene el segundo vértice del triángulo.
     *
     * @return Segundo vértice del triángulo
     */
    public Punto getP2() {
        return p2;
    }

    /**
     * Obtiene el tercer vértice del triángulo.
     *
     * @return Tercer vértice del triángulo
     */
    public Punto getP3() {
        return p3;
    }
}

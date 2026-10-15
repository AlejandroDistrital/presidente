package herenciaFiguras;

/**
 * Clase que representa un círculo en el sistema geométrico.
 * <p>
 * La clase {@code Circulo} extiende {@link Geometria} y proporciona métodos para
 * calcular el perímetro y el área del círculo. Un círculo se define por su centro
 * (un punto) y su radio.
 * </p>
 * <p>
 * El perímetro de un círculo se calcula como: 2πr<br>
 * El área de un círculo se calcula como: πr²
 * </p>
 *
 * <p><b>Ejemplo de uso:</b></p>
 * <pre>
 *     Punto centro = new Punto(10, 10, "Centro");
 *     Circulo c = new Circulo(centro, 5.0);
 *     double perimetro = c.perimetro();
 *     double area = c.area();
 * </pre>
 *
 * @author @rhashito
 * @version 1.0
 * @since 1.0
 * @see Geometria
 * @see Punto
 */
public class Circulo extends Geometria {
    
    private Punto centro;
    private double radio;
    
    public Circulo(Punto centro, double radio) {
        this.centro = centro;
        this.radio = radio;
    }

    /**
     * Constructor que crea un círculo con el radio especificado y centro en el origen.
     *
     * @param r Radio del círculo
     */
    public Circulo(double r) {
        this(new Punto(0,0, "origen"), r);
    }

    /**
     * Constructor de copia que crea un círculo como copia de otro.
     *
     * @param c Círculo a copiar
     */
    public Circulo(Circulo c) {
        this(new Punto(c.getCentro().getX(), c.getCentro().getY(), c.getCentro().getEtiqueta()), c.getRadio());
    }

    /**
     * Constructor predeterminado que crea un círculo con centro en el origen
     * y radio 1.0.
     */
    public Circulo() {
         this(new Punto(0,0, "origen"), 1.0);
    }

    /**
     * Calcula el perímetro del círculo.
     * <p>
     * El perímetro se calcula mediante la fórmula: 2πr
     * </p>
     *
     * @return Perímetro del círculo
     */
    @Override
    public double perimetro() {
        return 2.0 * Math.PI * getRadio();
    }

    /**
     * Calcula el área del círculo.
     * <p>
     * El área se calcula mediante la fórmula: πr²
     * </p>
     *
     * @return Área del círculo
     */
    @Override
    public double area() {
        return Math.PI * Math.pow(getRadio(),2);
    }

    /**
     * Compara este círculo con otro y retorna el de mayor radio.
     *
     * @param c Círculo a comparar
     * @return El círculo con mayor radio (this o c)
     */
    public Circulo elMayor(Circulo c) {
        if (this.getRadio() >= c.getRadio()) {
            return this;
        } else {
            return c;
        }
    }
    
    /**
     * Compara dos círculos y retorna el de mayor radio (método estático).
     *
     * @param c Primer círculo a comparar
     * @param d Segundo círculo a comparar
     * @return El círculo con mayor radio (c o d)
     */
    public static Circulo elMayor(Circulo c, Circulo d) {
        if (c.getRadio()>=d.getRadio()) return c; else return d;
    }
    
    /**
     * Obtiene el punto centro del círculo.
     *
     * @return Punto centro del círculo
     */
    public Punto getCentro() {
        return centro;
    }

    /**
     * Establece el punto centro del círculo.
     *
     * @param centro Nuevo punto centro del círculo
     */
    public void setCentro(Punto centro) {
        this.centro = centro;
    }

    /**
     * Obtiene el radio del círculo.
     *
     * @return Radio del círculo
     */
    public double getRadio() {
        return radio;
    }

    /**
     * Establece el radio del círculo.
     *
     * @param radio Nuevo radio del círculo
     */
    public void setRadio(double radio) {
        this.radio = radio;
    }

} 
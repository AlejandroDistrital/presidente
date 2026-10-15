package herenciaFiguras;

import java.awt.Color;
import java.awt.Graphics2D;

/**
 * Clase que representa un triángulo gráfico con color.
 * <p>
 * La clase {@code TrianguloGrafico} extiende {@link Triangulo} e implementa {@link Dibujable},
 * permitiendo dibujar un triángulo en un contexto gráfico. Además de las propiedades
 * heredadas de {@code Triangulo} (tres vértices), incluye un color para el dibujo.
 * </p>
 * <p>
 * Esta clase dibuja el contorno del triángulo utilizando el método {@code drawPolygon}
 * de {@link Graphics2D}.
 * </p>
 *
 * <p><b>Ejemplo de uso:</b></p>
 * <pre>
 *     Punto p1 = new Punto(100, 100, "V1");
 *     Punto p2 = new Punto(150, 50, "V2");
 *     Punto p3 = new Punto(200, 100, "V3");
 *     Color color = Color.GREEN;
 *     TrianguloGrafico tg = new TrianguloGrafico(p1, p2, p3, color);
 *     tg.dibujar(g2d);
 * </pre>
 *
 * @author @rhashito
 * @version 1.0
 * @since 1.0
 * @see Triangulo
 * @see Dibujable
 * @see Color
 * @see Graphics2D
 */
class TrianguloGrafico extends Triangulo implements Dibujable {
    private Color color;

    /**
     * Constructor que crea un triángulo gráfico con los vértices y color especificados.
     *
     * @param p1 Primer vértice del triángulo
     * @param p2 Segundo vértice del triángulo
     * @param p3 Tercer vértice del triángulo
     * @param unColor Color del triángulo para el dibujo
     */
    public TrianguloGrafico(Punto p1, Punto p2, Punto p3, Color unColor) {
        super(p1, p2, p3);
        this.color = unColor;
    }

    /**
     * Obtiene el color del triángulo gráfico.
     *
     * @return Color del triángulo
     */
    public Color getColor() {
        return color;
    }
    
    /**
     * Dibuja el triángulo en el contexto gráfico especificado.
     * <p>
     * Utiliza el método {@code drawPolygon} de {@link Graphics2D} para dibujar
     * el contorno del triángulo.
     * </p>
     *
     * @param dw Contexto gráfico donde se dibujará el triángulo
     */
    @Override
    public void dibujar(Graphics2D dw) {
        dw.setColor(color);
        int[] xPoints = {(int) getP1().getX(), (int) getP2().getX(), (int) getP3().getX()};
        int[] yPoints = {(int) getP1().getY(), (int) getP2().getY(), (int) getP3().getY()};
        dw.drawPolygon(xPoints, yPoints, 3);
    }
}

package herenciaFiguras;

import java.awt.Color;
import java.awt.Graphics2D;

/**
 * Clase que representa un triángulo relleno con color.
 * <p>
 * La clase {@code TrianguloRelleno} extiende {@link TrianguloGrafico} y representa
 * un triángulo completamente relleno (no solo el contorno). Hereda las propiedades
 * de {@code TrianguloGrafico} (tres vértices y color).
 * </p>
 * <p>
 * Esta clase dibuja el triángulo relleno utilizando el método {@code fillPolygon}
 * de {@link Graphics2D}.
 * </p>
 *
 * <p><b>Ejemplo de uso:</b></p>
 * <pre>
 *     Punto p1 = new Punto(100, 50, "V1");
 *     Punto p2 = new Punto(150, 150, "V2");
 *     Punto p3 = new Punto(50, 150, "V3");
 *     Color color = Color.GREEN;
 *     TrianguloRelleno tr = new TrianguloRelleno(p1, p2, p3, color);
 *     tr.dibujar(g2d);
 * </pre>
 *
 * @author @rhashito
 * @version 1.0
 * @since 1.0
 * @see TrianguloGrafico
 * @see Color
 * @see Graphics2D
 */
public class TrianguloRelleno extends TrianguloGrafico {

    /**
     * Constructor que crea un triángulo relleno con los vértices y color especificados.
     *
     * @param p1 Primer vértice del triángulo
     * @param p2 Segundo vértice del triángulo
     * @param p3 Tercer vértice del triángulo
     * @param unColor Color de relleno del triángulo
     */
    public TrianguloRelleno(Punto p1, Punto p2, Punto p3, Color unColor) {
        super(p1, p2, p3, unColor);
    }

    /**
     * Dibuja el triángulo relleno en el contexto gráfico especificado.
     * <p>
     * Utiliza el método {@code fillPolygon} de {@link Graphics2D} para dibujar
     * el triángulo completamente relleno.
     * </p>
     *
     * @param dw Contexto gráfico donde se dibujará el triángulo
     */
    @Override
    public void dibujar(Graphics2D dw) {
        dw.setColor(getColor());
        int[] xPoints = {(int) getP1().getX(), (int) getP2().getX(), (int) getP3().getX()};
        int[] yPoints = {(int) getP1().getY(), (int) getP2().getY(), (int) getP3().getY()};
        dw.fillPolygon(xPoints, yPoints, 3);
    }
}

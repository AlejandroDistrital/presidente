package herenciaFiguras;

import java.awt.Color;
import java.awt.Graphics2D;

/**
 * Clase que representa un rectángulo relleno con color.
 * <p>
 * La clase {@code RectanguloRelleno} extiende {@link RectanguloGrafico} y representa
 * un rectángulo completamente relleno (no solo el contorno). Hereda las propiedades
 * de {@code RectanguloGrafico} (dos puntos diagonalmente opuestos y color).
 * </p>
 * <p>
 * Esta clase dibuja el rectángulo relleno utilizando el método {@code fillRect}
 * de {@link Graphics2D}.
 * </p>
 *
 * <p><b>Ejemplo de uso:</b></p>
 * <pre>
 *     Punto p1 = new Punto(50, 50, "Esquina1");
 *     Punto p2 = new Punto(200, 150, "Esquina2");
 *     Color color = Color.BLUE;
 *     RectanguloRelleno rr = new RectanguloRelleno(p1, p2, color);
 *     rr.dibujar(g2d);
 * </pre>
 *
 * @author @rhashito
 * @version 1.0
 * @since 1.0
 * @see RectanguloGrafico
 * @see Color
 * @see Graphics2D
 */
public class RectanguloRelleno extends RectanguloGrafico {

    /**
     * Constructor que crea un rectángulo relleno con los puntos y color especificados.
     *
     * @param p1 Primer punto diagonalmente opuesto
     * @param p2 Segundo punto diagonalmente opuesto
     * @param unColor Color de relleno del rectángulo
     */
    public RectanguloRelleno(Punto p1, Punto p2, Color unColor) {
        super(p1, p2, unColor);
    }

    /**
     * Dibuja el rectángulo relleno en el contexto gráfico especificado.
     * <p>
     * Utiliza el método {@code fillRect} de {@link Graphics2D} para dibujar
     * el rectángulo completamente relleno.
     * </p>
     *
     * @param dw Contexto gráfico donde se dibujará el rectángulo
     */
    @Override
    public void dibujar(Graphics2D dw) {
        dw.setColor(getColor());
        dw.fillRect((int) getP1().getX(), (int) getP1().getY(),
                (int) getP2().getX() - (int) getP1().getX(),
                (int) getP2().getY() - (int) getP1().getY());
    }
}

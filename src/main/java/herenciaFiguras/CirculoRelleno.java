package herenciaFiguras;

import java.awt.Color;
import java.awt.Graphics2D;

/**
 * Clase que representa un círculo relleno con color.
 * <p>
 * La clase {@code CirculoRelleno} extiende {@link CirculoGrafico} y representa
 * un círculo completamente relleno (no solo el contorno). Hereda las propiedades
 * de {@code CirculoGrafico} (centro, radio y color).
 * </p>
 * <p>
 * Esta clase dibuja el círculo relleno utilizando el método {@code fillOval}
 * de {@link Graphics2D}.
 * </p>
 *
 * <p><b>Ejemplo de uso:</b></p>
 * <pre>
 *     Punto centro = new Punto(100, 100, "Centro");
 *     Color color = Color.RED;
 *     CirculoRelleno cr = new CirculoRelleno(centro, 50, color);
 *     cr.dibujar(g2d);
 * </pre>
 *
 * @author @rhashito
 * @version 1.0
 * @since 1.0
 * @see CirculoGrafico
 * @see Color
 * @see Graphics2D
 */
public class CirculoRelleno extends CirculoGrafico {

    /**
     * Constructor que crea un círculo relleno con el centro, radio y color especificados.
     *
     * @param x Punto centro del círculo
     * @param r Radio del círculo
     * @param unColor Color de relleno del círculo
     */
    public CirculoRelleno(Punto x, double r, Color unColor) {
        super(x, r, unColor);
    }

    /**
     * Dibuja el círculo relleno en el contexto gráfico especificado.
     * <p>
     * Utiliza el método {@code fillOval} de {@link Graphics2D} para dibujar
     * el círculo completamente relleno.
     * </p>
     *
     * @param dw Contexto gráfico donde se dibujará el círculo
     */
    @Override
    public void dibujar(Graphics2D dw) {
        dw.setColor(getColor());
        dw.fillOval((int) (getCentro().getX() - getRadio()),
                (int) (getCentro().getY() - getRadio()),
                (int) (2.0 * getRadio()), (int) (2.0 * getRadio()));
    }
}

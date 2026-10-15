package herenciaFiguras;

import java.awt.Color;
import java.awt.Graphics2D;

/**
 * Clase que representa una elipse rellena con color.
 * <p>
 * La clase {@code ElipseRellena} extiende {@link ElipseGrafica} y representa
 * una elipse completamente rellena (no solo el contorno). Hereda las propiedades
 * de {@code ElipseGrafica} (centro, radios y color).
 * </p>
 * <p>
 * Esta clase dibuja la elipse rellena utilizando el método {@code fillOval}
 * de {@link Graphics2D}.
 * </p>
 *
 * <p><b>Ejemplo de uso:</b></p>
 * <pre>
 *     Punto centro = new Punto(100, 100, "Centro");
 *     Color color = Color.ORANGE;
 *     ElipseRellena er = new ElipseRellena(centro, 80, 50, color);
 *     er.dibujar(g2d);
 * </pre>
 *
 * @author @rhashito
 * @version 1.0
 * @since 1.0
 * @see ElipseGrafica
 * @see Color
 * @see Graphics2D
 */
public class ElipseRellena extends ElipseGrafica {

    /**
     * Constructor que crea una elipse rellena con el centro, radios y color especificados.
     *
     * @param centro Punto centro de la elipse
     * @param radioX Radio de la elipse en el eje X
     * @param radioY Radio de la elipse en el eje Y
     * @param unColor Color de relleno de la elipse
     */
    public ElipseRellena(Punto centro, double radioX, double radioY, Color unColor) {
        super(centro, radioX, radioY, unColor);
    }

    /**
     * Dibuja la elipse rellena en el contexto gráfico especificado.
     * <p>
     * Utiliza el método {@code fillOval} de {@link Graphics2D} para dibujar
     * la elipse completamente relleno.
     * </p>
     *
     * @param dw Contexto gráfico donde se dibujará la elipse
     */
    @Override
    public void dibujar(Graphics2D dw) {
        dw.setColor(getColor());
        dw.fillOval((int) (getCentro().getX() - getRadioX()),
                    (int) (getCentro().getY() - getRadioY()),
                    (int) (2 * getRadioX()), (int) (2 * getRadioY()));
    }
}

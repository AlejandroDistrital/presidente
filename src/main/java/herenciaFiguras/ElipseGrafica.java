package herenciaFiguras;

import java.awt.Color;
import java.awt.Graphics2D;

/**
 * Clase que representa una elipse gráfica con color.
 * <p>
 * La clase {@code ElipseGrafica} extiende {@link Elipse} e implementa {@link Dibujable},
 * permitiendo dibujar una elipse en un contexto gráfico. Además de las propiedades
 * heredadas de {@code Elipse} (centro y radios), incluye un color para el dibujo.
 * </p>
 * <p>
 * Esta clase dibuja el contorno de la elipse utilizando el método {@code drawOval}
 * de {@link Graphics2D}.
 * </p>
 *
 * <p><b>Ejemplo de uso:</b></p>
 * <pre>
 *     Punto centro = new Punto(100, 100, "Centro");
 *     Color color = Color.ORANGE;
 *     ElipseGrafica eg = new ElipseGrafica(centro, 80, 50, color);
 *     eg.dibujar(g2d);
 * </pre>
 *
 * @author @rhashito
 * @version 1.0
 * @since 1.0
 * @see Elipse
 * @see Dibujable
 * @see Color
 * @see Graphics2D
 */
class ElipseGrafica extends Elipse implements Dibujable {
    private Color color;

    /**
     * Constructor que crea una elipse gráfica con el centro, radios y color especificados.
     *
     * @param centro Punto centro de la elipse
     * @param radioX Radio de la elipse en el eje X
     * @param radioY Radio de la elipse en el eje Y
     * @param unColor Color de la elipse para el dibujo
     */
    public ElipseGrafica(Punto centro, double radioX, double radioY, Color unColor) {
        super(centro, radioX, radioY);
        this.color = unColor;
    }

    /**
     * Obtiene el color de la elipse gráfica.
     *
     * @return Color de la elipse
     */
    public Color getColor() {
        return color;
    }
    
    /**
     * Dibuja la elipse en el contexto gráfico especificado.
     * <p>
     * Utiliza el método {@code drawOval} de {@link Graphics2D} para dibujar
     * el contorno de la elipse.
     * </p>
     *
     * @param dw Contexto gráfico donde se dibujará la elipse
     */
    @Override
    public void dibujar(Graphics2D dw) {
        dw.setColor(color);
        dw.drawOval((int) (getCentro().getX() - getRadioX()),
                    (int) (getCentro().getY() - getRadioY()),
                    (int) (2 * getRadioX()), (int) (2 * getRadioY()));
    }
}

package herenciaFiguras;

import java.awt.Color;
import java.awt.Graphics2D;

/**
 * Clase que representa una línea gráfica con color.
 * <p>
 * La clase {@code LineaGrafica} extiende {@link Linea} e implementa {@link Dibujable},
 * permitiendo dibujar una línea en un contexto gráfico. Además de las propiedades
 * heredadas de {@code Linea} (dos puntos), incluye un color para el dibujo.
 * </p>
 * <p>
 * Esta clase dibuja la línea utilizando el método {@code drawLine}
 * de {@link Graphics2D}.
 * </p>
 *
 * <p><b>Ejemplo de uso:</b></p>
 * <pre>
 *     Punto p1 = new Punto(0, 0, "Inicio");
 *     Punto p2 = new Punto(100, 100, "Fin");
 *     Color color = Color.BLACK;
 *     LineaGrafica lg = new LineaGrafica(p1, p2, color);
 *     lg.dibujar(g2d);
 * </pre>
 *
 * @author @rhashito
 * @version 1.0
 * @since 1.0
 * @see Linea
 * @see Dibujable
 * @see Color
 * @see Graphics2D
 */
class LineaGrafica extends Linea implements Dibujable {
    private Color color;

    /**
     * Constructor que crea una línea gráfica con los puntos y color especificados.
     *
     * @param p1 Punto inicial de la línea
     * @param p2 Punto final de la línea
     * @param unColor Color de la línea para el dibujo
     */
    public LineaGrafica(Punto p1, Punto p2, Color unColor) {
        super(p1, p2);
        this.color = unColor;
    }

    /**
     * Dibuja la línea en el contexto gráfico especificado.
     * <p>
     * Utiliza el método {@code drawLine} de {@link Graphics2D} para dibujar
     * la línea entre los dos puntos.
     * </p>
     *
     * @param dw Contexto gráfico donde se dibujará la línea
     */
    @Override
    public void dibujar(Graphics2D dw) {
        dw.setColor(color);
        dw.drawLine((int) getP1().getX(), (int) getP1().getY(),
                    (int) getP2().getX(), (int) getP2().getY());
    }
}

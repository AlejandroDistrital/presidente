package herenciaFiguras;

import java.awt.Color;
import java.awt.Graphics2D;

/**
 * Clase que representa un círculo gráfico con color.
 * <p>
 * La clase {@code CirculoGrafico} extiende {@link Circulo} e implementa {@link Dibujable},
 * permitiendo dibujar un círculo en un contexto gráfico. Además de las propiedades
 * heredadas de {@code Circulo} (centro y radio), incluye un color para el dibujo.
 * </p>
 * <p>
 * Esta clase dibuja el contorno del círculo utilizando el método {@code drawOval}
 * de {@link Graphics2D}.
 * </p>
 *
 * <p><b>Ejemplo de uso:</b></p>
 * <pre>
 *     Punto centro = new Punto(100, 100, "Centro");
 *     Color color = Color.RED;
 *     CirculoGrafico cg = new CirculoGrafico(centro, 50, color);
 *     cg.dibujar(g2d);
 * </pre>
 *
 * @author @rhashito
 * @version 1.0
 * @since 1.0
 * @see Circulo
 * @see Dibujable
 * @see Color
 * @see Graphics2D
 */
public class CirculoGrafico extends Circulo implements Dibujable {
    private Color color;

    /**
     * Constructor que crea un círculo gráfico con el centro, radio y color especificados.
     *
     * @param x Punto centro del círculo
     * @param r Radio del círculo
     * @param unColor Color del círculo para el dibujo
     */
    public CirculoGrafico(Punto x, double r, Color unColor) {
        super(x, r);
        this.color = unColor;
    }

    /**
     * Obtiene el color del círculo gráfico.
     *
     * @return Color del círculo
     */
    public Color getColor() {
        return color;
    }
    
    /**
     * Dibuja el círculo en el contexto gráfico especificado.
     * <p>
     * Utiliza el método {@code drawOval} de {@link Graphics2D} para dibujar
     * el contorno del círculo.
     * </p>
     *
     * @param dw Contexto gráfico donde se dibujará el círculo
     */
    @Override
    public void dibujar(Graphics2D dw) {
        dw.setColor(color);
        dw.drawOval((int) (getCentro().getX() - getRadio()),
                (int) (getCentro().getY() - getRadio()),
                (int) (2.0 * getRadio()), (int) (2.0 * getRadio()));
    }
}

package herenciaFiguras;

import java.awt.Color;
import java.awt.Graphics2D;

/**
 * Clase que representa un arco gráfico con color.
 * <p>
 * La clase {@code ArcoGrafico} extiende {@link Arco} e implementa {@link Dibujable},
 * permitiendo dibujar un arco en un contexto gráfico. Además de las propiedades
 * heredadas de {@code Arco} (centro, radios, ángulos), incluye un color para el dibujo.
 * </p>
 * <p>
 * Esta clase dibuja el contorno del arco utilizando el método {@code drawArc}
 * de {@link Graphics2D}.
 * </p>
 *
 * <p><b>Ejemplo de uso:</b></p>
 * <pre>
 *     Punto centro = new Punto(100, 100, "Centro");
 *     Color color = Color.CYAN;
 *     ArcoGrafico ag = new ArcoGrafico(centro, 80, 60, 0, 90, color);
 *     ag.dibujar(g2d);
 * </pre>
 *
 * @author @rhashito
 * @version 1.0
 * @since 1.0
 * @see Arco
 * @see Dibujable
 * @see Color
 * @see Graphics2D
 */
class ArcoGrafico extends Arco implements Dibujable {
    private Color color;

    /**
     * Constructor que crea un arco gráfico con los parámetros y color especificados.
     *
     * @param centro Punto centro del arco
     * @param radioX Radio del arco en el eje X
     * @param radioY Radio del arco en el eje Y
     * @param anguloInicial Ángulo inicial del arco en grados
     * @param anguloFinal Ángulo final del arco en grados
     * @param unColor Color del arco para el dibujo
     */
    public ArcoGrafico(Punto centro, double radioX, double radioY,
                        double anguloInicial, double anguloFinal, Color unColor) {
        super(centro, radioX, radioY, anguloInicial, anguloFinal);
        this.color = unColor;
    }

    /**
     * Obtiene el color del arco gráfico.
     *
     * @return Color del arco
     */
    public Color getColor() {
        return color;
    }
    
    /**
     * Dibuja el arco en el contexto gráfico especificado.
     * <p>
     * Utiliza el método {@code drawArc} de {@link Graphics2D} para dibujar
     * el contorno del arco.
     * </p>
     *
     * @param dw Contexto gráfico donde se dibujará el arco
     */
    @Override
    public void dibujar(Graphics2D dw) {
        dw.setColor(color);
        dw.drawArc((int) (getCentro().getX() - getRadioX()),
                   (int) (getCentro().getY() - getRadioY()),
                   (int) (2 * getRadioX()), (int) (2 * getRadioY()),
                   (int) getAnguloInicial(), (int) (getAnguloFinal() - getAnguloInicial()));
    }
}

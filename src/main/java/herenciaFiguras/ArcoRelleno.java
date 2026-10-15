package herenciaFiguras;

import java.awt.Color;
import java.awt.Graphics2D;

/**
 * Clase que representa un arco relleno con color.
 * <p>
 * La clase {@code ArcoRelleno} extiende {@link ArcoGrafico} y representa
 * un arco completamente relleno (no solo el contorno). Hereda las propiedades
 * de {@code ArcoGrafico} (centro, radios, ángulos y color).
 * </p>
 * <p>
 * Esta clase dibuja el arco relleno utilizando el método {@code fillArc}
 * de {@link Graphics2D}.
 * </p>
 *
 * <p><b>Ejemplo de uso:</b></p>
 * <pre>
 *     Punto centro = new Punto(100, 100, "Centro");
 *     Color color = Color.CYAN;
 *     ArcoRelleno ar = new ArcoRelleno(centro, 80, 60, 0, 90, color);
 *     ar.dibujar(g2d);
 * </pre>
 *
 * @author @rhashito
 * @version 1.0
 * @since 1.0
 * @see ArcoGrafico
 * @see Color
 * @see Graphics2D
 */
public class ArcoRelleno extends ArcoGrafico {

    /**
     * Constructor que crea un arco relleno con los parámetros y color especificados.
     *
     * @param centro Punto centro del arco
     * @param radioX Radio del arco en el eje X
     * @param radioY Radio del arco en el eje Y
     * @param anguloInicial Ángulo inicial del arco en grados
     * @param anguloFinal Ángulo final del arco en grados
     * @param unColor Color de relleno del arco
     */
    public ArcoRelleno(Punto centro, double radioX, double radioY,
                        double anguloInicial, double anguloFinal, Color unColor) {
        super(centro, radioX, radioY, anguloInicial, anguloFinal, unColor);
    }

    /**
     * Dibuja el arco relleno en el contexto gráfico especificado.
     * <p>
     * Utiliza el método {@code fillArc} de {@link Graphics2D} para dibujar
     * el arco completamente relleno.
     * </p>
     *
     * @param dw Contexto gráfico donde se dibujará el arco
     */
    @Override
    public void dibujar(Graphics2D dw) {
        dw.setColor(getColor());
        dw.fillArc((int) (getCentro().getX() - getRadioX()),
                   (int) (getCentro().getY() - getRadioY()),
                   (int) (2 * getRadioX()), (int) (2 * getRadioY()),
                   (int) getAnguloInicial(), (int) (getAnguloFinal() - getAnguloInicial()));
    }
}

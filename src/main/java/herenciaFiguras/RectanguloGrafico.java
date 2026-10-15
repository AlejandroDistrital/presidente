package herenciaFiguras;

import java.awt.Color;
import java.awt.Graphics2D;

/**
 * Clase que representa un rectángulo gráfico con color.
 * <p>
 * La clase {@code RectanguloGrafico} extiende {@link Rectangulo} e implementa {@link Dibujable},
 * permitiendo dibujar un rectángulo en un contexto gráfico. Además de las propiedades
 * heredadas de {@code Rectangulo} (dos puntos diagonalmente opuestos), incluye un color para el dibujo.
 * </p>
 * <p>
 * Esta clase dibuja el contorno del rectángulo utilizando el método {@code drawRect}
 * de {@link Graphics2D}.
 * </p>
 *
 * <p><b>Ejemplo de uso:</b></p>
 * <pre>
 *     Punto p1 = new Punto(50, 50, "Esquina1");
 *     Punto p2 = new Punto(200, 100, "Esquina2");
 *     Color color = Color.BLUE;
 *     RectanguloGrafico rg = new RectanguloGrafico(p1, p2, color);
 *     rg.dibujar(g2d);
 * </pre>
 *
 * @author @rhashito
 * @version 1.0
 * @since 1.0
 * @see Rectangulo
 * @see Dibujable
 * @see Color
 * @see Graphics2D
 */
class RectanguloGrafico extends Rectangulo implements Dibujable {
    private Color color;

    /**
     * Constructor que crea un rectángulo gráfico con los puntos y color especificados.
     *
     * @param p1 Primer punto diagonalmente opuesto
     * @param p2 Segundo punto diagonalmente opuesto
     * @param unColor Color del rectángulo para el dibujo
     */
    public RectanguloGrafico(Punto p1, Punto p2, Color unColor) {
        super(p1, p2);
        this.color = unColor;
    }

    /**
     * Obtiene el color del rectángulo gráfico.
     *
     * @return Color del rectángulo
     */
    public Color getColor() {
        return color;
    }
    
    /**
     * Dibuja el rectángulo en el contexto gráfico especificado.
     * <p>
     * Utiliza el método {@code drawRect} de {@link Graphics2D} para dibujar
     * el contorno del rectángulo.
     * </p>
     *
     * @param dw Contexto gráfico donde se dibujará el rectángulo
     */
    @Override
    public void dibujar(Graphics2D dw) {
        dw.setColor(color);
        dw.drawRect((int) super.getP1().getX(), (int) super.getP1().getY(),
                (int) super.getP2().getX() - (int) super.getP1().getX(),
                (int) super.getP2().getY() - (int) super.getP1().getY());
    }
}

package herenciaFiguras;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

/**
 * Clase que representa un polígono relleno con color.
 * <p>
 * La clase {@code PoligonoRelleno} extiende {@link PoligonoGrafico} y representa
 * un polígono completamente relleno (no solo el contorno). Hereda las propiedades
 * de {@code PoligonoGrafico} (lista de vértices y color).
 * </p>
 * <p>
 * Esta clase dibuja el polígono relleno utilizando el método {@code fillPolygon}
 * de {@link Graphics2D}.
 * </p>
 *
 * <p><b>Ejemplo de uso:</b></p>
 * <pre>
 *     ArrayList<Punto> vertices = new ArrayList<>();
 *     vertices.add(new Punto(0, 0, "V1"));
 *     vertices.add(new Punto(100, 0, "V2"));
 *     vertices.add(new Punto(50, 80, "V3"));
 *     Color color = Color.MAGENTA;
 *     PoligonoRelleno pr = new PoligonoRelleno(vertices, color);
 *     pr.dibujar(g2d);
 * </pre>
 *
 * @author @rhashito
 * @version 1.0
 * @since 1.0
 * @see PoligonoGrafico
 * @see Color
 * @see Graphics2D
 */
public class PoligonoRelleno extends PoligonoGrafico {

    /**
     * Constructor que crea un polígono relleno con los vértices y color especificados.
     *
     * @param vertices Lista de puntos que representan los vértices del polígono
     * @param unColor Color de relleno del polígono
     */
    public PoligonoRelleno(ArrayList<Punto> vertices, Color unColor) {
        super(vertices, unColor);
    }

    /**
     * Dibuja el polígono relleno en el contexto gráfico especificado.
     * <p>
     * Utiliza el método {@code fillPolygon} de {@link Graphics2D} para dibujar
     * el polígono completamente relleno.
     * </p>
     *
     * @param dw Contexto gráfico donde se dibujará el polígono
     */
    @Override
    public void dibujar(Graphics2D dw) {
        dw.setColor(getColor());
        ArrayList<Punto> v = getVertices();
        int[] xPoints = new int[v.size()];
        int[] yPoints = new int[v.size()];
        for (int i = 0; i < v.size(); i++) {
            xPoints[i] = (int) v.get(i).getX();
            yPoints[i] = (int) v.get(i).getY();
        }
        dw.fillPolygon(xPoints, yPoints, v.size());
    }
}

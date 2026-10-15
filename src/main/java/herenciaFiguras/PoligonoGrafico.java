package herenciaFiguras;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

/**
 * Clase que representa un polígono gráfico con color.
 * <p>
 * La clase {@code PoligonoGrafico} extiende {@link Poligono} e implementa {@link Dibujable},
 * permitiendo dibujar un polígono en un contexto gráfico. Además de las propiedades
 * heredadas de {@code Poligono} (lista de vértices), incluye un color para el dibujo.
 * </p>
 * <p>
 * Esta clase dibuja el contorno del polígono utilizando el método {@code drawPolygon}
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
 *     PoligonoGrafico pg = new PoligonoGrafico(vertices, color);
 *     pg.dibujar(g2d);
 * </pre>
 *
 * @author @rhashito
 * @version 1.0
 * @since 1.0
 * @see Poligono
 * @see Dibujable
 * @see Color
 * @see Graphics2D
 */
class PoligonoGrafico extends Poligono implements Dibujable {
    private Color color;

    /**
     * Constructor que crea un polígono gráfico con los vértices y color especificados.
     *
     * @param vertices Lista de puntos que representan los vértices del polígono
     * @param unColor Color del polígono para el dibujo
     */
    public PoligonoGrafico(ArrayList<Punto> vertices, Color unColor) {
        super(vertices);
        this.color = unColor;
    }

    /**
     * Obtiene el color del polígono gráfico.
     *
     * @return Color del polígono
     */
    public Color getColor() {
        return color;
    }
    
    /**
     * Dibuja el polígono en el contexto gráfico especificado.
     * <p>
     * Utiliza el método {@code drawPolygon} de {@link Graphics2D} para dibujar
     * el contorno del polígono.
     * </p>
     *
     * @param dw Contexto gráfico donde se dibujará el polígono
     */
    @Override
    public void dibujar(Graphics2D dw) {
        dw.setColor(color);
        ArrayList<Punto> v = getVertices();
        int[] xPoints = new int[v.size()];
        int[] yPoints = new int[v.size()];
        for (int i = 0; i < v.size(); i++) {
            xPoints[i] = (int) v.get(i).getX();
            yPoints[i] = (int) v.get(i).getY();
        }
        dw.drawPolygon(xPoints, yPoints, v.size());
    }
}

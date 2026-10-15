package herenciaFiguras;

import java.util.ArrayList;

/**
 * Clase que representa un polígono en el sistema geométrico.
 * <p>
 * La clase {@code Poligono} extiende {@link Geometria} y representa un polígono
 * definido por una lista de vértices (puntos). Proporciona métodos para calcular
 * el perímetro (suma de las distancias entre vértices consecutivos) y el área
 * utilizando la fórmula del shoelace (método de Gauss).
 * </p>
 * <p>
 * El perímetro se calcula como la suma de las distancias entre cada par de
 * vértices consecutivos (incluyendo el último con el primero).<br>
 * El área se calcula usando la fórmula del shoelace:
 * |Σ(xi * yi+1 - xi+1 * yi)| / 2
 * </p>
 *
 * <p><b>Ejemplo de uso:</b></p>
 * <pre>
 *     ArrayList<Punto> vertices = new ArrayList<>();
 *     vertices.add(new Punto(0, 0, "V1"));
 *     vertices.add(new Punto(4, 0, "V2"));
 *     vertices.add(new Punto(4, 3, "V3"));
 *     vertices.add(new Punto(0, 3, "V4"));
 *     Poligono poligono = new Poligono(vertices);
 *     double perimetro = poligono.perimetro();
 *     double area = poligono.area();
 * </pre>
 *
 * @author @rhashito
 * @version 1.0
 * @since 1.0
 * @see Geometria
 * @see Punto
 * @see ArrayList
 */
public class Poligono extends Geometria {
    private ArrayList<Punto> vertices;

    /**
     * Constructor que crea un polígono con los vértices especificados.
     *
     * @param vertices Lista de puntos que representan los vértices del polígono
     */
    public Poligono(ArrayList<Punto> vertices) {
        this.vertices = vertices;
    }

    /**
     * Constructor predeterminado que crea un cuadrado con valores por defecto.
     * <p>
     * El polígono se inicializa como un cuadrado con vértices en (0,0), (3,0), (3,3) y (0,3).
     * </p>
     */
    public Poligono() {
        this.vertices = new ArrayList<>();
        vertices.add(new Punto(0, 0, "V1"));
        vertices.add(new Punto(3, 0, "V2"));
        vertices.add(new Punto(3, 3, "V3"));
        vertices.add(new Punto(0, 3, "V4"));
    }

    /**
     * Calcula el perímetro del polígono.
     * <p>
     * El perímetro se calcula como la suma de las distancias euclidianas
     * entre cada par de vértices consecutivos, incluyendo el último con el primero.
     * </p>
     *
     * @return Perímetro del polígono
     */
    @Override
    public double perimetro() {
        double perim = 0;
        for (int i = 0; i < vertices.size(); i++) {
            perim += vertices.get(i).distanciaEuclides(
                    vertices.get((i + 1) % vertices.size()));
        }
        return perim;
    }

    /**
     * Calcula el área del polígono usando la fórmula del shoelace.
     * <p>
     * Se utiliza el método de Gauss (fórmula del shoelace) para calcular el área.
     * La fórmula es: |Σ(xi * yi+1 - xi+1 * yi)| / 2
     * </p>
     *
     * @return Área del polígono
     */
    @Override
    public double area() {
        double area = 0;
        int n = vertices.size();
        for (int i = 0; i < n; i++) {
            area += vertices.get(i).getX() * vertices.get((i + 1) % n).getY();
            area -= vertices.get((i + 1) % n).getX() * vertices.get(i).getY();
        }
        return Math.abs(area) / 2;
    }

    /**
     * Obtiene la lista de vértices del polígono.
     *
     * @return Lista de puntos que representan los vértices del polígono
     */
    public ArrayList<Punto> getVertices() {
        return vertices;
    }
}

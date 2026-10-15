package herenciaFiguras;

/**
 * Clase abstracta base que representa una figura geométrica.
 * <p>
 * La clase {@code Geometria} define la estructura común para todas las figuras geométricas
 * del sistema, proporcionando métodos abstractos para calcular el perímetro y el área.
 * Además, mantiene un contador estático del número total de figuras geométricas creadas.
 * </p>
 * <p>
 * Las subclases deben implementar los métodos {@link #perimetro()} y {@link #area()}
 * para proporcionar cálculos específicos para cada tipo de figura.
 * </p>
 *
 * <p><b>Ejemplo de uso:</b></p>
 * <pre>
 *     Circulo c = new Circulo(new Punto(0, 0, "Centro"), 5.0);
 *     double perim = c.perimetro();
 *     double area = c.area();
 * </pre>
 *
 * @author @rhashito
 * @version 1.0
 * @since 1.0
 */
public abstract class Geometria {

    private static int numFiguras = 0 ;

    /**
     * Constructor que incrementa el contador de figuras geométricas.
     * <p>
     * Cada vez que se crea una nueva instancia de una subclase de Geometria,
     * este constructor es llamado y el contador de figuras se incrementa en 1.
     * </p>
     */
    public Geometria() {
        numFiguras++;
    }

    /**
     * Obtiene el número total de figuras geométricas creadas.
     *
     * @return Total de figuras geométricas creadas
     */
    public static int getNumFiguras(){
        return numFiguras;
    }

    /**
     * Calcula el perímetro de la figura geométrica.
     * <p>
     * Este método debe ser implementado por todas las subclases para proporcionar
     * el cálculo específico del perímetro según el tipo de figura.
     * </p>
     *
     * @return Perímetro de la figura geométrica
     */
    public abstract double perimetro();

    /**
     * Calcula el área de la figura geométrica.
     * <p>
     * Este método debe ser implementado por todas las subclases para proporcionar
     * el cálculo específico del área según el tipo de figura.
     * </p>
     *
     * @return Área de la figura geométrica
     */
    public abstract double area();

}

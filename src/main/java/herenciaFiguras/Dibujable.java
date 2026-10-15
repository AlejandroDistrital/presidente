package herenciaFiguras;

import java.awt.Graphics2D;

/**
 * Interfaz que define el comportamiento de dibujo para las figuras geométricas.
 * <p>
 * Esta interfaz establece el contrato que deben cumplir todas las clases que
 * representen figuras dibujables en un contexto gráfico. Cualquier clase que
 * implemente esta interfaz debe proporcionar una implementación del método
 * {@link #dibujar(Graphics2D)}.
 * </p>
 * <p>
 * El método {@code dibujar} recibe un objeto {@link Graphics2D} que es el
 * contexto gráfico donde se realizará el dibujo de la figura.
 * </p>
 *
 * <p><b>Ejemplo de implementación:</b></p>
 * <pre>
 *     public class CirculoGrafico extends Circulo implements Dibujable {
 *         &#64;Override
 *         public void dibujar(Graphics2D dw) {
 *             dw.drawOval(...);
 *         }
 *     }
 * </pre>
 *
 * @author @rhashito
 * @version 1.0
 * @since 1.0
 * @see Graphics2D
 */
public interface Dibujable {
    
    /**
     * Método que dibuja la figura en el contexto gráfico especificado.
     * <p>
     * Este método debe ser implementado por cualquier clase que represente
     * una figura dibujable. La implementación debe utilizar el objeto
     * {@link Graphics2D} proporcionado para realizar el dibujo de la figura
     * en el contexto gráfico actual.
     * </p>
     *
     * @param dw Contexto gráfico donde se dibujará la figura
     */
    void dibujar(Graphics2D dw);
}

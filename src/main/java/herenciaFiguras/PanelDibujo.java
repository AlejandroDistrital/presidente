package herenciaFiguras;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 * Clase que representa un panel de dibujo para figuras geométricas.
 * <p>
 * La clase {@code PanelDibujo} extiende {@link JPanel} y proporciona un panel
 * donde se pueden dibujar múltiples figuras geométricas que implementen la
 * interfaz {@link Dibujable}. El panel utiliza un fondo blanco y delega el
 * dibujo de cada figura al método {@code dibujar} de la interfaz.
 * </p>
 * <p>
 * Esta clase sobrescribe el método {@code paintComponent} de JPanel para
 * realizar el dibujo de todas las figuras agregadas a la lista.
 * </p>
 *
 * <p><b>Ejemplo de uso:</b></p>
 * <pre>
 *     ArrayList<Dibujable> figuras = new ArrayList<>();
 *     figuras.add(new CirculoGrafico(...));
 *     figuras.add(new RectanguloGrafico(...));
 *     PanelDibujo panel = new PanelDibujo(figuras);
 * </pre>
 *
 * @author @rhashito
 * @version 1.0
 * @since 1.0
 * @see JPanel
 * @see Dibujable
 * @see ArrayList
 */
public class PanelDibujo extends JPanel {

    private final ArrayList<Dibujable> v;

    /**
     * Constructor que crea un panel de dibujo con la lista de figuras especificada.
     *
     * @param v Lista de objetos Dibujable que se dibujarán en el panel
     */
    public PanelDibujo(ArrayList<Dibujable> v) {
        super(new FlowLayout());
        this.v = v;
        setBackground(Color.WHITE);
    }

    /**
     * Método que se ejecuta para renderizar el contenido del panel.
     * <p>
     * Sobrescribe el método {@code paintComponent} de {@link JPanel} para
     * dibujar todas las figuras geométricas en el contexto gráfico proporcionado.
     * </p>
     *
     * @param g Contexto gráfico para el dibujo
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        for (Dibujable x : v) {
            x.dibujar(g2d);
        }
    }
}

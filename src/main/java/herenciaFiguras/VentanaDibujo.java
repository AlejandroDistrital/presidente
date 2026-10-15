package herenciaFiguras;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JFrame;

/**
 * Clase que representa una ventana de dibujo personalizada.
 * <p>
 * La clase {@code VentanaDibujo} extiende {@link JFrame} e implementa
 * {@link WindowListener}, proporcionando una ventana gráfica para
 * dibujar figuras geométricas. La ventana muestra un título personalizado y tiene
 * un tamaño y posición configurables.
 * </p>
 * <p>
 * Cuando la ventana se cierra, permite que la ventana padre sea visible nuevamente
 * y actualiza su etiqueta con el título de esta ventana.
 * </p>
 *
 * <p><b>Ejemplo de uso:</b></p>
 * <pre>
 *     JFrame padre = new JFrame("Aplicación Principal");
 *     VentanaDibujo ventana = new VentanaDibujo(padre, "Mi Dibujo", 800, 600);
 * </pre>
 *
 * @author @rhashito
 * @version 1.0
 * @since 1.0
 * @see JFrame
 * @see WindowListener
 */
class VentanaDibujo extends JFrame implements WindowListener {

    private JFrame padre;

    /**
     * Constructor que crea una ventana de dibujo con los parámetros especificados.
     *
     * @param padre Ventana padre (JFrame) que se mostrará cuando esta ventana se cierre
     * @param title Título de la ventana
     * @param x Ancho de la ventana en píxeles
     * @param y Alto de la ventana en píxeles
     */
    public VentanaDibujo(JFrame padre, String title, int x, int y) {
        super(title);
        this.padre = padre;
        setSize(x, y);
        setLocationRelativeTo(null);
        addWindowListener(this);
        setVisible(true);
    }

    /**
     * Método invocado cuando la ventana se activa.
     *
     * @param e Evento de ventana
     */
    @SuppressWarnings("empty-statement")
    @Override
    public void windowActivated(WindowEvent e) {;
    }

    /**
     * Método invocado cuando la ventana se ha cerrado.
     *
     * @param e Evento de ventana
     */
    @SuppressWarnings("empty-statement")
    @Override
    public void windowClosed(WindowEvent e) {
        padre.setVisible(true);
    }

    /**
     * Método invocado cuando la ventana está por cerrarse.
     *
     * @param e Evento de ventana
     */
    @Override
    public void windowClosing(WindowEvent e) {
        ((SuperDibujo)padre).setEtiquetaTitulo(this.getTitle());
        padre.setVisible(true);
        this.dispose();
    }

    /**
     * Método invocado cuando la ventana se desactiva.
     *
     * @param e Evento de ventana
     */
    @SuppressWarnings("empty-statement")
    @Override
    public void windowDeactivated(WindowEvent e) {;
    }

    /**
     * Método invocado cuando la ventana se restaura desde su estado minimizado.
     *
     * @param e Evento de ventana
     */
    @SuppressWarnings("empty-statement")
    @Override
    public void windowDeiconified(WindowEvent e) {;
    }

    /**
     * Método invocado cuando la ventana se minimiza.
     *
     * @param e Evento de ventana
     */
    @SuppressWarnings("empty-statement")
    @Override
    public void windowIconified(WindowEvent e) {;
    }

    /**
     * Método invocado cuando la ventana se abre por primera vez.
     *
     * @param e Evento de ventana
     */
    @SuppressWarnings("empty-statement")
    @Override
    public void windowOpened(WindowEvent e) {;
    }
}

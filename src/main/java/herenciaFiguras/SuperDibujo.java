package herenciaFiguras;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * Clase principal de la aplicación de dibujo图形.
 * <p>
 * La clase {@code SuperDibujo} extiende {@link JFrame} e implementa {@link ActionListener},
 * proporcionando una interfaz gráfica de usuario para dibujar figuras geométricas.
 * La aplicación permite al usuario introducir un nombre para el dibujo y luego genera
 * una ventana con arte geométrico que incluye círculos concéntricos, triángulos,
 * líneas y rectángulos.
 * </p>
 * <p>
 * La interfaz incluye:
 * <ul>
 *   <li>Un título "SUPER APLICACIÓN DE DIBUJO"</li>
 *   <li>Un campo de texto para el nombre del dibujo</li>
 *   <li>Un botón "Dibujar" para crear la ventana de dibujo</li>
 *   <li>Un botón "Cerrar" para salir de la aplicación</li>
 * </ul>
 * </p>
 *
 * <p><b>Arte generado:</b></p>
 * <p>
 * Al presionar el botón "Dibujar", la aplicación genera una composición artística
 * que incluye:
 * <ul>
 *   <li>Un rectángulo de fondo azul</li>
 *   <li>Círculos concéntricos alternando entre contour y relleno</li>
 *   <li>Seis triángulos en formación de flor</li>
 *   <li>Doce líneas radiantes formando un sol</li>
 * </ul>
 * </p>
 *
 * @author @rhashito
 * @version 1.0
 * @since 1.0
 * @see JFrame
 * @see ActionListener
 * @see VentanaDibujo
 * @see PanelDibujo
 */
public class SuperDibujo extends JFrame implements ActionListener {

    private JLabel JL_titulo;
    private JLabel JL_nombre;
    private JTextField TF_nombre;
    private JButton JB_dibujar;
    private JButton JB_cerrar;

    private static final Color[] PALETA = {
        new Color(255, 107, 107),
        new Color(107, 255, 107),
        new Color(107, 107, 255),
        new Color(255, 255, 107),
        new Color(255, 107, 255),
        new Color(107, 255, 255)
    };

    /**
     * Constructor que inicializa la interfaz de usuario.
     */
    public SuperDibujo() {
        initUI();
    }

    /**
     * Inicializa los componentes de la interfaz de usuario.
     */
    private void initUI() {
        setTitle("Super Dibujo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JL_titulo = new JLabel("SUPER APLICACIÓN DE DIBUJO");
        JL_titulo.setFont(new java.awt.Font("Courier", java.awt.Font.BOLD, 20));
        JL_titulo.setHorizontalAlignment(SwingConstants.CENTER);

        JL_nombre = new JLabel("Nombre para el dibujo");
        JL_nombre.setFont(new java.awt.Font("Arial", java.awt.Font.ITALIC, 14));

        TF_nombre = new JTextField();
        TF_nombre.setFont(new java.awt.Font("Courier", java.awt.Font.ITALIC, 12));
        TF_nombre.setForeground(new Color(10, 20, 185));
        TF_nombre.setHorizontalAlignment(JTextField.CENTER);

        JB_dibujar = new JButton("Dibujar");
        JB_dibujar.addActionListener(this);

        JB_cerrar = new JButton("Cerrar");
        JB_cerrar.addActionListener(this);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addComponent(JL_titulo)
                .addComponent(JL_nombre)
                .addComponent(TF_nombre, 400, 400, 400)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(JB_cerrar, 125, 125, 125)
                    .addComponent(JB_dibujar, 150, 150, 150))
        );

        layout.setVerticalGroup(
            layout.createSequentialGroup()
                .addComponent(JL_titulo)
                .addGap(18)
                .addComponent(JL_nombre)
                .addGap(18)
                .addComponent(TF_nombre, 37, 37, 37)
                .addGap(26)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(JB_cerrar)
                    .addComponent(JB_dibujar))
        );

        pack();
        setLocationRelativeTo(null);
    }

    /**
     * Maneja los eventos de acción de los botones.
     *
     * @param e Evento de acción
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == JB_dibujar) {
            JB_dibujarActionPerformed();
        } else if (e.getSource() == JB_cerrar) {
            JB_cerrarActionPerformed();
        }
    }

    /**
     * Acción ejecutada cuando se presiona el botón "Dibujar".
     * <p>
     * Oculta esta ventana, crea una nueva {@link VentanaDibujo}, genera
     * una composición artística de figuras geométricas, y la muestra en
     * un {@link PanelDibujo}.
     * </p>
     */
    private void JB_dibujarActionPerformed() {
        String titulo = TF_nombre.getText().isEmpty() ? "Arte Geometrico" : TF_nombre.getText();
        int ancho = 1000;
        int alto = 700;

        this.setVisible(false);
        VentanaDibujo ventana = new VentanaDibujo(this, titulo, ancho, alto);
        ArrayList<Dibujable> figuras = crearArteElegante(ancho, alto);

        PanelDibujo panel = new PanelDibujo(figuras);
        ventana.add(panel);
        ventana.revalidate();
        ventana.repaint();
    }

    /**
     * Crea una composición artística de figuras geométricas.
     * <p>
     * Genera una lista de figuras dibujables que forman una composición artística,
     * incluyendo rectángulos, círculos concéntricos, triángulos y líneas.
     * </p>
     *
     * @param ancho Ancho del área de dibujo
     * @param alto Alto del área de dibujo
     * @return Lista de figuras dibujables
     */
    private ArrayList<Dibujable> crearArteElegante(int ancho, int alto) {
        ArrayList<Dibujable> figuras = new ArrayList<>();
        Random r = new Random(42);

        int cx = ancho / 2;
        int cy = alto / 2;

        crearRectanguloMarco(figuras, ancho, alto, r);  // Primero el fondo azul
        crearCirculosConcentricos(figuras, cx, cy, r);
        crearTriangulosFlor(figuras, cx, cy, r);
        crearLineasSol(figuras, cx, cy);

        return figuras;
    }

    /**
     * Crea círculos concéntricos alternando entre contour y relleno.
     * <p>
     * Genera 6 círculos concéntricos con radios递增, usando colores de la paleta.
     * Los círculos en posiciones pares son rellenos, los impares son contornos.
     * </p>
     *
     * @param figuras Lista donde agregar los círculos
     * @param cx Coordenada X del centro
     * @param cy Coordenada Y del centro
     * @param r Generador de números aleatorios
     */
    private void crearCirculosConcentricos(ArrayList<Dibujable> figuras, int cx, int cy, Random r) {
        for (int i = 5; i >= 0; i--) {
            int radio = 30 + i * 35;
            Color color = PALETA[i % PALETA.length];
            if (i % 2 == 0) {
                figuras.add(new CirculoRelleno(
                    new Punto(cx, cy, "C" + i),
                    radio,
                    color
                ));
            } else {
                figuras.add(new CirculoGrafico(
                    new Punto(cx, cy, "C" + i),
                    radio,
                    color
                ));
            }
        }
    }

    /**
     * Crea triángulos en formación de flor.
     * <p>
     * Genera 6 triángulos equiláteros posicionados alrededor del centro,
     * formando una composición de flor. Los triángulos en posiciones pares
     * son rellenos, los impares son contornos.
     * </p>
     *
     * @param figuras Lista donde agregar los triángulos
     * @param cx Coordenada X del centro
     * @param cy Coordenada Y del centro
     * @param r Generador de números aleatorios
     */
    private void crearTriangulosFlor(ArrayList<Dibujable> figuras, int cx, int cy, Random r) {
        int numTriangulos = 6;
        int radio = 180;

        for (int i = 0; i < numTriangulos; i++) {
            double angulo = Math.PI * 2 * i / numTriangulos - Math.PI / 2;
            int px = cx + (int)(radio * Math.cos(angulo));
            int py = cy + (int)(radio * Math.sin(angulo));

            int px2 = cx + (int)((radio + 50) * Math.cos(angulo + 0.3));
            int py2 = cy + (int)((radio + 50) * Math.sin(angulo + 0.3));

            int px3 = cx + (int)((radio + 50) * Math.cos(angulo - 0.3));
            int py3 = cy + (int)((radio + 50) * Math.sin(angulo - 0.3));

            Color c = PALETA[(i + 1) % PALETA.length];
            if (i % 2 == 0) {
                figuras.add(new TrianguloRelleno(
                    new Punto(px, py, "T" + i),
                    new Punto(px2, py2, "T2" + i),
                    new Punto(px3, py3, "T3" + i),
                    c
                ));
            } else {
                figuras.add(new TrianguloGrafico(
                    new Punto(px, py, "T" + i),
                    new Punto(px2, py2, "T2" + i),
                    new Punto(px3, py3, "T3" + i),
                    c
                ));
            }
        }
    }

    /**
     * Crea líneas radiantes formando un sol.
     * <p>
     * Genera 12 líneas que parten del centro hacia afuera, creando
     * un efecto de rayos solares en color dorado.
     * </p>
     *
     * @param figuras Lista donde agregar las líneas
     * @param cx Coordenada X del centro
     * @param cy Coordenada Y del centro
     */
    private void crearLineasSol(ArrayList<Dibujable> figuras, int cx, int cy) {
        Color dorado = new Color(255, 215, 0);

        for (int i = 0; i < 12; i++) {
            double angulo = Math.PI * 2 * i / 12;
            int x1 = cx + (int)(220 * Math.cos(angulo));
            int y1 = cy + (int)(220 * Math.sin(angulo));
            int x2 = cx + (int)(260 * Math.cos(angulo));
            int y2 = cy + (int)(260 * Math.sin(angulo));

            figuras.add(new LineaGrafica(
                new Punto(x1, y1, "L" + i),
                new Punto(x2, y2, "L2" + i),
                dorado
            ));
        }
    }

    /**
     * Crea el marco rectangular de la composición.
     * <p>
     * Genera dos rectángulos: uno de contorno gris como marco exterior
     * y otro de relleno azul como fondo de la composición.
     * </p>
     *
     * @param figuras Lista donde agregar los rectángulos
     * @param ancho Ancho del área de dibujo
     * @param alto Alto del área de dibujo
     * @param r Generador de números aleatorios
     */
    private void crearRectanguloMarco(ArrayList<Dibujable> figuras, int ancho, int alto, Random r) {
        int margen2 = 70;
        Color gris = new Color(100, 100, 100);
        figuras.add(new RectanguloGrafico(
            new Punto(margen2, margen2, "M3"),
            new Punto(ancho - margen2, alto - margen2, "M4"),
            gris
        ));

        int margen = 50;
        Color azul = PALETA[2];
        figuras.add(new RectanguloRelleno(
            new Punto(margen, margen, "M1"),
            new Punto(ancho - margen, alto - margen, "M2"),
            azul
        ));
    }

    /**
     * Actualiza el texto de la etiqueta del título.
     *
     * @param text Nuevo texto para el título
     */
    public void setEtiquetaTitulo(String text) {
        this.JL_titulo.setText(text);
    }

    /**
     * Acción ejecutada cuando se presiona el botón "Cerrar".
     * <p>
     * Imprime el número total de figuras geométricas creadas y
     * termina la aplicación.
     * </p>
     */
    private void JB_cerrarActionPerformed() {
        System.out.println("NumFiguras de Geometria " + Geometria.getNumFiguras());
        System.exit(0);
    }

    /**
     * Método principal que inicia la aplicación.
     *
     * @param args Argumentos de línea de comandos (no utilizados)
     */
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            new SuperDibujo().setVisible(true);
        });
    }
}

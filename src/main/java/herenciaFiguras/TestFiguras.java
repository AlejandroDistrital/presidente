package herenciaFiguras;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JFrame;

/**
 * Clase de prueba para el sistema de figuras geométricas y generación del Retrato.
 *
 * @author @rhashito
 * @version 1.0
 */
public class TestFiguras {

    private static final int ANCHO = 1024;
    private static final int ALTO = 576;
    private static final String TITULO_VENTANA = "Retrato Geometrico";

    // Paleta de colores extraída directamente de la imagen de referencia
    private static final Color FONDO          = new Color(89, 114, 158);
    private static final Color BORDE          = new Color(20, 20, 20);
    private static final Color PELO           = new Color(43, 43, 48);
    private static final Color PIEL           = new Color(247, 205, 168);
    private static final Color PIEL_SOMBRA    = new Color(195, 154, 123);
    private static final Color NARIZ_IZQ      = new Color(191, 148, 118);
    private static final Color NARIZ_ABAJO    = new Color(166, 122, 94);
    private static final Color OREJA_EXT_IZQ  = new Color(233, 159, 134);
    private static final Color OREJA_INT_IZQ  = new Color(92, 54, 54);
    private static final Color OREJA_INT_DER  = new Color(216, 105, 93);
    private static final Color OREJA_EXT_DER  = new Color(235, 160, 134);
    private static final Color BLANCO         = new Color(245, 245, 245);
    private static final Color LABIOS         = new Color(230, 30, 148);
    private static final Color LABIO_INF      = new Color(236, 98, 160);
    private static final Color SACO           = new Color(14, 52, 230);

    public static void main(String[] args) {
        // System.out.println("=== PRUEBA DE FIGURAS GEOMETRICAS ===\n");

        // ArrayList<Geometria> figuras = new ArrayList<>();

        // Punto p1 = new Punto(0, 0, "P1");
        // Punto p2 = new Punto(4, 0, "P2");
        // Punto p3 = new Punto(2, 3, "P3");
        // Punto p4 = new Punto(0, 0, "P4");
        // Punto p5 = new Punto(5, 5, "P5");
        // Punto centro = new Punto(10, 10, "Centro");

        // Rectangulo rectangulo = new Rectangulo(p1, p2);
        // Circulo circulo = new Circulo(centro, 10);
        // Triangulo triangulo = new Triangulo(p1, p2, p3);
        // Linea linea = new Linea(p4, p5);
        // Elipse elipse = new Elipse(centro, 15, 10);
        // Poligono poligono = new Poligono();
        // Arco arco = new Arco(centro, 20, 15, 0, 90);

        // figuras.add(rectangulo);
        // figuras.add(circulo);
        // figuras.add(triangulo);
        // figuras.add(linea);
        // figuras.add(elipse);
        // figuras.add(poligono);
        // figuras.add(arco);

        // for (Geometria x : figuras) {
        //     System.out.println("==========================================");
        //     System.out.println("La Figura es un " + x.getClass().getSimpleName());
        //     System.out.println("Perimetro = " + x.perimetro());
        //     System.out.println("Area = " + x.area());
        // }

        // System.out.println("\n==========================================");
        // System.out.println("Total de figuras: " + Geometria.getNumFiguras());
        // System.out.println("Total de Circulos: " + Circulo.getNumFiguras());
        // System.out.println("Total de Rectangulos: " + Rectangulo.getNumFiguras());
        // System.out.println("Total de Triangulos: " + Triangulo.getNumFiguras());
        // System.out.println("Total de Lineas: " + Linea.getNumFiguras());
        // System.out.println("Total de Elipses: " + Elipse.getNumFiguras());
        // System.out.println("Total de Poligonos: " + Poligono.getNumFiguras());
        // System.out.println("Total de Arcos: " + Arco.getNumFiguras());
        // System.out.println("==========================================\n");

        java.awt.EventQueue.invokeLater(TestFiguras::mostrarRetrato);
    }

    // ===================== RETRATO GEOMETRICO =====================

    /**
     * Crea una ventana y dibuja en ella el retrato geométrico exacto.
     */
    private static void mostrarRetrato() {
        JFrame ventana = new JFrame(TITULO_VENTANA);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        PanelDibujo panel = new PanelDibujo(crearRetrato());
        panel.setPreferredSize(new Dimension(ANCHO, ALTO));
        ventana.add(panel);
        ventana.pack();
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }

    /**
     * Arma el retrato por capas con sus respectivos bordes y rellenos precisos.
     *
     * @return lista ordenada de figuras a dibujar
     */
    private static ArrayList<Dibujable> crearRetrato() {
        ArrayList<Dibujable> f = new ArrayList<>();

        // Fondo azul grisáceo
        f.add(new RectanguloRelleno(new Punto(0, 0, "F1"), new Punto(ANCHO, ALTO, "F2"), FONDO));

        agregarCuelloYCamisa(f);
        agregarSaco(f);
        agregarCabezaYPelo(f);
        agregarOrejas(f);
        agregarBarba(f);
        agregarMejillas(f);
        agregarCejasYOjos(f);
        agregarNariz(f);
        agregarBigoteYBoca(f);

        return f;
    }

    private static void agregarCuelloYCamisa(ArrayList<Dibujable> f) {
        // Base del cuello (piel clara)
        f.add(poligonoRelleno(PIEL, 411, 336, 571, 355, 547, 456, 411, 366));
        // Sombra triangular del cuello
        f.add(poligonoRelleno(PIEL_SOMBRA, 411, 336, 516, 355, 516, 456));
        // Contorno exterior del cuello
        f.add(poligonoContorno(BORDE, 411, 336, 571, 355, 547, 456, 411, 366));

        // Camisa blanca
        poligonoConBorde(f, BLANCO, 411, 366, 547, 456, 579, 434, 622, 567, 580, 567, 411, 412);
        poligonoConBorde(f, BLANCO, 411, 366, 547, 456, 526, 476, 411, 400);
        poligonoConBorde(f, BLANCO, 547, 456, 560, 412, 579, 434, 547, 456);

        // Línea vertical de la botonera y botón
        f.add(new LineaGrafica(new Punto(547, 456, "BC1"), new Punto(547, 520, "BC2"), BORDE));
        Punto centroBoton = new Punto(562, 480, "Boton");
        f.add(new CirculoRelleno(centroBoton, 7, BLANCO));
        f.add(new CirculoGrafico(centroBoton, 7, BORDE));
    }

    private static void agregarSaco(ArrayList<Dibujable> f) {
        poligonoConBorde(f, SACO, 296, 488, 411, 366, 580, 567, 296, 567);
        poligonoConBorde(f, SACO, 411, 366, 456, 412, 368, 464, 482, 567, 580, 567);
        poligonoConBorde(f, SACO, 560, 412, 706, 567, 622, 567, 579, 434);
        f.add(new LineaGrafica(new Punto(640, 567, "SD1"), new Punto(652, 510, "SD2"), BORDE));
    }

    private static void agregarCabezaYPelo(ArrayList<Dibujable> f) {
        poligonoConBorde(f, PELO, 352, 38, 437, 8, 590, 8, 671, 38, 671, 96, 630, 169, 397, 169, 352, 96);
        poligonoConBorde(f, PIEL, 378, 52, 437, 29, 590, 29, 648, 52, 648, 96, 608, 169, 614, 285, 411, 285, 418, 169, 378, 96);
    }

    private static void agregarOrejas(ArrayList<Dibujable> f) {
        poligonoConBorde(f, OREJA_EXT_IZQ, 385, 169, 400, 169, 400, 224, 385, 212);
        rectanguloConBorde(f, OREJA_INT_IZQ, 400, 169, 418, 213);
        rectanguloConBorde(f, OREJA_INT_DER, 605, 169, 625, 213);
        poligonoConBorde(f, OREJA_EXT_DER, 625, 169, 640, 169, 640, 212, 625, 224);
    }

    private static void agregarBarba(ArrayList<Dibujable> f) {
        poligonoConBorde(f, PELO, 397, 240, 411, 240, 445, 295, 445, 329, 580, 329, 580, 295, 614, 240, 630, 240, 630, 295, 583, 355, 443, 355, 397, 295);
        poligonoConBorde(f, PIEL, 445, 265, 580, 265, 580, 329, 445, 329);
    }

    private static void agregarMejillas(ArrayList<Dibujable> f) {
        Punto mejillaIzq = new Punto(433, 240, "MI");
        Punto mejillaDer = new Punto(592, 240, "MD");
        int radioMejilla = 38;

        f.add(new CirculoRelleno(mejillaIzq, radioMejilla, PIEL));
        f.add(new CirculoGrafico(mejillaIzq, radioMejilla, BORDE));

        f.add(new CirculoRelleno(mejillaDer, radioMejilla, PIEL));
        f.add(new CirculoGrafico(mejillaDer, radioMejilla, BORDE));
    }

    private static void agregarCejasYOjos(ArrayList<Dibujable> f) {
        poligonoConBorde(f, PELO, 418, 169, 443, 146, 497, 173, 497, 196, 418, 169);
        poligonoConBorde(f, PELO, 532, 179, 584, 152, 600, 172, 532, 196);

        poligonoConBorde(f, BLANCO, 428, 195, 497, 196, 474, 208, 450, 208);
        f.add(new CirculoRelleno(new Punto(465, 200, "PI"), 7, BORDE));
        f.add(new LineaGrafica(new Punto(428, 195, "LP1"), new Punto(497, 196, "LP2"), BORDE));

        poligonoConBorde(f, BLANCO, 532, 196, 602, 195, 578, 208, 554, 208);
        f.add(new CirculoRelleno(new Punto(568, 200, "PD"), 7, BORDE));
        f.add(new LineaGrafica(new Punto(532, 196, "LP3"), new Punto(602, 195, "LP4"), BORDE));
    }

    private static void agregarNariz(ArrayList<Dibujable> f) {
        poligonoConBorde(f, NARIZ_IZQ, 497, 173, 512, 235, 488, 240);
        poligonoConBorde(f, NARIZ_ABAJO, 488, 240, 512, 235, 540, 235, 526, 255, 503, 255);
        poligonoConBorde(f, PIEL, 497, 173, 532, 179, 540, 235, 512, 235);
    }

    private static void agregarBigoteYBoca(ArrayList<Dibujable> f) {
        poligonoConBorde(f, PELO, 421, 286, 465, 254, 488, 240, 503, 255, 512, 267, 474, 261);
        poligonoConBorde(f, PELO, 512, 267, 526, 255, 540, 235, 560, 254, 604, 286, 550, 261);
        poligonoConBorde(f, LABIOS, 440, 292, 488, 275, 512, 280, 536, 275, 586, 292, 540, 304, 485, 304);
        poligonoConBorde(f, LABIO_INF, 485, 304, 540, 304, 512, 309);
        f.add(new LineaGrafica(new Punto(440, 292, "LL1"), new Punto(586, 292, "LL2"), BORDE));

        Punto m1 = new Punto(490, 311, "M1");
        Punto m2 = new Punto(535, 311, "M2");
        Punto m3 = new Punto(512, 329, "M3");
        f.add(new TrianguloRelleno(m1, m2, m3, PELO));
        f.add(new TrianguloGrafico(m1, m2, m3, BORDE));
    }

    // ===================== MÉTODOS AUXILIARES =====================

    private static void poligonoConBorde(ArrayList<Dibujable> f, Color relleno, int... coords) {
        f.add(poligonoRelleno(relleno, coords));
        f.add(poligonoContorno(BORDE, coords));
    }

    private static void rectanguloConBorde(ArrayList<Dibujable> f, Color relleno, int x1, int y1, int x2, int y2) {
        Punto p1 = new Punto(x1, y1, "R1");
        Punto p2 = new Punto(x2, y2, "R2");
        f.add(new RectanguloRelleno(p1, p2, relleno));
        f.add(new RectanguloGrafico(p1, p2, BORDE));
    }

    private static PoligonoRelleno poligonoRelleno(Color color, int... coords) {
        return new PoligonoRelleno(crearListaVertices(coords), color);
    }

    private static PoligonoGrafico poligonoContorno(Color color, int... coords) {
        return new PoligonoGrafico(crearListaVertices(coords), color);
    }

    private static ArrayList<Punto> crearListaVertices(int... coords) {
        if (coords.length % 2 != 0) {
            throw new IllegalArgumentException("Las coordenadas deben venir en pares (x, y)");
        }
        ArrayList<Punto> vertices = new ArrayList<>();
        for (int i = 0; i < coords.length; i += 2) {
            vertices.add(new Punto(coords[i], coords[i + 1], "V" + (i / 2)));
        }
        return vertices;
    }
}
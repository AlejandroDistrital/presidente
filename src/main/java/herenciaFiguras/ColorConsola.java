package herenciaFiguras;

/**
 * Enumeración que representa los colores disponibles para salida en consola.
 * <p>
 * Cada color está definido por su código de escape ANSI correspondiente.
 * Esta enumeración se utiliza para dar formato a la salida de texto en consola
 * con colores, facilitando la distinción de información en la terminal.
 * </p>
 *
 * <p><b>Ejemplo de uso:</b></p>
 * <pre>
 *     System.out.println(ColorConsola.ROJO.getValor() + "Texto en rojo" + ColorConsola.NEGRO.getValor());
 * </pre>
 *
 * @author @rhashito
 * @version 1.0
 * @since 1.0
 */
public enum ColorConsola {
    // valores definidos por la ANSI
    ROJO ("\u001B[31m"),
    VERDE ("\033[32m"),
    NEGRO ("\033[30m"),
    AZUL ("\033[034m");

    private final String color;
    
    /**
     * Constructor del enumerado ColorConsola.
     *
     * @param color Código de escape ANSI que representa el color
     */
    ColorConsola (String color){
        this.color = color;
    }

    /**
     * Obtiene el código de escape ANSI que representa el color.
     *
     * @return Código de escape ANSI del color
     */
    public String getValor() {
        return color;
    }
}

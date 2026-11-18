package logica;

// Clase abstracta base para todas las cartas del juego.
// "abstract" significa que no se puede crear una Carta directamente,
// solo se pueden crear sus subclases (Pokemon, Entrenador).
public abstract class Carta {
    protected String nombre;   // Nombre de la carta (ej: "Pikachu", "Pocion")
    protected String tipo;     // Tipo de la carta (ej: "Eléctrico", "Curativa")

    // Constructor: recibe el nombre y el tipo, los asigna a los atributos
    public Carta(String nombre, String tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
    }

    // Getter: devuelve el nombre de la carta
    public String getNombre() { return nombre; }

    // Getter: devuelve el tipo de la carta
    public String getTipo() {
        return tipo; }
}

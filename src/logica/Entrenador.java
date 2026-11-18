package logica;

// Clase que representa una carta de Entrenador (poción curativa).
// Hereda de Carta (tiene nombre y tipo) e implementa Activable (se puede usar en turno).
public class Entrenador extends Carta implements Activable {
    private String efecto;   // Descripción textual del efecto (ej: "Cura 20 PS")

    // Constructor: recibe nombre, tipo y descripción del efecto
    public Entrenador(String nombre, String tipo, String efecto) {
        super(nombre, tipo);        // Llama al constructor de Carta
        this.efecto = efecto;
    }

    // Getter del efecto
    public String getEfecto() {
        return efecto;
    }

    // Método de la interfaz Activable: cura al Pokémon activo del jugador
    @Override
    public void activar(Jugador jugador) {
        // Verifica que el jugador tenga un Pokémon activo
        if (jugador.getPokemonActivo() != null) {
            int vidaActual = jugador.getPokemonActivo().getPs();      // Lee los PS actuales
            int nuevaVida = vidaActual + 20;                          // Suma 20 PS (todas las pociones curan 20)

            // Si la nombre es "Julio Profe", cura 10 en vez de 20
            if (this.getNombre().equals("Julio Profe")) {
                nuevaVida = nuevaVida - 10;                          // 20 - 10 = 10 PS netos
            }

            // Si la vida supera 80, se limita a 80 (máximo)
            if (nuevaVida > 80) {
                jugador.getPokemonActivo().setPs(80);
            } else {
                jugador.getPokemonActivo().setPs(nuevaVida);          // Aplica la nueva vida
            }

            System.out.println("Pokemon curado, ahora tienes " + jugador.getPokemonActivo().getPs() + " Ps");
        }
    }
}

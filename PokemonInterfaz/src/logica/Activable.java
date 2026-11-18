package logica;

// Interfaz que define el contrato para cartas que se pueden "activar" o "usar".
// Cualquier clase que implemente Activable debe definir el método activar().
// En este juego, solo Entrenador (las pociones) la implementa.
public interface Activable {
    // Método que ejecuta el efecto de la carta sobre un jugador
    void activar(Jugador jugador);
}

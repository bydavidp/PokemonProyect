package logica;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Clase que representa el mazo de cartas de un jugador.
// Al crearse, genera todas las cartas y las baraja aleatoriamente.
public class Mazo {
    private List<Carta> cartas;   // Lista interna que guarda todas las cartas del mazo

    // Constructor: crea la lista vacía, carga las cartas y las baraja
    public Mazo() {
        this.cartas = new ArrayList<Carta>();
        iniciarMazo();    // Agrega todas las cartas a la lista
        barajar();        // Las mezcla en orden aleatorio
    }

    // Crea los 9 Pokémon y las 10 cartas curativas (5 Pociones + 5 Julio Profe)
    private void iniciarMazo() {

        // ── POKÉMON (cada uno con nombre, tipo, 80 PS, grito y daño) ──
        Pokemon pikachu = new Pokemon("Pikachu", "Eléctrico", 80, "Pika-Pika Chuu", 25);
        cartas.add(pikachu);

        Pokemon charmander = new Pokemon("Charmander", "Fuego", 80, "Charmandeeer!!", 25);
        cartas.add(charmander);

        Pokemon squirtle = new Pokemon("Squirtle", "Agua", 80, "Squirttt-le", 20);
        cartas.add(squirtle);

        Pokemon bulbasaur = new Pokemon("Bulbasaur", "Planta", 80, "Buulbaaasaaaurrr!!!", 23);
        cartas.add(bulbasaur);

        Pokemon jigglypuff = new Pokemon("Jigglypuff", "Normal", 80, "Jiggggglyyyypuff!!!!", 20);
        cartas.add(jigglypuff);

        Pokemon meowth = new Pokemon("Meowth", "Normal", 80, "Meeeeooowwwthh", 20);
        cartas.add(meowth);

        Pokemon machop = new Pokemon("Machop", "Lucha", 80, "Maaaachop", 15);
        cartas.add(machop);

        Pokemon geodude = new Pokemon("Geodude", "Lucha", 80, "Geoodudee", 22);
        cartas.add(geodude);

        Pokemon gastly = new Pokemon("Gastly", "Psíquico", 80, "Gaastlyyyy", 15);
        cartas.add(gastly);

        // ── CARTAS CURATIVAS (5 Pociones y 5 Julio Profe en bucle) ──
        for (int i = 0; i < 5; i++) {
            Entrenador pocion = new Entrenador("Pocion", "Curativa", "Cura 20 PS al Pokemon en juego");
            cartas.add(pocion);

            Entrenador profJulio = new Entrenador("Julio Profe", "Curativa", "Cura 10 PS al Pokemon en juego");
            cartas.add(profJulio);
        }
    }

    // Mezcla aleatoriamente el orden de las cartas usando Collections.shuffle
    public void barajar() {
        Collections.shuffle(cartas);
    }

    // Devuelve la lista de cartas (para que Jugador pueda robar del principio)
    public List<Carta> getCartas() {
        return cartas;
    }
}

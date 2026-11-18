package logica;

import java.util.ArrayList;
import java.util.List;

// Clase que representa a un jugador de la partida.
// Cada jugador tiene su propio mazo, mano de cartas y Pokémon activo.
public class Jugador {
    private String nombre;              // Nombre del jugador (ej: "Ash")
    private Mazo mazo;                  // Mazo de cartas del jugador (se crea automáticamente)
    private List<Carta> mano;           // Lista de cartas que tiene en la mano
    private Pokemon pokemonActivo;      // Pokémon que está peleando actualmente en el campo
    private int rondasGanadas;          // Contador de rondas ganadas (para ganar la partida a las 3)

    // Constructor: crea el mazo y la mano vacía, inicia rondas en 0
    public Jugador(String nombre) {
        this.nombre = nombre;
        this.mazo = new Mazo();         // Cada jugador crea su propio mazo (barajado)
        this.mano = new ArrayList<>();  // Mano vacía al inicio
        this.rondasGanadas = 0;
    }

    // Saca la primera carta del mazo y la añade a la mano
    public void robarCarta() {
        if (!mazo.getCartas().isEmpty()) {              // Verifica que el mazo no esté vacío
            Carta robada = mazo.getCartas().remove(0);  // Saca la carta del inicio de la lista
            mano.add(robada);                           // La agrega al final de la mano
        } else {
            System.out.println(nombre + " no tiene mas cartas dentro del mazo ");
        }
    }

    // Asigna el Pokémon que peleará en el campo
    public void setPokemonActivo(Pokemon pokemon) {
        this.pokemonActivo = pokemon;
    }

    // ── GETTERS ──
    public String getNombre() { return nombre; }
    public Mazo getMazo() { return mazo; }
    public List<Carta> getMano() { return mano; }
    public Pokemon getPokemonActivo() { return pokemonActivo; }
    public int getRondasGanadas() { return rondasGanadas; }

    // Suma 1 al contador de rondas ganadas
    public void incrementarRondasGanadas() {
        this.rondasGanadas++;
    }
}

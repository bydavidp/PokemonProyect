package logica;

public class Pokemon extends Carta {
    // ── ATRIBUTOS ──
    private int ps;              // PS actuales del Pokémon (bajan al recibir daño)
    private String gritoBatalla; // Frase que dice al entrar al campo (ej: "Pika-Pika Chuu")
    private int danoAtaque;      // Daño base que hace en cada ataque

    // ── CONSTRUCTOR ──
    // Se ejecuta al crear un Pokémon con: new Pokemon(nombre, tipo, ps, grito, dano)
    public Pokemon(String nombre, String tipo, int ps, String gritoBatalla, int danoAtaque) {
        super(nombre, tipo);     // Llama al constructor de Carta para asignar nombre y tipo
        this.ps = ps;            // Guarda los PS iniciales (ej: 80)
        this.gritoBatalla = gritoBatalla; // Guarda el grito de batalla
        this.danoAtaque = danoAtaque;     // Guarda el daño de ataque (ej: 25)
    }

    // ── GETTERS Y SETTERS ──

    public int getPs() {
         return ps; }            // Devuelve los PS actuales (se usa para mostrar vida y calcular KO)

    public void setPs(int ps) { this.ps = ps; }  // Modifica los PS (se usa al recibir daño o curar)

    public String getGritoBatalla() {return gritoBatalla;} // Devuelve el grito (se imprime al sacar el Pokémon)

    public int getDanoAtaque() {return danoAtaque;}        // Devuelve el daño base (se usa para calcular el ataque en Juego.java)
}

import java.util.ArrayList;

/**
 * Un entrenador (jugador) en plena partida.
 * Maneja su mano, mazo, campo (activo + banco), zona de energia y premios.
 */
public class Jugador {

    private String nombre;
    private Mazo mazo;
    private ArrayList<Carta> mano;
    private Pokemon activo;
    private ArrayList<Pokemon> banco;
    private boolean energiaDisponible;
    private int puntosPremio;

    public static final int MAX_BANCO = 2;
    public static final int PS_PREMIO = 3;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.mano = new ArrayList<Carta>();
        this.banco = new ArrayList<Pokemon>();
        this.energiaDisponible = false;
        this.puntosPremio = 0;
    }

    /**
     * Roba 1 carta al inicio del turno (RF2a).
     * Retorna false si el mazo estaba vacio (RF3: pierde el duelo).
     */
    public boolean robarCarta() {
        // TODO (RF2/RF3): Carta c = mazo.robarCarta();
        // si c == null retornar false, sino agregarla a mano y retornar true
        return false;
    }

    /**
     * Coloca un Pokemon basico de la mano en el banco (RF2d).
     * Maximo 2 en el banco.
     */
    public void colocarEnBanco(Pokemon pokemon) {
        // TODO (RF2): validar banco.size() < MAX_BANCO antes de agregar
        banco.add(pokemon);
    }

    /**
     * Reemplaza el activo por el primero del banco (RF3).
     * Se usa cuando el activo es derrotado o se retira.
     */
    public void reemplazarActivo() {
        // TODO (RF3): si !banco.isEmpty(), activo = banco.remove(0)
    }

    /**
     * Sigue en juego si tiene activo o algo en el banco (RF3).
     */
    public boolean tienePokemones() {
        return activo != null || !banco.isEmpty();
    }

    /**
     * Gana un punto de premio. Si era Pokemon-ex son 2 (RF3).
     */
    public void ganarPremio(boolean eraEx) {
        // TODO (RF3): sumar 2 si eraEx, sino 1
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Mazo getMazo() {
        return mazo;
    }

    public void setMazo(Mazo mazo) {
        this.mazo = mazo;
    }

    public ArrayList<Carta> getMano() {
        return mano;
    }

    public Pokemon getActivo() {
        return activo;
    }

    public void setActivo(Pokemon activo) {
        this.activo = activo;
    }

    public ArrayList<Pokemon> getBanco() {
        return banco;
    }

    public boolean isEnergiaDisponible() {
        return energiaDisponible;
    }

    public void setEnergiaDisponible(boolean energiaDisponible) {
        this.energiaDisponible = energiaDisponible;
    }

    public int getPuntosPremio() {
        return puntosPremio;
    }
}
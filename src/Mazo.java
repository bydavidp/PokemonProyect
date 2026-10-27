import java.util.ArrayList;
import java.util.Collections;

/**
 * Mazo de exactamente 20 cartas (RF4).
 * Reglas: maximo 2 copias de una misma carta, minimo 6 Pokemon basicos.
 */
public class Mazo {

    private ArrayList<Carta> cartas;

    public static final int TAMANIO_MAZO = 20;
    public static final int MAX_COPIAS = 2;
    public static final int MIN_BASICOS = 6;

    public Mazo() {
        this.cartas = new ArrayList<Carta>();
    }

    /**
     * Agrega una carta validando que no se pase del maximo de copias.
     */
    public void agregarCarta(Carta carta) {
        int copias = 0;
        for (Carta c : cartas) {
            if (c.getNombre().equals(carta.getNombre())) {
                copias++;
            }
        }
        // TODO (RF4): si copias ya es MAX_COPIAS, no agregar y avisar por consola
        cartas.add(carta);
    }

    /**
     * El mazo es valido si tiene 20 cartas y al menos 6 Pokemon basicos.
     */
    public boolean esValido() {
        // TODO (RF4): contar Pokemones con un for (Carta c : cartas)
        // y retornar cartas.size() == TAMANIO_MAZO && basicos >= MIN_BASICOS
        return false;
    }

    /**
     * Baraja el mazo aleatoriamente (RF4).
     */
    public void barajar() {
        Collections.shuffle(cartas);
    }

    /**
     * Saca y retorna la carta de arriba del mazo.
     * Retorna null si el mazo esta vacio (RF3: quien no puede robar, pierde).
     */
    public Carta robarCarta() {
        // TODO: si cartas.isEmpty() retornar null, sino cartas.remove(0)
        return null;
    }

    /**
     * Devuelve una mano inicial de 5 cartas.
     * Si ninguna es Pokemon basico: mulligan (RF4).
     * Se devuelve la mano al mazo, se baraja y se reparte de nuevo.
     */
    public ArrayList<Carta> repartirManoInicial() {
        // TODO (RF4):
        // 1. robar 5 cartas a una lista mano
        // 2. revisar con un for si hay al menos un c.esPokemon()
        // 3. si no hay: devolver las 5 al mazo, barajar() y repetir (while)
        return new ArrayList<Carta>();
    }

    public ArrayList<Carta> getCartas() {
        return cartas;
    }
}
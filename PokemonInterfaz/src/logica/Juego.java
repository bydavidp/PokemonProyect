package logica;

// Importa la clase Scanner del paquete java.util para leer entrada del teclado
import java.util.Scanner;

// Clase principal que controla todo el flujo del juego
public class Juego {

// ── ATRIBUTOS ──
private Jugador jugador1;   // Objeto que representa al primer jugador
private Jugador jugador2;   // Objeto que representa al segundo jugador
private Scanner scanner;    // Objeto para leer lo que el usuario escribe en consola

// ── CONSTRUCTOR ──
// Se ejecuta al hacer "new Juego()". Pide los nombres de los jugadores
public Juego() {
    scanner = new Scanner(System.in);                          // Conecta el Scanner con la entrada estándar (teclado)
    System.out.print("Ingresa el nombre J1 ");                 // Pide el nombre del jugador 1
    this.jugador1 = new Jugador(scanner.nextLine());            // Crea el Jugador 1 con el nombre ingresado (nextLine lee toda la línea)
    System.out.print("Ingresa el nombre j2 ");                 // Pide el nombre del jugador 2
    this.jugador2 = new Jugador(scanner.nextLine());            // Crea el Jugador 2
    System.out.println("¡¡A PELEAR!!");                         // Mensaje de inicio
}

// ── PREPARAR PARTIDA ──
// Reparte 5 cartas a cada jugador y luego cada uno elige su Pokémon inicial
public void prepararPartida() {

    System.out.println("Repartiendo cartas.. \n ");             // Anuncio de reparto
    for (int i = 0; i < 5; i++) {                               // Bucle de 5 iteraciones (índices 0 a 4)
        jugador1.robarCarta();                                  // J1 roba una carta de su mazo
        jugador2.robarCarta();                                  // J2 roba una carta de su mazo
    }
    elegirPokemon(jugador1);                                    // J1 elige su Pokémon activo
    elegirPokemon(jugador2);                                    // J2 elige su Pokémon activo
}

// ── ELEGIR POKÉMON INICIAL ──
// Muestra la mano del jugador y le pide que elija un Pokémon válido
private void elegirPokemon(Jugador jugador) {
    //## mana1
    System.out.println("Mano de " + jugador.getNombre() + ":"); // Muestra de quién es la mano
    for (int i = 0; i < jugador.getMano().size(); i++) {        // Recorre todas las cartas de la mano
        Carta carta = jugador.getMano().get(i);                 // Obtiene la carta en la posición i
        System.out.println(i + ". " + carta.getNombre() + " (" + carta.getTipo() + ")"); // La imprime con índice, nombre y tipo
    }
    // Bucle que se repite hasta que el jugador tenga un Pokémon activo asignado
    while (jugador.getPokemonActivo() == null) {
        System.out.print("Escoge tu Pokemon ");                 // Pide el índice
        int eleccion = scanner.nextInt();                       // Lee el número ingresado

        // Verifica que el índice esté dentro del rango válido de la mano
        if (eleccion >= 0 && eleccion < jugador.getMano().size()) {
            Carta cartaElegida = jugador.getMano().get(eleccion);  // Obtiene la carta elegida

            // instanceof verifica en tiempo de ejecución si la carta es de tipo Pokemon (y no Entrenador)
            if (cartaElegida instanceof Pokemon) {
                jugador.setPokemonActivo((Pokemon) cartaElegida);   // Casting: convierte Carta a Pokemon y lo asigna como activo
                jugador.getMano().remove(eleccion);                 // Quita el Pokémon de la mano (ya está en juego)
                System.out.println("¡" + jugador.getNombre() + " ha lanzado a " + jugador.getPokemonActivo().getGritoBatalla() + "!\n"); // Imprime el grito de batalla
            } else {
                System.out.println("Debes escoger a un pokemon");   // Era una carta Entrenador, no sirve
            }
        } else {
            System.out.println("¡Numero invalido!");               // Índice fuera de rango
        }
    }
}

// ── JUGAR UN TURNO ──
// Ejecuta la lógica de un turno del jugador "activo" contra el "rival"
// Retorna true si el combate continúa, false si alguien ganó la partida
private boolean jugarTurno(Jugador activo, Jugador rival) {
    System.out.println("\n#################");                  // Separador visual
    System.out.println("Turno de " + activo.getNombre());       // Anuncia de quién es el turno

    // Rellena la mano hasta tener 5 cartas, sacando del mazo si tiene
    // Condición: mano < 5 Y el mazo NO está vacío
    while (activo.getMano().size() < 5 && !activo.getMazo().getCartas().isEmpty()) {
        activo.robarCarta();                                    // Roba una carta
    }

    // Si el mazo quedó vacío, el rival gana la ronda
    if (activo.getMazo().getCartas().isEmpty()) {
        System.out.println("¡" + activo.getNombre() + "No tiene mas cartas!.. GANA " + rival.getNombre() + ", Tiene" + rival.getRondasGanadas() + " Ronda(s) ganada(s)");
        rival.incrementarRondasGanadas();                       // Suma 1 ronda ganada al rival
        // Si el rival llegó a 3 rondas ganadas, gana la partida y termina el método
        if (rival.getRondasGanadas() == 3) { return false; }
    }

    // Muestra el Pokémon activo actual y sus PS
    System.out.println("Tu Pokemon activo: " + activo.getPokemonActivo().getNombre() + " (" + activo.getPokemonActivo().getPs() + " PS)");
    System.out.println("¿Que deseas hacer?");
    System.out.println("1. Atacar");
    System.out.println("2. Cambiar Pokemon");
    System.out.println("3. Cartas Curativas (Entrenador-Pocion");
    System.out.print("Digita tu opcion (1, 2 o 3): ");
    int opcion1 = scanner.nextInt();                            // Lee la opción del menú

    // ── OPCIÓN 1: ATACAR ──
    if (opcion1 == 1) {
        System.out.println(activo.getPokemonActivo().getNombre() + " ataca!");
        int psActuales2 = rival.getPokemonActivo().getPs();     // Lee los PS actuales del rival
        // Resta el daño del atacante a los PS del rival
        rival.getPokemonActivo().setPs(psActuales2 - activo.getPokemonActivo().getDanoAtaque());
        System.out.println("El rival recibe " + activo.getPokemonActivo().getDanoAtaque() + " de daño y le quedan " + rival.getPokemonActivo().getPs() + " PS.");

    // ── OPCIÓN 2: CAMBIAR POKÉMON ──
    } else if (opcion1 == 2) {
        System.out.println("Tus cartas en la mano:");
        for (int i = 0; i < activo.getMano().size(); i++) {     // Muestra la mano con índices
            System.out.println(i + ". " + activo.getMano().get(i).getNombre());
        }
        System.out.print("Elige el numero de tu nuevo Pokemon: ");
        int numeroCambio = scanner.nextInt();                   // Lee el índice del nuevo Pokémon

        // Verifica que el índice sea válido
        if (numeroCambio >= 0 && numeroCambio < activo.getMano().size()) {
            // Verifica que la carta elegida sea un Pokémon
            if (activo.getMano().get(numeroCambio) instanceof Pokemon) {
                activo.getMano().add(activo.getPokemonActivo());    // Devuelve el Pokémon activo actual a la mano
                // Casting: convierte la carta elegida a Pokemon y la pone como activa
                activo.setPokemonActivo((Pokemon) activo.getMano().get(numeroCambio));
                activo.getMano().remove(numeroCambio);              // Quita el nuevo Pokémon de la mano
                System.out.println("Devolviste a tu pokemon. Ahora peleas con " + activo.getPokemonActivo().getGritoBatalla());
            } else {
                System.out.println("Esa carta no es un Pokemon. Pierdes el turno");
            }
        } else {
            System.out.println("Numero fuera de rango. Pierdes el turno.");
        }

    // ── OPCIÓN 3: CARTA CURATIVA ──
    } else if (opcion1 == 3) {
        System.out.println("Tus cartas en la mano:");
        for (int i = 0; i < activo.getMano().size(); i++) {
            System.out.println(i + ". " + activo.getMano().get(i).getNombre());
        }
        System.out.print("Elige la carta curativa: ");
        int indiceCarta = scanner.nextInt();                    // Lee el índice de la carta curativa

        // Verifica rango válido
        if (indiceCarta >= 0 && indiceCarta < activo.getMano().size()) {
            Carta cartaElegida = activo.getMano().get(indiceCarta);

            // Verifica que la carta implemente la interfaz Activable (pociones)
            if (cartaElegida instanceof Activable) {
                Activable cartaActivable = (Activable) cartaElegida;  // Casting a Activable
                cartaActivable.activar(activo);                        // Ejecuta el efecto de curación

                activo.getMano().remove(indiceCarta);                  // Descarta la carta usada

                // Si el mazo tiene cartas, roba una como reposición
                if (!activo.getMazo().getCartas().isEmpty()) {
                    activo.robarCarta();
                    System.out.println("Has robado una carta del mazo");
                }
            } else {
                System.out.println("No es una carta valida. Pierdes tu turno ");
            }
        } else {
            System.out.println("Numero fuera de rango. Pierdes tu turno ");
        }
    } else {
        System.out.println("Numero fuera de rango. Pierdes tu turno");
    }

    // ── VERIFICAR SI EL POKÉMON RIVAL SE DEBILITÓ (PS <= 0) ──
    if (rival.getPokemonActivo().getPs() <= 0) {
        System.out.println("\n¡" + rival.getPokemonActivo().getNombre() + " se ha debilitado!");

        activo.incrementarRondasGanadas();                      // El atacante gana la ronda
        System.out.println("¡" + activo.getNombre() + " GANA LA RONDA! Rondas ganadas: " + activo.getRondasGanadas());

        // Si llegó a 3 rondas, gana la partida
        if (activo.getRondasGanadas() == 3) {
            System.out.println("¡" + activo.getNombre() + " HA GANADO LA PARTIDA!");
            return false;                                       // Termina el combate
        }

        // Verifica si el rival tiene algún Pokémon en la mano
        boolean pokemonEnMano = false;
        for (int i = 0; i < rival.getMano().size(); i++) {
            Carta cartaEscoger = rival.getMano().get(i);
            if (cartaEscoger instanceof Pokemon) {
                pokemonEnMano = true;
                break;                                          // Encontró al menos uno, no sigue buscando
            }
        }

        // Si el rival no tiene Pokémon en la mano, pierde la partida
        if (!pokemonEnMano) {
            System.out.println(rival.getNombre() + " no tiene mas Pokemones disponibles en la mano.");
            System.out.println("¡" + activo.getNombre() + " GANA LA PARTIDA!");
            return false;
        }

        // El rival debe elegir su nuevo Pokémon activo
        System.out.println("\n" + rival.getNombre() + ", debes elegir a tu nuevo Pokemon activo:");
        boolean seleccionValida = false;

        // Bucle hasta que elija un Pokémon válido
        while (seleccionValida == false) {
            System.out.println("Tus cartas en la mano:");
            for (int i = 0; i < rival.getMano().size(); i++) {
                System.out.println(i + ". " + rival.getMano().get(i).getNombre());
            }
            System.out.print("Elige el numero de tu nuevo Pokemon: ");
            int numeroCambio = scanner.nextInt();

            if (numeroCambio >= 0 && numeroCambio < rival.getMano().size()) {
                Carta cartaElegida = rival.getMano().get(numeroCambio);
                if (cartaElegida instanceof Pokemon) {
                    rival.setPokemonActivo((Pokemon) cartaElegida);  // Asigna el nuevo Pokémon
                    rival.getMano().remove(numeroCambio);             // Lo saca de la mano
                    System.out.println(rival.getNombre() + " ahora juega con " + rival.getPokemonActivo().getGritoBatalla());
                    seleccionValida = true;                           // Sale del bucle
                } else {
                    System.out.println("Esa carta no es un Pokemon \n");
                }
            } else {
                System.out.println("Numero fuera de rango \n");
            }
        }
    }
    return true;                                                // El combate continúa
}

// ── INICIAR COMBATE ──
// Bucle principal que alterna los turnos entre J1 y J2
public void iniciarCombate() {
    System.out.println("-- ¡INICIA EL COMBATE! --");
    boolean combateActivo = true;

    // Continúa mientras el combate siga activo y ambos tengan Pokémon activo
    while (combateActivo && jugador1.getPokemonActivo() != null && jugador2.getPokemonActivo() != null) {

        combateActivo = jugarTurno(jugador1, jugador2);         // Turno de J1
        if (!combateActivo) return;                             // Si terminó, sale

        // Pausa: espera a que J2 escriba 1 para pasar de turno
        int pausa1 = 0;
        while (pausa1 != 1) {
            System.out.print("\nEscribe 1 y presiona Enter para pasar al turno del rival: ");
            pausa1 = scanner.nextInt();
        }

        //##J2
        combateActivo = jugarTurno(jugador2, jugador1);         // Turno de J2
        if (!combateActivo) return;                             // Si terminó, sale

        // Pausa: espera a que J1 escriba 1 para la siguiente ronda
        int pausa2 = 0;
        while (pausa2 != 1) {
            System.out.print("\nEscribe 1 y presiona Enter para iniciar la siguiente ronda: ");
            pausa2 = scanner.nextInt();
        }
    }
}

// ── MÉTODO MAIN ──
// Punto de entrada del programa. Se ejecuta con: java Juego
public static void main(String[] args) {
    Juego partida = new Juego();        // Crea el objeto Juego (pide nombres de jugadores)
    partida.prepararPartida();          // Reparte cartas y elige Pokémon iniciales
    partida.iniciarCombate();           // Inicia el bucle de turnos
}
}

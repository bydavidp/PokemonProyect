public class Entrenador extends Carta implements Activable {
    private String efecto;

    public Entrenador(String nombre, String tipo, String efecto) {
        super(nombre, tipo);
        this.efecto = efecto;
    }

    @Override
    public void activarEfecto() {
        System.out.println("Activando efecto de " + nombre + ": " + efecto);
        // La lógica exacta de robar cartas o curar PS se programará en la siguiente fase
    }
}
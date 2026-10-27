public abstract class Carta {
    protected String nombre;
    protected String tipo;

    public Carta(String nombre, String tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
    }

    public boolean esPokemon() {
    return this instanceof Pokemon;
}

    public String getNombre() { return nombre; }
    public String getTipo() { return tipo; }

}
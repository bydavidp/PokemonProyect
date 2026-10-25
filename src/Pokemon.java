import java.util.List;

public class Pokemon extends Carta {
    private int ps;
    private int costoRetirada;
    private List<String> ataques; // Más adelante podemos crear una clase 'Ataque'

    public Pokemon(String nombre, String tipo, int ps, int costoRetirada, List<String> ataques) {
        super(nombre, tipo); // Llama al constructor de la clase padre (Carta)
        this.ps = ps;
        this.costoRetirada = costoRetirada;
        this.ataques = ataques;
    }

    public int getPs() {
         return ps; }
    public void setPs(int ps) { this.ps = ps; } // Para cuando reciba daño o se cure
    public int getCostoRetirada() { return costoRetirada; }
}
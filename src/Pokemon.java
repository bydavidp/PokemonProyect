import java.util.List;

public class Pokemon extends Carta {
    private int ps;
    private int costoRetirada;
    private List<String> ataques; 

    public Pokemon(String nombre, String tipo, int ps, int costoRetirada, List<String> ataques) {
        super(nombre, tipo); 
        this.ps = ps;
        this.costoRetirada = costoRetirada;
        this.ataques = ataques;
    }

    public int getPs() {
         return ps; }
    public void setPs(int ps) { this.ps = ps; } 
    public int getCostoRetirada() { return costoRetirada; }
}
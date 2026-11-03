public class Pokemon extends Carta {
    private int ps;


    public Pokemon(String nombre, String tipo, int ps) {
        super(nombre, tipo); 
        this.ps = ps;
    }

    public int getPs() {
         return ps; }
    public void setPs(int ps) { this.ps = ps; } 
}

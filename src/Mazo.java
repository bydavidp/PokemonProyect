import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Mazo {
    private List <Carta> cartas;

    public Mazo() {
        this.cartas = new ArrayList<Carta>();
        iniciarMazo();
        barajar();
    }

    private void iniciarMazo() {

        List<String> ataquesPikachu = new ArrayList<>();
        ataquesPikachu.add("Impactrueno");
        ataquesPikachu.add("Rayoo");
        Pokemon pikachu = new Pokemon("Pikachu", "Eléctrico", 60, 1, ataquesPikachu);
        cartas.add(pikachu);

        
        List<String> ataquesCharmander = new ArrayList<>();
        ataquesCharmander.add("Garra de fuego");
        ataquesCharmander.add("Lanzallamas");
        Pokemon charmander = new Pokemon("Charmander", "Fuego", 60, 1, ataquesCharmander);
        cartas.add(charmander);

       
        List<String> ataquesSquirtle = new ArrayList<>();
        ataquesSquirtle.add("Squirttack");
        ataquesSquirtle.add("Agua a presion");
        Pokemon squirtle = new Pokemon("Squirtle", "Agua", 60, 1, ataquesSquirtle);
        cartas.add(squirtle);

        
        List<String> ataquesBulbasaur = new ArrayList<>();
        ataquesBulbasaur.add("Flor de loto");
        ataquesBulbasaur.add("Lanza Bananos");
        Pokemon bulbasaur = new Pokemon("Bulbasaur", "Planta", 60, 1, ataquesBulbasaur);
        cartas.add(bulbasaur);

       
        List<String> ataquesJigglypuff = new ArrayList<>();
        ataquesJigglypuff.add("Canto");
        ataquesJigglypuff.add("Dormilon");
        Pokemon jigglypuff = new Pokemon("Jigglypuff", "Normal", 60, 1, ataquesJigglypuff);
        cartas.add(jigglypuff);

        
        List<String> ataquesMeowth = new ArrayList<>();
        ataquesMeowth.add("Arañazo");
        ataquesMeowth.add("Encerrona");
        Pokemon meowth = new Pokemon("Meowth", "Normal", 60, 1, ataquesMeowth);
        cartas.add(meowth);

       
        List<String> ataquesMachop = new ArrayList<>();
        ataquesMachop.add("Golpe Kárate");
        ataquesMachop.add("Puños veloces");
        Pokemon machop = new Pokemon("Machop", "Lucha", 70, 2, ataquesMachop);
        cartas.add(machop);

       
        List<String> ataquesGeodude = new ArrayList<>();
        ataquesGeodude.add("Catapulta");
        ataquesGeodude.add("Puños De piedra");
        Pokemon geodude = new Pokemon("Geodude", "Lucha", 70, 2, ataquesGeodude);
        cartas.add(geodude);

                
        List<String> ataquesGastly = new ArrayList<>();
        ataquesGastly.add("Pesadillas");
        ataquesGastly.add("Rayo Confuso");
        Pokemon gastly = new Pokemon("Gastly", "Psíquico", 50, 1, ataquesGastly);
        cartas.add(gastly);

                                 
        List<String> ataquesAbra = new ArrayList<>();
        ataquesAbra.add("Teletransporte");
        ataquesAbra.add("Veneno");
        Pokemon abra = new Pokemon("Abra", "Psíquico", 40, 1, ataquesAbra);
        cartas.add(abra);

        // cartas 
        for (int i = 0; i < 5; i++) {
            Entrenador pocion = new Entrenador("Pocion", "Objeto", "Cura 20 PS al Pokemon en juego");
            cartas.add(pocion);
            
            Entrenador profJulio = new Entrenador("Julio Profe", "Soporte", "Roba 2 cartas del mazo");
            cartas.add(profJulio);
        }
    }

    public void barajar() {
        Collections.shuffle(cartas);
    }

    public List<Carta> getCartas() {
        return cartas;
    }
}
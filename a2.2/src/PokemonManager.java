import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


/**
* The Class manages the Pokemons, the Trainers, the Swap
* and the Competition.
*
* @author Ben
* @version 1.0
*/
public final class PokemonManager {
    
    /**
     * The Constructor of PokemonManager.
     */
    private PokemonManager() {
        
    }
    
    /**
     * Main-Method of PokemonManger.
     * @param args ???
     */
    public static void main(final String [ ] args) {

        System.out.println("Ein Trainer Alan Kay wird erstellt");
        Trainer trainer1 = new Trainer("Alan Curtis", "Kay");
        System.out.println("Ein Trainer Donald Knuth wird erstellt");
        Trainer trainer2 = new Trainer("Donald", "Knuth");
        System.out.println("Ein Trainer Ada Lovelace wird erstellt");
        Trainer trainer3 = new Trainer("Ada", "Lovelace");
        System.out.println("Ein Trainer Grace Hopper wird erstellt");
//        Trainer trainer4 = new Trainer("Grace", "Hopper");


        System.out.println("12 neue Pokemon werden erstellt");

        Pokemon pokemon1 = new Pokemon("Pikachu", Type.Water);
        Pokemon pokemon2 = new Pokemon("Raichu", Type.Water);
        Pokemon pokemon3 = new Pokemon("Smettbo", Type.Water);
        Pokemon pokemon4 = new Pokemon("Habitak", Type.Water);
        
        Pokemon pokemon5 = new Pokemon("Glumander", Type.Fire);
        Pokemon pokemon6 = new Pokemon("Sandan", Type.Fire);
        Pokemon pokemon7 = new Pokemon("Sandamer", Type.Fire);
        Pokemon pokemon8 = new Pokemon("Rattfratz", Type.Fire);
        
        Pokemon pokemon9 = new Pokemon("Rettan", Type.Poison);
        Pokemon pokemon10 = new Pokemon("Bisasam", Type.Poison);
        Pokemon pokemon11 = new Pokemon("Arbok", Type.Poison);
        Pokemon pokemon12 = new Pokemon("Bibor", Type.Poison);

        trainer1.addPokemon(pokemon1);
        trainer1.addPokemon(pokemon5);
        trainer1.addPokemon(pokemon9);
        trainer1.addPokemon(pokemon10);
        
        trainer2.addPokemon(pokemon2);
        trainer2.addPokemon(pokemon3);
        trainer2.addPokemon(pokemon6);
        trainer2.addPokemon(pokemon11);
        
        trainer3.addPokemon(pokemon4);
        trainer3.addPokemon(pokemon7);
        trainer3.addPokemon(pokemon8);
        
        System.out.println("Pokemon" + pokemon6.getName() 
                + " wird vom tauschen ausgeschlossen");
        pokemon6.setSwapAllow(false);
     
        Swap swap1 = new Swap();
        Swap swap2 = new Swap();
        Swap swap3 = new Swap();
        Swap swap4 = new Swap();
        Swap swap5 = new Swap();
        Swap swap6 = new Swap();
        Swap swap7 = new Swap();
//        Swap swap8 = new Swap();
//        Swap swap9 = new Swap();
//        Swap swap10 = new Swap();
        
        Competition competition1 = new Competition();
        Competition competition2 = new Competition();
        Competition competition3 = new Competition();
        Competition competition4 = new Competition();
//        Competition competition5 = new Competition();
//        Competition competition6 = new Competition();
//        Competition competition7 = new Competition();
//        Competition competition8 = new Competition();
//        Competition competition9 = new Competition();
//        Competition competition10 = new Competition();
        
        //Required error messages
        System.out.println("Required error messages");
        swap1.execute(pokemon6, pokemon12);
        swap2.execute(pokemon12, pokemon10);
        
        //Exhaustive Tests.
        System.out.println("Exhaustive Tests");
        
        //Some legal trades with the pokemons
        System.out.println("Some legal trades with the pokemons");
        swap3.execute(pokemon1, pokemon11);
        swap4.execute(pokemon1, pokemon7);
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            System.out.println("got interrupted!");
        }
        swap5.execute(pokemon1, pokemon10);
        swap6.execute(pokemon7, pokemon10);
        swap7.execute(pokemon1, pokemon10);
        
        List<Swap> pokemon1SwapList = new ArrayList<Swap>();
        pokemon1SwapList = pokemon1.getSwaps();
        
        for (Swap helpswap : pokemon1SwapList) {
            System.out.println(helpswap.toOutput());
        }
        
        //Testing error messages
        System.out.println("Testing error messages");
        competition1.execute(pokemon1, pokemon2);
        
        //Some legal fights with the pokemons
        System.out.println("Some legal fights with the pokemons");
        competition2.execute(pokemon11, pokemon8);
        competition3.execute(pokemon11, pokemon3);
        competition4.execute(pokemon8, pokemon4);
        
        List<Competition> pokemon11CompetitionList 
                = new ArrayList<Competition>();
        pokemon11CompetitionList = pokemon11.getCompetition();
              
        for (Competition helpCompetition : pokemon11CompetitionList) {
            System.out.println(helpCompetition.toOutput());
        }
    }
}

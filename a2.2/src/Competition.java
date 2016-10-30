import java.util.Random;

/**
* The Class enables the Trainer to fight with there
* Pokemon.
*
* @author Ben
* @version 1.0
*/
public class Competition extends Swap {
    
    /**
     * Constructor of Competition.
     */
    public Competition() {
        this.setId(this.getNextId());
        this.setNextId();
    }
    
    /**
     * The Method enables two Trainer to fight with there Pokemon.
     * For the fight the method has to:
     *     -check if it is allowed to fight with the pokemons.
     *     -check if the pokemons have different Trainers.
     *     -save the date of the fight.
     *     -save the pokemons of the fight.
     *     -save the trainer of the fight.
     * @param pokemon1 object of Pokemon
     * @param pokemon2 object of Pokemon
     */
    public final void execute(final Pokemon pokemon1,
            final Pokemon pokemon2) {      
        this.setTrainer1(pokemon1.getOwner());
        this.setTrainer2(pokemon2.getOwner());
        this.setPokemon1(pokemon1);
        this.setPokemon2(pokemon2);
        
        if (!pokemon1.isSwapAllow()) {
            String name = pokemon1.getName();
            System.out.println("Pokemon " + name 
                    + " ist nicht zum Turnier freigegeben.");
        } else if (!pokemon2.isSwapAllow()) {
            String name = pokemon2.getName();
            System.out.println("Pokemon " + name 
                    + " ist nicht zum Turnier freigegeben.");
        } else if (this.getTrainer1() == this.getTrainer2()) {
            String name1 = pokemon1.getName();
            String name2 = pokemon2.getName();
            System.out.println("Pokemon " + name1 
                    + " kann nicht mit Pokemon " + name2 + " kämpfen,"
                    + " da beide den selben Trainer haben.");
        } else if (pokemon1.getType() == pokemon2.getType()) {
            Random rand = new Random();
            int zufallszahl = rand.nextInt(1);
            if (zufallszahl == 0) {
                this.getTrainer2().removePokemon(pokemon2);
                this.getTrainer1().addPokemon(pokemon2);
                this.getPokemon1().addCompetition(this);
                this.getPokemon2().addCompetition(this);
                this.setDate();
            } else {
                this.getTrainer1().removePokemon(pokemon1);
                this.getTrainer2().addPokemon(pokemon1);
                this.getPokemon1().addCompetition(this);
                this.getPokemon2().addCompetition(this);
                this.setDate();
            }
        } else if (pokemon1.getType().getValue() 
                > pokemon2.getType().getValue()) {
            this.getTrainer2().removePokemon(pokemon2);
            this.getTrainer1().addPokemon(pokemon2);
            this.getPokemon1().addCompetition(this);
            this.getPokemon2().addCompetition(this);
            this.setDate();
        } else {
            this.getTrainer1().removePokemon(pokemon1);
            this.getTrainer2().addPokemon(pokemon1);
            this.getPokemon1().addCompetition(this);
            this.getPokemon2().addCompetition(this);
            this.setDate();
        }
    }
}

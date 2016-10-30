import java.util.Date;


/**
* The Class enables Trainers to swap there
* Pokemon.
*
* @author Ben
* @version 1.0
*/
public class Swap {
    
    /**
     * Attriubte saves the ID of the swap.
     */
    private int id;
    /**
     * Attribute saves the ID of the nextSwap.
     */
    private static int nextId = 1;
    /**
     * Attribute saves the date of the swap.
     */
    private Date date;
    /**
     * Attribute saves the first trainer of the swap.
     */
    private Trainer trainer1;
    /**
     * Attribute saves the second trainer of the swap.
     */
    private Trainer trainer2;
    /**
     * Attribute saves the first pokemon of the swap.
     */
    private Pokemon pokemon1;
    /**
     * Attribute saves the second pokemon of the swap.
     */
    private Pokemon pokemon2;

    /**
     * Construct of Swap.
     */
    public Swap() {
        this.id = nextId;
        nextId += 1;
    }
  
    /**
     * The Method enables two Trainer to switch a Pokemon.
     * For the trade the method has to:
     *     -check if it is allowed to switch the pokemons.
     *     -check if the pokemons are from different type.
     *     -save the date of the trading.
     *     -save the pokemons of the trade.
     *     -save the trainer of the trade.
     * @param pokemon1 object of Pokemon
     * @param pokemon2 object of Pokemon
     */
    public void execute(Pokemon pokemon1, Pokemon pokemon2) {
        Trainer trainer1 = pokemon1.getOwner();
        Trainer trainer2 = pokemon2.getOwner();
        this.trainer1 = trainer1;
        this.trainer2 = trainer2;
        this.pokemon1 = pokemon1;
        this.pokemon2 = pokemon2;
        if (!pokemon1.isSwapAllow()) {
            String name = pokemon1.getName();
            System.out.println("Pokemon " + name 
                    + " ist nicht zum Tauschen freigegeben.");
        } else if (!pokemon2.isSwapAllow()) {
            String name = pokemon2.getName();
            System.out.println("Pokemon " + name 
                    + " ist nicht zum Tauschen freigegeben.");
        } else if (trainer1 == trainer2) {
            String name1 = pokemon1.getName();
            String name2 = pokemon2.getName();
            System.out.println("Pokemon " + name1 
                    + " kann nicht mit Pokemon " + name2 + " getauscht werden,"
                    + " da beide den selben Trainer haben.");
        } else if (pokemon1.getType() == pokemon2.getType()) {
            String name1 = pokemon1.getName();
            String name2 = pokemon2.getName();
            Type type = pokemon1.getType();
            System.out.println("Pokemon " + name1 
                    + " kann nicht mit Pokemon " + name2 + " getauscht werden,"
                    + " da beide vom Typ " + type + " sind.");
        } else {
            trainer1.removePokemon(pokemon1);
            trainer2.removePokemon(pokemon2);
            trainer1.addPokemon(pokemon2);
            trainer2.addPokemon(pokemon1);
            
            pokemon1.addSwap(this);
            pokemon2.addSwap(this);
            
            this.date = new Date();
            //helpdate = date.s
        }
    }
    
    public String toOutput() {
        String helpString = "";
        helpString += "ID: ";
        helpString += this.id;
        helpString += " Date: ";
        helpString += this.date.toString();
        helpString += " Trainer 1: ";
        helpString += this.trainer1.getFirstname() 
                + " " + this.trainer1.getLastname();
        helpString += "\t Trainer 2: ";
        helpString += this.trainer2.getFirstname() 
                + " " + this.trainer2.getLastname();
        helpString += "\t Pokemon 1: ";
        helpString += this.pokemon1.getName();
        helpString += "\t Pokemon 2: ";
        helpString += this.pokemon2.getName();
        
        return helpString;
    }

    /**
     * The method returns the Trainer1 of the trade
     * @return object of Trainer
     */
    public Trainer getTrainer1() {
        return trainer1;
    }

    /**
     * The method sets the Trainer1 of the trade.
     * @param trainer1 object of Trainer
     */
    public void setTrainer1(Trainer trainer1) {
        this.trainer1 = trainer1;
    }

    /**
     * The method returns the Trainer2 of the trade
     * @return object of Trainer
     */
    public Trainer getTrainer2() {
        return trainer2;
    }
    
    /**
     * The method sets the Trainer1 of the trade
     * @param object of Trainer
     */
    public void setTrainer2(Trainer trainer2) {
        this.trainer2 = trainer2;
    }

    /**
     * The method returns the Pokemon1 of the trade
     * @return object of Pokemon
     */
    public Pokemon getPokemon1() {
        return pokemon1;
    }

    /**
     * The method sets the Pokemon1 of the trade
     * @param object of Pokemon
     */
    public void setPokemon1(Pokemon pokemon1) {
        this.pokemon1 = pokemon1;
    }

    /**
     * The method returns the Pokemon2 of the trade
     * @return object of Pokemon
     */
    public Pokemon getPokemon2() {
        return pokemon2;
    }

    /**
     * The method sets the Pokemon1 of the trade
     * @param object of Pokemon
     */
    public void setPokemon2(Pokemon pokemon2) {
        this.pokemon2 = pokemon2;
    }

    /**
     * The method gets the ID of the Swap.
     * @return id is a int
     */
    public int getId() {
        return id;
    }

    /**
     * The method gets the Date of the Swap.
     * @return date is from Type Date.
     */
    public Date getDate() {
        return date;
    }

    /**
     * The method sets the ID of the Swap.
     * @param id is a int
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * The method sets the Date of the Swap.
     * @param date is from Typ java.util.Date
     */
    public void setDate() {
        this.date = new Date();
    }
    
    /**
     * The method gets the nextId of a Swap
     * @return int
     */
    public int getNextId() {
        return nextId;
    }
    
    /**
     * The method sets the nextId of a Swap
     * 
     */
    public void setNextId() {
        nextId += 1;
    }
}

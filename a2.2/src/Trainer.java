import java.util.ArrayList;

public class Trainer {
    
    /**
     * Attribute for the firstname of the Trainer.
     */
    private String firstname;
    /**
     * Attribute for the lastname of the Trainer.
     */
    private String lastname;
    /**
     * Attribute to saves all Pokemon which belongs to the Trainer.
     */
    private ArrayList<Pokemon> pokemonList = new ArrayList<Pokemon>();

    /**
     * Constructor for Trainer which sets the first- and lastname.
     * @param firstname
     * @param lastname
     */
    public Trainer(String firstname, String lastname) {
        setFirstname(firstname);
        setLastname(lastname);
    }

    /**
     * The method returns the firstname of the Trainer.
     * @return the firstname
     */
    public String getFirstname() {
        return firstname;
    }
    
    /**
     * The method changes the firstname of the Trainer.
     * @param firstname the firstname to set
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    
    /**
     * The method returns the lastname of the Trainer.
     * @return the lastname of the Trainer
     */
    public String getLastname() {
        return lastname;
    }
    
    /**
     * The method changes the lastname of the Trainer.
     * @param lastname the lastname to set
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    
    
    /**
     * CAUTION pokemonList is a ArrayList!
     *         no proof if the pokemon is already in the List!
     *         
     * The Method adds a Pokemon to the HashSet List pokemonList.
     * @param pokemon
     */
    public void addPokemon(Pokemon pokemon) {
        this.pokemonList.add(pokemon);
        pokemon.setOwner(this);
    }

    /**
     * The Method returns the first Pokemon of the pokemonList.
     * @return object of pokemon
     */
    public Pokemon getPokemon() {
        Pokemon p = this.pokemonList.get(0);
        this.pokemonList.remove(0);
        return p;
    }

    /**
     * The Method removes the pokemon from the pokemonList.
     * @param pokemon
     */
    public void removePokemon(Pokemon pokemon) {
        int i = this.pokemonList.indexOf(pokemon);
        if (i != -1) {
            this.pokemonList.remove(i);
        } else {
            System.out.println("Fehler: Der Trainer"
                    + " besitzt dieses Pokemon nicht.");
        }
    }

    /**
     * The Method returns all Pokemon of the Trainer.
     * @return ArrayList of Pokemon.
     */
    public ArrayList<Pokemon> getAllPokemon() {
        return this.pokemonList;
    }
}
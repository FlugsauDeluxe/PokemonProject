import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
* The Class describes a Pokemon.
*
* @author Ben
* @version 1.2
*/
public class Pokemon {
    
    /**
     * name save the Name of the Pokemon.
     */
    private String name;
    /**
     * type describes the Type of the Pokemon.
     */
    private Type type;
    /**
     * number is the ID-Number of the Pokemon.
     */
    private int number;
    /**
     * nextnumber is the ID-Number for the next Pokemon, 
     * which will be created.
     */
    private static int nextnumber = 0;  
    /**
     * The Attribute saves the Trainer of the Pokemon.
     */
    private Trainer owner;
    /**
     * The Attribute saves the swaps in which the
     * Pokemon was involved in the past.
     */
    private List<Swap> swaps;
    /**
     * The Attribute saves the competitions on which the Pokemon participated.
     */
    private List<Competition> competitions;
    /**
     * The Attribute decides if it is allowed that
     * the Pokmeon takes part in a swap.
     */
    private boolean swapAllow;
    /**
     * The Attribute saves all Pokemon ordered by Type.
     */
    private static HashMap<Type, Set<Pokemon>> typePokemonMap = 
            new HashMap<Type, Set<Pokemon>>();
     

    /**
     * Constructor for the Object Pokemon.
     * @param name is the parameter to set the Name of the Pokemon
     * @param type sets the Type of the new Pokemon
     */
    public Pokemon(String name, Type type) {
        this.name = name;
        this.type = type;
        this.owner = null;
        this.number = getNextnumber();
        Pokemon.nextnumber++;
        swaps = new ArrayList<Swap>();
        competitions = new ArrayList<Competition>();
        swapAllow = true;
        
        
        Set<Pokemon> pokemonList = typePokemonMap.get(this.type);
        if (pokemonList == null) {
            pokemonList = new HashSet<Pokemon>();
        }
        pokemonList.add(this);
        typePokemonMap.put(this.type, pokemonList);
    }

    /**
     * getName() returns the name of the Pokemon.
     * @return the name of the Pokemon
     */
    public String getName() {
        return name;
    }

    /**
     * setName changes the name of the Pokemon.
     * @param name the new name for the Pokemon
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * getType returns the Type of the Pokemon.
     * @return the type returns the Type of the Pokemon
     */
    public Type getType() {
        return type;
    }

    /**
     * The Method sets the Type of the Pokemon.
     * @param type the type to set
     */
    public void setType(Type type) {
        this.type = type;
    }

    /**
     * The Method returns the number, which the next Pokemon
     * will be assigned.
     * @return the nextnumber
     */
    public static int getNextnumber() {
        return nextnumber;
    }
    
    /**
     * The Method returns the value of the Pokemon number (ID).
     * @return The return value is from type int
     */
    
    public int getNumber() {
        return number;
    }

    /**
     * The method writes the Pokemon attributes from the Object into a String.
     * @return helpString is the String with the Pokemon attributes
     */
    public String attributesToString() {
        String helpString = "";
        helpString += name;
        helpString += type;
        helpString += number;
        helpString += nextnumber;
        
        return helpString;
    }

    /**
     * The Method returns if it is possible to swap the Pokemon.
     * @return the swapAllow
     */
    public boolean isSwapAllow() {
        return swapAllow;
    }

    /**
     * This Method sets if it is or if it is not possible to swap the Pokemon.
     * @param swapAllow the swapAllow to set
     */
    public void setSwapAllow(boolean swapAllow) {
        this.swapAllow = swapAllow;
    }

    /**
     * This Method returns the List of swaps in which the
     * Pokemon was involved in the past.
     * @return List of Swap objects
     */
    public List<Swap> getSwaps() {
        return swaps;
    }

    
    /**
     * The Method adds the swap to the Swap List.
     * The Swap List documents all swaps inwhich the pokemon was involved.
     * @param swap
     */
    public void addSwap(Swap swap) {
        swaps.add(swap);
    }
    
    /**
     * This Method returns the List of competitions in
     * which the Pokemon has fought in the past.
     * @return List of Swap objects
     */
    public List<Competition> getCompetition() {
        return competitions;
    }

    
    /**
     * The Method adds the competition to the competition List.
     * The competitions List documents all competitions in
     * which the pokemon has fought.
     * @param competition 
     */
    public void addCompetition(Competition competition) {
        competitions.add(competition);
    }

    /**
     * The Method returns the owner of the Pokemon.
     * If the Pokemon has no owner the method returns null.
     * @return object of Trainer
     */
    public Trainer getOwner() {
        return owner;
    }

    /**
     * The Method sets the owner of the Pokemon.
     * @param owner object of Trainer
     */
    public void setOwner(Trainer owner) {
        this.owner = owner;
    }
    
    /**
     * The method showes all Pokemon of the given Type.
     * @param type has to be a element of Type
     * @return is a Collection of Pokemon
     */
    public Collection<Pokemon> getPokemonWithType(Type type) {
        return typePokemonMap.get(type);
    }
}
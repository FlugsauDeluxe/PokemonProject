
public enum Type {
    Fire(0),
    Water(5),
    Poison(10);
    
    private int value;
    
    private Type(int ordervalue) {
        this.value = ordervalue;
    }
    
    public int getValue() {
        return value;
    }
}

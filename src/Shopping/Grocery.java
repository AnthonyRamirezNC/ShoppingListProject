package Shopping;

/**
 * @version Spring 2019
 * @author Paul Franklin, Kyle Kiefer
 */
public class Grocery implements Comparable<Grocery> {

    private String name;
    private String category;
    private int aisle;
    private float price;
    private int quantity;

    /**
     * Constructor of Entry object. Objects that match name and
     * category are considered identical
     *
     * @param name the name of the item in the entry
     * @param category the category of the item in the entry
     */
    public Grocery(String name, String category) {
        setName(name);
        setCategory(category);
        setAisle(-1);
        setPrice(0.0f);
        setQuantity(0);

    }

    /**
     * Constructor of Entry object.
     *
     * @param name the name of the item in the entry
     * @param category the category of the item in the entry
     * @param aisle the aisle where the item in the entry is located
     * @param price the price of the item in the entry
     * @param quantity the quantity of the item to purchase
     */
    public Grocery(String name, String category, int aisle, float price,
            int quantity) {
        this(name, category);
        setAisle(aisle);
        setPrice(price);
        setQuantity(quantity);
    }
    
    /**
     * Copy constructor
     * 
     * @param another  An existing grocery object to copy
     */
    public Grocery(Grocery another) {
        setName(another.getName());
        setCategory(another.getCategory());
        setAisle(another.getAisle());
        setPrice(another.getPrice());
        setQuantity(another.getQuantity());
    }
    
    /**
     * Gets the name of the item.
     *
     * @return the name of the item
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the item.
     *
     * @param name the name of the item
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the category of the item.
     *
     * @return the category of the item
     */
    public String getCategory() {
        return category;
    }

    /**
     * Sets the category of the item.
     *
     * @param category the category of the item
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * Gets the aisle of the item.
     *
     * @return the aisle of the item
     */
    public int getAisle() {
        return aisle;
    }

    /**
     * Sets the aisle of the item.
     *
     * @param aisle the aisle of the item
     */
    public void setAisle(int aisle) {
        this.aisle = aisle;
    }

    /**
     * Gets the price of the item.
     *
     * @return the price of the item
     */
    public float getPrice() {
        return price;
    }

    /**
     * Sets the price of the item.
     *
     * @param price the price of the item
     */
    public void setPrice(float price) {
        this.price = price;
    }

    /**
     * Gets the quantity of the item.
     *
     * @return the quantity of the item
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets the quantity of the item.
     *
     * @param quantity the quantity of the item
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Returns a string representing this object.
     *
     * @return a string representation of this object
     */
    @Override
    public String toString() {
        return "Entry{" + "name=" + name + ", category=" + category
                + ", aisle=" + aisle + ", price=" + price + ", quantity="
                + quantity + '}';
    }

    /**
     * Compare the object itself with the input parameter object
     * Returns zero if both are logically equal
     * Returns 1 if the object itself is logically larger than 
     *     input parameter object
     * Returns -1 if the object itself is logically smaller than 
     *     input parameter object
     * @param  Grocery t
     *         An object to compare
     * @return an int 0, 1, or -1
     */
    @Override
    public int compareTo(Grocery t) {
        if (this.getName().compareToIgnoreCase(t.getName()) == 0) {
            return this.getCategory().
                    compareToIgnoreCase(t.getCategory());
        }
        return this.getName().compareToIgnoreCase(t.getName());
    }

    /**
     * Evaluate whether the object itself is logically equal to 
     * the input parameter object
     * Returns true if the object itself is logically equal to the
     *     input parameter object. Or else return false
     * @param  Object o
     *         An object to compare
     * @return a boolean value: true or false
     */
    @Override
    public boolean equals(Object o) {
        // If the object is compared with itself then return true   
        if (o == this) { 
            return true; 
        } 
  
        /* Check if o is an instance of Complex or not 
          "null instanceof [type]" also returns false */
        if (!(o instanceof Grocery)) { 
            return false; 
        } 
        
        Grocery temp = (Grocery) o;
        return this.compareTo(temp) == 0;
    }
}

/** 
    * The class created GraphicsCards(s) that contain a name and the quanity of
    * of them. 
    * Funcitons include: getters/setters, toString implementation, equals
    * and compareTo.
    * @author Parker Talley
*/

package assignment4;

public class GraphicsCards implements Comparable<GraphicsCards> {
    /**
        * Stores the name/model of the graphics cards.
    */
    private String name;
    
    /**
        * Stores the quanity/number of graphics cards
    */
    private int quanity;

    public GraphicsCards(String name, int quanity) {
        // Stores the name of the graphics cards.
        this.name = name;
        
        // Stores the quanity of graphics cards.
        this.quanity = quanity;
    }

    // Getters
    public String getName() {
        return name;
    }
    public int getQuanity() {
        return quanity;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }
    public void setQuanity(int quanity) {
        this.quanity = quanity;
    }

    public String toString() {
        return getName() + " " +  getQuanity();
    }

    /**  
        * Attempts to add movie object to disruibutor movies array, overloaded.  
        * @param comparingObject name of object to compare against.
        * @return false if object is null OR is not a instance of GraphicsCards
        * OR if compareObject name and quanity are not equal; true if 
        * compareObject name and quanity are equal.
    */
    public boolean equals(GraphicsCards comparingObject) {
        if(comparingObject != null && comparingObject instanceof GraphicsCards) {
            GraphicsCards compareGraphicsCards = (GraphicsCards) comparingObject;
            return getName().equalsIgnoreCase(compareGraphicsCards.getName()) &&
                getQuanity() == compareGraphicsCards.getQuanity();
        }
        else {
            return false;
        }
    }
    /**  
        * Compares the object that called the function and another object that 
        * is passed through as a parameter.   
        * @param comparingObject name of object to compare against.
        * @return 0: if the objects are equal; 1: if the calling object is
        * greater than the comparingObject; -1: if the calling object is less 
        * than the compareingObject.
    */
    @Override
    public int compareTo(GraphicsCards comparingObject) {
        if(this.equals(comparingObject)) {
            return 0;
        }
        // If the two objects have the same name, the statements below are ran.
        if(this.name.equalsIgnoreCase(comparingObject.name)) { 
            if(this.quanity > comparingObject.quanity){
                return 1;
            }
            else {
                return -1;
            }
        }
        else {
            // Calls default compareTo method to compare strings.
            if(this.name.compareTo(comparingObject.name) > 0) { 
                return 1;
            }
            else {
                return -1;
            }
        }
    }
}

/*
* Example of class structure.
*/
public class Animal {                       // Defining an Animal class.
    
    String name;                            // Define a field named name of type String.

    public String getName() {               // GetName method signature that return an String object.
        return this.name;
    }

    public void setName(String newName) {   // SetName method signature with one parameter newName 
        this.name = name                    // of type String that return void.
    }

}
// ENCAPSULATION and Getters and Setters
// Read: https://www.w3schools.com/java/java_encapsulation.asp

public class GetSetTester {
    public static void main(String[] args) {

        //create a new object for my GetSet class
        GetSet name = new GetSet();

        System.out.println(name.getUsername()); //displays default username value of null
        name.setUsername("pineappleghost333"); //sets (or mutates) username to new value
        System.out.println(name.getUsername()); //displays new username 
        
    }
}

class GetSet{
    //instance variables; attributes; making the instance 'private' enforces ENCAPSULATION
    private String username;

    //accesor methods aka GETTERS:
    public String getUsername(){
        return username;
    }
    
    //mutator methods aka SETTERS
    public void setUsername(String newUsername){
        this.username = newUsername;
    }

}
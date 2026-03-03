import java.util.Scanner;

public class GetSetTester2 {

    public static void main(String[] args){

        Scanner input = new Scanner(System.in);

        GetSet player1 = new GetSet();
        GetSet player2 = new GetSet();
        GetSet player3 = new GetSet();

        System.out.println(player1.getUsername());
        player1.setUsername("smokeythebandit2323");
        System.out.println(player1.getUsername());
        player1.setUsername("pineappleghost323");
        System.out.println(player1.getUsername());

    }

}

class GetSet {

    //attributes
    private String username; // null
    private int id; //0

    //getter 
    public String getUsername(){
        return username;
    }

    //setter 
    public void setUsername(String newUsername){
        this.username = newUsername;
    }

}
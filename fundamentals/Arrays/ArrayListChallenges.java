import java.util.ArrayList;
import java.util.Scanner;
public class ArrayListChallenges {

    public static void main(String[] args) {
	
	Challenges.randomList();
	Challenges.sofiasolution();
	Challenges.lucasolution();

    }
}

class Challenges {

	// CHALLENGE 1 
		
    // Filter out all odd numbers from a list
	// Create a arraylist with 10 random numbs
	// and remove all odds


	public static void mjsolution(){
		ArrayList<Integer> myList = new ArrayList<Integer>();
		int randomNum = 0;
		for(int i = 0; i<10;i++){
			randomNum = (int)(Math.random()*11);
			myList.add(randomNum);
		}
		System.out.println("Random List"+myList);
		for(int j = myList.size() - 1; j >= 0; j--){
			System.out.println("increment j:"+ j );

			if (myList.get(j)%2 != 0){
				myList.remove(j);
				System.out.println("decrement j:"+ j );
			}
		}

		System.out.println("New list" + myList);

	}
	//CHALLENGE 2
	// make a guest list that allows the user to enter names
	// if the name exist tell the use "this person is invited"
	// continue until you type exit

		public static void sofiasolution(){
			ArrayList<String> guestList = new ArrayList<>();
			Scanner input = new Scanner(System.in);
			System.out.println("\nWho is invited?");
			String line = input.nextLine();
			while (!line.equalsIgnoreCase("exit")){
				guestList.add(line);
				line = input.nextLine();
			}
			System.out.println("Who do you want to check for in the guest list?");
			line = input.nextLine();
			while (!line.equalsIgnoreCase("exit")){
				if (guestList.contains(line)){
					System.out.println("They are invited!");
				} else {
					System.out.println("They are not invited.");
				}
				line = input.nextLine();
			}
		}

		public static void lucasolution() {
			
			ArrayList<String> guestList = new ArrayList<String>();

			String name = "";

			Scanner input = new Scanner(System.in);
			while (!name.equals("exit"))
			{
				name = input.nextLine();
				if (!name.equalsIgnoreCase("exit") && !guestList.contains(name))
				{
					guestList.add(name);
				}
				else {
					System.out.println("this person is invited! ");
					
				}
			}
		}

}

//Iteration in Java

public class Loops {

	public static void main(String[] args) {
		// for loops contain 3 parts
		// First part contains a init of a variable
		// This varible has to be able to be compared to increase or decrease
		// i.e. int, char, etc.

		// Along with this it needs a comparision 
		// and to increase or decrease
		// So,

		for (int index = 0; index < 5; index++) {
			System.out.print(index);
		}
		System.out.println();

		// For this loop it starts at 0 and goes up to 4 for 5 indexes
		// so 0 1 2 3 4. 
		// becuase index (usually written as i) is less than 5 and not <= to it doesn't go up to 5

		// This for loop would iterate 6 times due to it being <=
		for (int index = 0; index <= 5; index++) {
			System.out.print(index);
		}
		System.out.println();

		// The starting index can also change 
		// this array would be 3 indexes
		// 2 3 4
		for (int index = 2; index < 5; index++) {
			System.out.print(index);
		}
		System.out.println();

		// Along with this the iteration can also change

		// decrease by 1 each time
		for (int index = 5; index > 2; index--) {
			System.out.print(index);
		}
		System.out.println();

		// decrease by 2 each time
		for (int index = 6; index > 0; index -= 2) {
			System.out.print(index);
		}
		System.out.println();

		// increase by 2 each time
		for (int index = 2; index < 10; index += 2) {
			System.out.print(index);
		}
		System.out.println();

		// For loops can also be nested, so for each i index it iterates j times
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				System.out.print("(" + row + "," + col + ") ");
			}
			System.out.println();
		}

		// While loops take a boolean operator and continue until it is false

		// this loop would run infinitly
		int num = 0;
		while (true) {
			System.out.println("while(true) iteration");
			num++;
			if (num == 3) {
				break;
			}
		}

		// This loop would run 5 times until it stops 
		int counter = 0;
		while (counter < 5) {
			System.out.print(counter);
			counter++;
		}
		System.out.println();

		// 3 loop control commands
		// break, continue, return

		// continue skips the rest of the statements in the loop and goes onto the next indicies
		// for this loop it would be 
		// 0 1 3 4
		for (int value = 0; value < 5; value++) {
			if (value == 2) {
				continue;
			}
			System.out.print(value + " ");
		}
		System.out.println();

		// break stops the loop entirely
		// 0 1 
		for (int value = 0; value < 5; value++) {
			if (value == 2) {
				break;
			}
			System.out.print(value);
		}
		System.out.println();

		// return works for break but it is much stronger
		// break only works for the loop given but return stops the entire function and both loops
		
		for (int outer = 0; outer < 5; outer++) {
			for (int inner = 0; inner < 5; inner++) {
				System.out.println("return triggered");
				return;
			}
		}

        // Challenge 1
        // Foobar
        // count from 1 to 100
        // if i % 3 print "foo"
        // if i is divisble by 5 print "bar"
        // if both divisble by 3 and 5 print "foobar"
        
        // Challenge 2
        // Print out a multiplication table from 1 -12 
        // HINT: use nested for-loops to create rows/columns
        // 1 2 3 ..
        // 2 4 6..
        // 3 6 9...

        // Challenge 3 - while loop
        // Design a guessing game between 3 numbers. 
        // if you guess the number correctly then you win
        // if not then keep playing the game.
        // Example: answer is 2
        // input: 1 -> "wrong answer"
        // input: 2 -> "correct answer"
	}

}


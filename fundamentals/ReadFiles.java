import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * Reading text files with Scanner -- AP CS A Unit 4.6
 * Requires lorem.txt and grades.txt in the same directory.
 */
public class ReadFiles {
    public static void main(String[] args) throws IOException {
        // this is where your .txt files should live:
        System.out.println("Working dir: " + System.getProperty("user.dir"));
        TextReader lorem  = new TextReader("lorem.txt");
        TextReader grades = new TextReader("grades.txt");
        System.out.println("Lines");
        lorem.printAllLines();
        System.out.println("\nWords");
        lorem.printAllWords();
        System.out.println("\nLine count:           " + lorem.countLines());
        System.out.println("Word count:           " + lorem.countWords());
        System.out.println("Words longer than 6:  " + lorem.countWordsLongerThan(6));
        System.out.println("\nScores");
        System.out.println("Scores:   " + grades.readScores());
        System.out.println("Average:  " + grades.averageScore());
    }
}

// Every method below uses the SAME Scanner methods you'd use for keyboard input.
// The only difference is the constructor:
//      new Scanner(System.in)        -- reads from the keyboard
//      new Scanner(new File("..."))  -- reads from a file
// Once the Scanner is built, the rest of the code is interchangeable.
class TextReader {
    private String filename;

    public TextReader(String filename) {
        this.filename = filename;
    }

    // Read line by line. nextLine() is the same call you'd use after a prompt.
    public void printAllLines() throws IOException {
        Scanner s = new Scanner(new File(filename));
        while (s.hasNextLine()) {
            System.out.println(s.nextLine());
        }
        s.close();
    }

    // Read token by token. next() returns one whitespace-delimited word --
    // identical to reading a single word from the keyboard.
    public void printAllWords() throws IOException {
        Scanner s = new Scanner(new File(filename));
        while (s.hasNext()) {
            System.out.println(s.next());
        }
        s.close();
    }

    // Accumulator over lines. nextLine() is still required inside the loop --
    // reading is what advances the Scanner.
    public int countLines() throws IOException {
        Scanner s = new Scanner(new File(filename));
        int count = 0;
        while (s.hasNextLine()) {
            s.nextLine();
            count++;
        }
        s.close();
        return count;
    }

    // Same shape as countLines, but tokens instead of lines.
    public int countWords() throws IOException {
        Scanner s = new Scanner(new File(filename));
        int count = 0;
        while (s.hasNext()) {
            s.next();
            count++;
        }
        s.close();
        return count;
    }

    // Read + filter + count. The canonical FRQ pattern.
    public int countWordsLongerThan(int minLength) throws IOException {
        Scanner s = new Scanner(new File(filename));
        int count = 0;
        while (s.hasNext()) {
            if (s.next().length() > minLength) count++;
        }
        s.close();
        return count;
    }

    // grades.txt: each line is "Name score".
    // Mixed-type read -- exactly the pattern you'd use prompting a user for a
    // name and an age:
    //      String name = sc.next();
    //      int    age  = sc.nextInt();
    // Only difference from using Scanner to : the Scanner is wrapped around a File, not System.in.
    public ArrayList<Integer> readScores() throws IOException {
        Scanner s = new Scanner(new File(filename));
        ArrayList<Integer> scores = new ArrayList<>();
        while (s.hasNext()) {
            s.next();                      // skip the name
            scores.add(s.nextInt());
        }
        s.close();
        return scores;
    }

    // sum is declared as double so sum/count uses double division, not int truncation.
    public double averageScore() throws IOException {
        Scanner s = new Scanner(new File(filename));
        double sum = 0;
        int count = 0;
        while (s.hasNext()) {
            s.next();
            sum += s.nextInt();
            count++;
        }
        s.close();
        return sum / count;
    }
}
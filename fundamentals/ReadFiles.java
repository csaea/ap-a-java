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


class TextReader {
    private String filename;

    public TextReader(String filename) {
        this.filename = filename;
    }

    public void printAllLines() throws IOException {
        Scanner s = new Scanner(new File(filename));
        while (s.hasNextLine()) {
            System.out.println(s.nextLine());
        }
        s.close();
    }

    public void printAllWords() throws IOException {
        Scanner s = new Scanner(new File(filename));
        while (s.hasNext()) {
            System.out.println(s.next());
        }
        s.close();
    }

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

    public int countWordsLongerThan(int minLength) throws IOException {
        Scanner s = new Scanner(new File(filename));
        int count = 0;
        while (s.hasNext()) {
            if (s.next().length() > minLength) count++;
        }
        s.close();
        return count;
    }

    // grades.txt: each line is "Name score"
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
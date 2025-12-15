
// In Java, strings are not primitive data types! A String is a class that 'strings togeter' a bunch of characters.
// They are their own class, with many built-in methods for string manipulation.
// "String literal" refers to any of the characters set in quotation marks. 
// NEVER use double equals (==) to compare strings. Always use .equals()
// Link to unicode chart: https://www.ssec.wisc.edu/~tomw/java/unicode.html#x0000

public class Strings {

    public static void main(String[] args) {

        // Strings are object classes. We can make a string with normal object construction like this:
        String nameObj = new String("Didi"); //String as whole new object. (We rarely use this). 

        // 0 1 2 3
        // D i d i

        //BUT it's more common to simply use STRING LITERALS like this:
        String name1 = "Didi";
        String name2 = "Gogo";
        String name3 = "Gogo"; 

        System.out.println("name1.equals(nameObj): " + name1.equals(nameObj)); //false because we are comparing two different objects in memory.
        System.out.println("name1.equals(name2): " + name1.equals(name2));
        System.out.println("name2.equals(name3): " + name2.equals(name3));

        // BEWARE, never use == to :
        System.out.println("name1 == nameObj: " + (name1 == nameObj));  // NEVER DO THIS. == is for numbers, this is comparing memory address, so this is false.
        System.out.println("name2 == name3: " + (name2 == name3)); // Even though it works in some cases, like here (string pool/ref), but not all (objs). 

        // compareTo for comparing lexicography (alphabetically) in UNICODE, uppercase before lowercase
        System.out.println("Compare: " + name1.compareTo(name2)); // returns -3 because Didi comes 3 letters before Gogo

        // CONCATENATION
        String friends = name1 + " and " + name2;
        System.out.println("Concatenation: " + friends);  

        // HELPFUL BUILT-IN METHODS
        System.out.println("# of chars in string: " + name1.length());
        System.out.println("Index select: " + name2.indexOf("o")); //Experiment with this
        System.out.println("Character select: " + name2.charAt(2));

        // SUBSTRINGS --n.substring() is an Overloaded Method
        String quote = "Talk is cheap, show me the code";
        String result1 = quote.substring(15);
        String result2 = quote.substring(5, 13);

        System.out.println("Full quote: " + quote);
        System.out.println("Substring 1: " + result1);
        System.out.println("Substring 2: " + result2);

        // MORE BUILT IN METHODS
        String character = "spOngEBOB SQuarePaNts";
        System.out.println("Uppercase: " + character.toUpperCase());
        System.out.println("Lowercase: " + character.toLowerCase());
        System.out.println("Contains 'Squidward'? " + character.contains("Squidward"));
        System.out.println("Replaced name: " + character.replace("spOngEBOB", "sqUidWaRD"));

        // ESCAPED CHARACTERS

        System.out.println("Name:\tAda Lovelace\nRole:\tFirst Programmer Ever\nYear:\t1843");

    }
}


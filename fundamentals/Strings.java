public class Strings {
    public static void main(String[] args){

        String nameObj = new String("Didi");

        //0 1 2 3
        //D i d i

        String name1 = "Didi";
        String name2 = "Gogo";
        String name3 = "Gogo";

        // First line will be false
        System.out.println("name1 and nameObj:" + (name1 == nameObj));
        System.out.println("name1 and nameObj:" + name1.equals(nameObj));
        System.out.println("name1.equals(name2): " + name1.equals(name2));
        System.out.println("name2 and name3:" + (name2 == name3));

        //compareTo 
        System.out.println("Compare: " + name1.compareTo(name3));

        // HELPFUL BUILT-IN METHODS
        System.out.println("# of chars in string: " + name1.length());
        
        System.out.println("Index select: " + name2.indexOf("o")); //Experiment with this
        System.out.println("Character select: " + name2.charAt(2));        

        String quote = "Talk is cheap, show me the code.";
        String result1 = quote.substring(15);
        String result2 = quote.substring(5,13);

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

// Remember primitive data types? int, boolean, char, etc.? 
// These are nice and simple, fast, and reliable. But they have no behaviors. They are static, not dynamic. 
// Wrapper classes store objects that contain primitive values and provide utility methods. 
// Ex Integer, Double, Boolean, Character, Long, Float, Short, Byte
// part of java.lang (but you don't have to import)

public class WrapperClassesTester {
    public static void main(String[] args){

        Wrapper.demoInteger();
        Wrapper.demoBoolean();
        Wrapper.autoBoxingDemo();
    }
}

class Wrapper {

    // demo Integer, Double, and Boolean in separate methods

    public static void demoInteger() {
        int primitiveInt = 10;
        Integer myInt = 5;

        System.out.println("Primitive int: " + primitiveInt);
        System.out.println("Wrapper Integer: " + myInt);

        System.out.println("Max int value: " + Integer.MAX_VALUE);
        System.out.println("Min int value: " + Integer.MIN_VALUE);

        int parsed = Integer.parseInt("25");
        int add = parsed + 5;
        System.out.println("Parsed from String: " + parsed);
        System.out.println("Added from String: " + add);

    }

    public static void demoBoolean() {

        boolean primitiveBool = true;
        Boolean wrapperBool = Boolean.valueOf(true);

        System.out.println("Primitive boolean: " + primitiveBool);
        System.out.println("Wrapper Boolean: " + wrapperBool);

        boolean parsed = Boolean.parseBoolean("false"); 
        System.out.println("Parsed bool:" + parsed);

    }

    public static void autoBoxingDemo(){

        //Autoboxing: takes primitive data type --> wraps it in Integer class
        Integer num = 5; 

        // Unboxing: wrapper --> primitive 
        int value = num;

        System.out.println("Autoboxed Integer: " + num);
        System.out.println("Unboxed int: " + value);

    }

}
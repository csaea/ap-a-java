// Java is a STRONGLY TYPED language; you have to DEFINE/DECLARE a variable
// you have to declare its DATA TYPE

class DataTypeExamples {
        int myInt = 42;
        double myDouble = 189.75;
        char myChar = 'Q';
        boolean myBool = false;
}

public class DataTypes {
    public static void main(String[] args) {
         DataTypeExamples dt = new DataTypeExamples();
         System.out.println("myInt: " + dt.myInt);     
         System.out.println("myDouble: " + dt.myDouble);
         System.out.println("myChar: " + dt.myChar);
         System.out.println("myBool: " + dt.myBool);
         
    }
}
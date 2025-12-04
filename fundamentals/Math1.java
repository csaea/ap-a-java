class Calculator {

    //write functions for addition, subtraction, multiplication, diviision, etc
    int add(int a, int b) {
        return a + b;
    }

    int subtract(int a, int b) {
        return a -b;
    }

    int multiply(int a, int b) {
        return a * b;
    }

    
    int divide(int a, int b) {
        return a / b;
    }
    // METHOD OVERRIDING -- POLYMORPHISM
    double divide(double a, double b) {
        return a / b;
    }

    int modulo(int a, int b) {
        return a % b;
    }


}


public class Math1 {
    public static void main(String[] args) {

        Calculator calc = new Calculator();

        System.out.println(calc.add(10, 5));
        System.out.println(calc.subtract(10, 5));
        System.out.println(calc.multiply(10, 5));
        System.out.println(calc.divide(10, 5));
        System.out.println(calc.divide(10.36, 5.43));


        System.out.println(calc.modulo(10, 4));

    }
}

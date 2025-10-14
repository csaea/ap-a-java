class Car {
    String model;
    int price;

    public String toString() {
        return model + ":" + price;
    }

    }

public class ToString {

    public static void main(String a[]) {

        Car obj1 = new Car();
        obj1.model = "Nucleon";
        obj1.price = 10000000;

        Car obj2 = new Car();
        obj2.model = "Nucleon0";
        obj2.price = 10000;

        System.out.println(obj1.toString());
        System.out.println(obj2.toString());
    }
}    



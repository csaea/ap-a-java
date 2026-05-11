public class Recursion {
    public static void main(String[] args) {

    // tester class
    RecursionAlgos r = new RecursionAlgos();
    r.countDown(5);

    }
}

class RecursionAlgos {

    //Infinite recursion -- no base case. only recursive case.
    public void infinite() {
        infinite();
    }

    public void countDown(int n) {

        //base case:
        if (n <= 0) 
        {
            System.out.println("Hit base case.");
            return;
        }

        System.out.println("stacking up n: " + n);
        countDown(n - 1);
        // after we return, everthing AFTER the recusrive call can run:
        System.out.println("unstacking!" + n);
    
    }

}

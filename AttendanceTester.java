// TO work with multiple classes in one file:
// Filename must match Tester class na,e.


public class AttendanceTester {
   public static void main(String[] args) {

      System.out.println("HIIIIII");
      // write code to create two AttendanceRecord objects:
      // one named "Jordan" with 4 days present
      // one named "Riley" with 7 days present
 
      // mark Jordan present once more
 
      // print attendance for both students
   }
}


class AttendanceRecord {
   private String name;
   private int daysPresent;
 
   public AttendanceRecord(String n, int d) {
      name = n;
      daysPresent = d;
   }
 
   public void markPresent() {
      daysPresent++;
   }
 
   public void printAttendance() {
      System.out.println(name + " — Days Present: " + daysPresent);
   }
}


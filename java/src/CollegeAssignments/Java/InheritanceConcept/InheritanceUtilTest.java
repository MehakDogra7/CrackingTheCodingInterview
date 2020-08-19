package CollegeAssignments.Java.InheritanceConcept;

public class InheritanceUtilTest {

    public static void main(String[] args) {
        Vehicle.printClass();
        Bus.printClass();

        Vehicle v = new Vehicle();
        System.out.println(v.string());
        System.out.println(v.onlyParent());
        v.printClass(); // - Will give Vehicle

        System.out.println("========================================");
        v = new Bus();
        v.printClass(); // - Will give Vehicle
        new Bus().printClass(); // - Will give Bus
        System.out.println(v.string());
        System.out.println(v.onlyParent());
        System.out.println(new Bus().onlyChild());

        //Can not call methods that are only in Bus with Vehicle instance: Error --> v.onlyChild; Convert it to Bus b object to access
        Bus b = (Bus) v;
        System.out.println(b.onlyChild());

        //Can call static methods using object
    }
}

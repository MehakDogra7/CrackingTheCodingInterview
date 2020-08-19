package CollegeAssignments.Java.InheritanceConcept;

public class Bus extends Vehicle {

    public static void printClass() {
        System.out.println("Bus");
    }

    @Override
    public String string() {
        return "Bus ToString";
    }

    public String onlyChild() {
        return "Only Child";
    }
}

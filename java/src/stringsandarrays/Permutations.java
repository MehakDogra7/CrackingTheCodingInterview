package stringsandarrays;

public class Permutations {

    public static void main(String[] args) {
        String str = "abc";

        System.out.println("All permutations of string " + str + " are: ");
        printPermutation(str, "");
    }

    private static void printPermutation(String str, String prefix) {
        if (str.length() == 0) {
            System.out.println(prefix);
        } else {
            for (int i = 0; i < str.length(); i++) {
                String rem = str.substring(0, i) + str.substring(i + 1);
                printPermutation(rem, prefix + str.charAt(i));
            }
        }
    }
}

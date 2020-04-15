public class StringRotation {

    public static void main(String[] args) {

        String s1 = "waterbottle";
        String s2 = "erbottlewat";

        System.out.println("Is " + s2 + " rotation of " + s1 + " : " + isRotatedString(s1, s2));
    }

    private static boolean isRotatedString(String s1, String s2) {
        return isSubString(s1 + s1, s2);
    }

    private static boolean isSubString(String main, String sub) {
        return main.contains(sub);
    }
}

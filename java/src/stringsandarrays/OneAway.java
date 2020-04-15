package stringsandarrays;

public class OneAway {

    public static void main(String[] args) {
        String s1 = "plbs";
        String s2 = "pabs";

        System.out.println("Is " + s1 + " one or zero away from " + s2 + ": " + isOneAway(s1, s2));

    }

    private static boolean isOneAway(String s1, String s2) {

        int diff = s1.length() - s2.length();
        if (diff != 1 && diff != 0 && diff != -1) {
            return false;
        }

        int i = 0, j = 0, count = 0;
        while (i < s1.length() && j < s2.length()) {
            if (count > 1) {
                return false;
            }
            if (s1.charAt(i) == s2.charAt(j)) {
                i++;
                j++;
            } else {
                if (s1.length() == s2.length()) {
                    i++;
                    j++;
                } else {
                    if (s1.length() > s2.length()) {
                        i++;
                    } else {
                        j++;
                    }
                }
                count++;
            }
        }
        return true;
    }
}

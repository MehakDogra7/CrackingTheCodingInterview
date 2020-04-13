public class IsPermPalindrome {

    public static void main(String[] args) {
        String s1 = "taco act";

        System.out.println("Is permutation palindrome of " + s1 + ": " + isPermPalindrome(s1));
    }

    private static boolean isPermPalindrome(String s1) {

        int[] ar = new int[128];

        for (char c1 : s1.toCharArray()) {
            if (c1 != ' ') {
                ar[c1] += 1;
            }
        }
        int oddCount = 0;
        for (int a : ar) {
            if (a % 2 != 0) {
                oddCount++;
            }
            if (oddCount > 1) {
                return false;
            }
        }
        return true;
    }
}

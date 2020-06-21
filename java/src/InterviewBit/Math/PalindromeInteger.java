package InterviewBit.Math;

public class PalindromeInteger {

    public static void main(String[] args) {

        int n = 123;
        System.out.println(isPalindrome(n));
        System.out.println(isPalindrome(Integer.parseInt(args[0])));
    }


    private static int isPalindrome(int A) {

        int rev = 0;
        int temp = A;
        while (temp > 0) {
            int x = temp % 10;
            rev = rev * 10 + x;
            temp /= 10;
        }
        return rev == A ? 1 : 0;
    }
}

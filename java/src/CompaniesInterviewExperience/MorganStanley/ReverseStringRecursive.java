package CompaniesInterviewExperience.MorganStanley;

public class ReverseStringRecursive {

    public static void main(String[] args) {
        String A = "Hello";
        System.out.println(reverse(A));
    }

    private static String reverse(String A) {
        if(A.length() == 0) return "";
        return reverse(A.substring(1)) + A.charAt(0);
    }
}

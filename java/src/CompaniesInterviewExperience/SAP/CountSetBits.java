package CompaniesInterviewExperience.SAP;

public class CountSetBits {

    public static void main(String[] args) {
        int n = 7;
        System.out.println(new CountSetBits().count(n));
    }

    private int count(int n) {
        int count = 0;
        for (int i = 0; Math.pow(2, i) <= n; i++) {
            if ((n & (1 << i)) == (1 << i)) count++;
        }

        return count;
    }
}

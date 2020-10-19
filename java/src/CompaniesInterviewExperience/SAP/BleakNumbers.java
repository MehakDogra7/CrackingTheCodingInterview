package CompaniesInterviewExperience.SAP;

public class BleakNumbers {

    public static void main(String[] args) {

    }

    public int is_bleak(int n) {
        // Code here
        int ceil = (int) Math.ceil(Math.log(n) / Math.log(2));
        for (int i = n - ceil; i < n; i++) {
            if (i + countSetBits(i) == n) return 0;
        }
        return 1;
    }

    public int countSetBits(int n) {
        int count = 0;
        for (int i = 0; Math.pow(2, i) <= n; i++) {
            if ((n & (1 << i)) == (1 << i)) count++;
        }

        return count;
    }


}

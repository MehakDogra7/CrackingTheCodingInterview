package InterviewBit.Math;

public class TrailingZeroesInFact {

    public static void main(String[] args) {

        System.out.println(new TrailingZeroesInFact().trailingZeroes(9247));
    }

    public int trailingZeroes(int A) {

        int count = 0;
        int j = 1;
        int temp = 1;
        while (temp > 0) {
            temp = (int) (A / Math.pow(5, j++));
            count += temp;
        }

        return count;
    }
}

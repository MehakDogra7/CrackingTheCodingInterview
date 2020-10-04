package InterviewBit.GreedyAlgorithm;

public class HighestProduct {
    public static void main(String[] args) {
        int[] A = {10, -1, 3, 20};
        System.out.println(new HighestProduct().solve(A));
    }

    private int solve(int[] A) {
        if(A.length < 3) return 0;
        int l1 = Integer.MIN_VALUE, l2 = Integer.MIN_VALUE, l3 = Integer.MIN_VALUE;
        int s1 = Integer.MAX_VALUE, s2 = Integer.MAX_VALUE;

        for (int x : A) {
            if (x > l1) {
                l3 = l2;
                l2 = l1;
                l1 = x;
            } else if (x > l2) {
                l3 = l2;
                l2 = x;
            } else if (x > l3) {
                l3 = x;
            }
        }

        for (int x : A) {
            if (x < s1) {
                s2 = s1;
                s1 = x;
            } else if (x < s2) {
                s2 = x;
            }
        }

        int prod = l1 * l2 * l3;
        prod = Integer.max(prod, s1 * s2 * l1);

        return prod;
    }
}

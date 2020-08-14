package CollegeAssignments.CAndDS;

public class Assign10August {

    public static void main(String[] args) {
        int[] A = {2, 4, 9, 10};
        int d = 2;
        int[] D = new int[A.length];
        System.out.println(solve(A, d, D));
    }

    private static int solve(int[] A, int d, int[] D) {
        int l = 0, r = 0, max = 0;

        for (int i = 0; i < A.length; i++) {
            int currA = A[i];
            while (l < r && currA < A[D[r - 1]]) r--;
            D[r++] = i;
            if ((r - l) > d) l++;
            int temp = (A[D[r - 1]] - A[D[l]]);
            if (temp > max) max = temp;
        }

        return max;
    }
}

package InterviewBit.Arrays;

public class MinimumLightToActivate {
    public static void main(String[] args) {
        int[] A = {0, 0, 1, 1, 1, 0, 0, 1};
        int B = 3;
        System.out.println(new MinimumLightToActivate().solve(A, B));
    }

    private int solve(int[] A, int B) {
        int count = 0;

        for (int curr = 0; curr < A.length; curr++) {
            int l = curr - B + 1, r = curr + B - 1;
            boolean flag = false;
            for (int i = Integer.min(r, A.length - 1); i >= Integer.max(0, l); i--) {
                if (A[i] == 1) {
                    flag = true;
                    count++;
                    curr = i + B - 1;
                    break;
                }
            }
            if (!flag) return -1;
        }
        return count;
    }
}

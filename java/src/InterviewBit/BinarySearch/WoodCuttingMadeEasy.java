package InterviewBit.BinarySearch;

import java.util.ArrayList;
import java.util.List;

public class WoodCuttingMadeEasy {

    public static void main(String[] args) {

        /*ArrayList<Integer> A = new ArrayList<>(List.of(114, 55, 95, 131, 77, 111, 141));
        int B = 95;*/

        ArrayList<Integer> A = new ArrayList<>(List.of(10, 15, 17, 20));
        int B = 7;

        System.out.println(new WoodCuttingMadeEasy().solveBruteForce(A, B));
        System.out.println(new WoodCuttingMadeEasy().solveOptimal(A, B));

    }

    private int solveBruteForce(ArrayList<Integer> A, int B) {

        int n = A.size();
        int lowH = A.get(0);
        int highH = A.get(0);

        for (int i = 0; i < A.size(); i++) {
            lowH = Integer.min(lowH, A.get(i));
            highH = Integer.max(highH, A.get(i));
        }
        int sum = 0;
        int H = lowH - 1;
        int minH = H;
        int oldSum = Integer.MAX_VALUE;
        while (H <= highH) {
            sum = 0;
            H++;
            for (int i = 0; i < A.size(); i++) {
                int x = A.get(i) - H;
                if (x > 0) {
                    sum += x;
                }
            }
            if (sum >= B && sum < oldSum) {
                oldSum = sum;
                minH = H;
            }
        }

        return minH;
    }

    private int solveOptimal(ArrayList<Integer> A, int B) {
        long lowH = A.get(0);
        long highH = A.get(0);

        for (int i = 0; i < A.size(); i++) {
            lowH = Integer.min((int) lowH, A.get(i));
            highH = Integer.max((int) highH, A.get(i));
        }

        long sum = 0;
        long H = lowH - 1;
        long minH = Integer.MAX_VALUE;
        long oldSum = Integer.MAX_VALUE;
        while (lowH <= highH) {
            H = lowH + (highH - lowH) / 2;
            sum = 0;
            for (int i = 0; i < A.size(); i++) {
                long x = A.get(i) - H;
                if (x > 0) {
                    sum += x;
                }
            }
            if (sum >= B) {
                if (oldSum > sum) {
                    minH = H;
                    oldSum = sum;
                }
                lowH = H + 1;
            } else {
                highH = H - 1;
            }

        }
        return (int) minH;
    }
}

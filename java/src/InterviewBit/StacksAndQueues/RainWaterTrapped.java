package InterviewBit.StacksAndQueues;

import java.util.ArrayList;

public class RainWaterTrapped {

    public static void main(String[] args) {
        int[] A = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(new RainWaterTrapped().trap(A));
    }

    public int trap(final int[] A) {
        int sum = 0, n = A.length;

        ArrayList<Integer> nextGreatestRight = overAllGreatestRight(A);
        ArrayList<Integer> nextGreatestLeft = overAllGreatestLeft(A);

        for (int i = 0; i < n; i++) {
            int left = nextGreatestLeft.get(i), right = nextGreatestRight.get(i);
            if (left != -1 && right != -1) {
                sum += Integer.min(left, right) - A[i];
            }
        }
        return sum;
    }

    private ArrayList<Integer> overAllGreatestRight(int[] A) {
        int n = A.length;
        ArrayList<Integer> list = new ArrayList<>();
        list.add(-1);
        int max = A[n - 1];
        for (int i = A.length - 2; i >= 0; i--) {
            int curr = A[i];
            list.add(0, max <= curr ? -1 : max);
            max = Integer.max(max, curr);
        }
        return list;
    }

    private ArrayList<Integer> overAllGreatestLeft(int[] A) {
        int n = A.length;
        ArrayList<Integer> list = new ArrayList<>();
        list.add(-1);
        int max = A[0];
        for (int i = 1; i < A.length; i++) {
            int curr = A[i];
            list.add(max <= curr ? -1 : max);
            max = Integer.max(max, curr);
        }
        return list;
    }
}

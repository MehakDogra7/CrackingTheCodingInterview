package Question450.Array;

public class MinJumps {

    public static void main(String[] args) {
        int[] A = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
        System.out.println(minJumps(A));
    }

    public static int minJumps(int[] arr) {
        // your code here
        if (arr.length == 1) return 0;
        if (arr[0] == 0) return -1;

        int jumps = 1, stepsRemaining = arr[0], maxReach = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (i == arr.length - 1) return jumps;

            maxReach = Math.max(maxReach, arr[i] + i);
            stepsRemaining--;

            if (stepsRemaining == 0) {
                jumps++;
                if (maxReach <= i) return -1;
                stepsRemaining = maxReach - i;
            }
        }
        return jumps;
    }
}

package Question450.Array;

import java.util.HashMap;
import java.util.Map;

public class SubArrayWithSum0 {

    public static void main(String[] args) {
        int[] A = {4, 2, -3, 1, 6};
        System.out.println(findsum(A, A.length));
    }

    static boolean findsum(int arr[], int n) {
        //Your code here
        Map<Integer, Integer> map = new HashMap<>();
        int currSum = 0;
        for (int i = 0; i < n; i++) {
            currSum += arr[i];

            if (currSum == 0) return true;

            if(map.containsKey(currSum)) return true;

            map.put(currSum, i);
        }
        return false;
    }
}

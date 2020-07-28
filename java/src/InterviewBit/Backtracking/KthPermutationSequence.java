package InterviewBit.Backtracking;

import java.util.ArrayList;

public class KthPermutationSequence {

    ArrayList<String> result = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println(new KthPermutationSequence().getPermutation(100, 2147483646));
    }

    public String getPermutation(int A, int B) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= A; i++) {
            list.add(i);
        }

        return recursive(A, B, list);
    }

    public String recursive(int A, long B, ArrayList<Integer> list) {
        if (list.size() == 1) {
            return list.get(0).toString();
        }

        long blockSize = fact(A - 1, B);
        int resultedBlock = (int) Math.ceil((double) B / blockSize);
        int value = list.get(resultedBlock - 1);
        list.remove(resultedBlock - 1);
        B = B - blockSize * (resultedBlock - 1);
        return value + recursive(A - 1, B, list);
    }

    public long fact(int n, long b) {
        long res = 1;
        for (int i = 2; i <= n; i++) {
            res *= i;
            if (res > b) {
                res = Integer.MAX_VALUE + 5l;
            }
        }
        return res;
    }


}

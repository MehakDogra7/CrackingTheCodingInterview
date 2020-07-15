package InterviewBit.TwoPointers;

import java.util.ArrayList;
import java.util.List;

public class SumOf3Zero {

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(List.of(2147483647, -2147483648, -2147483648, 0, 1));

        /*int[] A = {1, 2, 3, 4, 5};
        int B = 9;*/

        //System.out.println(new SumOf3Numbers().solveBruteForce(A, B));
        new SumOf3Zero().threeSum(A).forEach(i -> {
            i.forEach(j -> System.out.print(j + " "));
            System.out.println();
        });
    }

    public ArrayList<ArrayList<Integer>> threeSum(ArrayList<Integer> A) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        A.sort(Integer::compareTo);

        for (int i = 0; i < A.size(); i++) {
            if (i != 0) {
                if (A.get(i).equals(A.get(i - 1))) {
                    continue;
                }
            }
            int p1 = i + 1;
            int p2 = A.size() - 1;
            while (p1 < p2) {

                long sum = (long) A.get(i) + (long) A.get(p1) + (long) A.get(p2);
                if (sum == 0) {
                    if (p1 != i + 1) {
                        if (!A.get(p1).equals(A.get(p1 - 1))) {
                            if (p2 == A.size() - 1) {
                                result.add(populateTemp(A.get(i), A.get(p1), A.get(p2)));
                            } else if (p2 != A.size() - 1 && !A.get(p2).equals(A.get(p2 + 1))) {
                                result.add(populateTemp(A.get(i), A.get(p1), A.get(p2)));
                            }
                        }
                    } else {
                        if (p2 == A.size() - 1) {
                            result.add(populateTemp(A.get(i), A.get(p1), A.get(p2)));
                        } else if (p2 != A.size() - 1 && !A.get(p2).equals(A.get(p2 + 1))) {
                            result.add(populateTemp(A.get(i), A.get(p1), A.get(p2)));
                        }
                    }
                    p2--;
                } else if (sum < 0) {
                    p1++;
                } else {
                    p2--;
                }
            }
        }
        return result;
    }

    public ArrayList<Integer> populateTemp(int a, int b, int c) {
        int max = Integer.max(a, Integer.max(b, c));
        int min = Integer.min(a, Integer.min(b, c));
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(min);
        temp.add(a + b + c - max - min);
        temp.add(max);
        return temp;
    }
}

package GeeksForGeeks.Arrays;

import java.util.ArrayList;
import java.util.List;

public class TripletsSumInRange {

    public static void main(String[] args) {

        ArrayList<Integer> A = new ArrayList<Integer>(List.of(8, 3, 5, 2));
        ArrayList<Integer> range = new ArrayList<Integer>(List.of(7, 11));
        System.out.println(countTripletsBruteForce(A, range));
        System.out.println(countTripletsOptimal(A, range));
    }

    private static int countTripletsOptimal(ArrayList<Integer> input, ArrayList<Integer> range) {
        if (input.size() < 3 || range.size() != 2) {
            return 0;
        }

        input.sort(Integer::compareTo);
        int inBound = range.get(0);
        int outBound = range.get(1);
        int inBoundCount = 0;
        int outBoundCount = 0;

        for (int i = 0; i < input.size() - 2; i++) {
            int j = i + 1, k = input.size() - 1;
            while (j < k) {
                if (input.get(i) + input.get(j) + input.get(k) >= inBound) {
                    k--;
                } else {
                    inBoundCount += k - j;
                    j++;
                }
            }
        }

        for (int i = 0; i < input.size() - 2; i++) {
            int j = i + 1, k = input.size() - 1;
            while (j < k) {
                if (input.get(i) + input.get(j) + input.get(k) > outBound) {
                    k--;
                } else {
                    outBoundCount += k - j;
                    j++;
                }
            }
        }


        return outBoundCount - inBoundCount;
    }


    private static int countTripletsBruteForce(ArrayList<Integer> A, ArrayList<Integer> range) {
        int count = 0;

        if (A.size() < 3 || range.size() != 2) {
            return count;
        }

        A.sort(Integer::compareTo);

        for (int i = 0; i < A.size(); i++) {
            for (int j = i + 1; j < A.size(); j++) {
                for (int k = j + 1; k < A.size(); k++) {
                    int sum = A.get(i) + A.get(j) + A.get(k);
                    if (sum >= range.get(0) && sum <= range.get(1)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}

package InterviewBit.Math;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SortedPermutationRankWithRep {

    public static void main(String[] args) {

        System.out.println(new SortedPermutationRankWithRep().findRank("sadasdsasassasas"));
    }

    public int findRank(String A) {

        long rank = 1;
        for (int curr = 0; curr < A.length(); curr++) {
            int numberOfCharSmallerThanCurr = getSmall(A, curr);
            ArrayList<Integer> rep = getRep(A, curr);
            long fact = fact(A.length() - curr - 1);
            long mul = 1;
            for (int i = 0; i < rep.size(); i++) {
                mul *= fact(rep.get(i));
            }
            fact = numberOfCharSmallerThanCurr * fact;
            rank += fact / mul;
        }
        return (int) (rank % 1000003);
    }

    public long fact(long n) {
        long fact = n;

        for (long i = n - 1; i >= 2; i--) {
            fact = fact % 1000003;
            fact = fact * i;
            fact = fact % 1000003;
        }
        return fact;
    }

    private int getSmall(String A, int curr) {

        int count = 0;
        for (int i = curr + 1; i < A.length(); i++) {
            if (A.charAt(i) < A.charAt(curr))
                count++;
        }

        return count;
    }

    private ArrayList<Integer> getRep(String A, long curr) {

        Map<Character, Integer> count = new HashMap<>();

        for (int i = (int) (curr); i < A.length(); i++) {
            Character character = A.charAt(i);
            if (count.containsKey(character)) {
                count.put(character, count.get(character) + 1);
            } else {
                count.put(character, 1);
            }
        }

        ArrayList<Integer> common = new ArrayList<>(count.values());

        return common;
    }

}

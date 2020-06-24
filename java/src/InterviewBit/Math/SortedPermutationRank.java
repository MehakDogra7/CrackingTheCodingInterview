package InterviewBit.Math;

import java.util.ArrayList;

public class SortedPermutationRank {

    public static void main(String[] args) {

        System.out.println(new SortedPermutationRank().findRank("DTNGJPURFHYEW"));
    }

    public int findRank(String A) {
        ArrayList<Character> sorted = sort(A);
        int sortedIndex = 0, inputIndex = 0;
        long rank = 1;
        long j = A.length() - 1;
        long fact = fact(A.length() - 1);

        while (sortedIndex < sorted.size() && inputIndex < A.length()) {

            if (sorted.get(sortedIndex) != A.charAt(inputIndex)) {
                rank += fact(j);
                sortedIndex++;
            } else {
                sorted.remove(sortedIndex);
                sortedIndex = 0;
                inputIndex++;
                j--;
            }
        }
        return (int) (rank % 1000003);
    }

    private ArrayList<Character> sort(String A) {

        ArrayList<Character> arrayList = new ArrayList<>();

        for (int i = 0; i < A.length(); i++) {
            arrayList.add(A.charAt(i));
        }

        arrayList.sort(Character::compareTo);

        return arrayList;
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

}

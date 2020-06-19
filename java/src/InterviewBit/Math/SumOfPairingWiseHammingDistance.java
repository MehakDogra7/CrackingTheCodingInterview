package InterviewBit.Math;

import java.util.ArrayList;
import java.util.List;

public class SumOfPairingWiseHammingDistance {

    public static void main(String[] args) {

        ArrayList<Integer> A = new ArrayList<>(List.of(16, 0, 1, 0, 0, 16, 0, 0, 0, 0, 9, 4, 0, 0, 0, 0, 0, 0, 2, 8, 0));

        System.out.println(getSum(A));
        System.out.println(getSumOptimal(A));
    }

    private static int getSumOptimal(ArrayList<Integer> A) {

        long sum = 0;
        for (int i = 0; i < 32; i++) {

            long count = 0;
            for (int j = 0; j < A.size(); j++) {
                if ((A.get(j) & 1 << i) != 0) {
                    count++;
                }
            }
            sum += count * (A.size() - count) * 2;
        }

        return (int) (sum % 1000000007);
    }

    private static int getSum(ArrayList<Integer> A) {

        long sum = 0;
        for (int i = 0; i < A.size(); i++) {
            for (int j = 0; j < A.size(); j++) {
                sum += getHammingDistance(A.get(i), A.get(j));
            }
        }

        return (int) (sum % 1000000007);
    }

    private static long getHammingDistance(int i, int j) {
        long distance = 0;
        ArrayList<Integer> bitsI = new ArrayList<>();
        ArrayList<Integer> bitsJ = new ArrayList<>();

        while (i > 0) {
            bitsI.add(i % 2);
            i /= 2;
        }

        while (j > 0) {
            bitsJ.add(j % 2);
            j /= 2;
        }

        int diff = Math.abs(bitsI.size() - bitsJ.size());
        if (bitsI.size() > bitsJ.size()) {
            for (int k = 0; k < diff; k++) {
                bitsJ.add(0);
            }
        } else if (bitsI.size() < bitsJ.size()) {
            for (int k = 0; k < diff; k++) {
                bitsI.add(0);
            }
        }

        for (int k = 0; k < bitsI.size(); k++) {
            if (!bitsI.get(k).equals(bitsJ.get(k))) {
                distance++;
            }
        }
        return distance;
    }
}

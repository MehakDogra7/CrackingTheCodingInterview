package InterviewBit.Arrays;

import java.util.ArrayList;
import java.util.List;

public class TripletsSumInRange {

    public static void main(String[] args) {

        ArrayList<String> A = new ArrayList<String>(List.of("0.503094", "0.648924", "0.999298"));
        //System.out.println(countTripletsUsingSorting(A));
        System.out.println(countTripletsOptimal(A));
    }

    public static int countTripletsOptimal(ArrayList<String> A) {

        if (A.size() < 3) {
            return 0;
        }

        ArrayList<Double> input = new ArrayList<>();
        A.forEach(i -> input.add(Double.parseDouble(i)));

        ArrayList<Double> a = new ArrayList<>();
        ArrayList<Double> b = new ArrayList<>();
        ArrayList<Double> c = new ArrayList<>();

        input.forEach(i -> {
            if (i >= 0 && i < 2.0 / 3.0) {
                a.add(i);
            } else if (i >= 2.0 / 3.0 && i <= 1) {
                b.add(i);
            } else
                c.add(i);
        });

        double largestA = 0, secLargestA = 0, thirdLargestA = 0;
        double smallestA = 2.0 / 3.0, secSmallestA = 2.0 / 3.0;
        double smallestB = 1, secSmallestB = 1;
        double smallestC = 2;

        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) > largestA) {
                thirdLargestA = secLargestA;
                secLargestA = largestA;
                largestA = a.get(i);
            } else if (a.get(i) > secLargestA) {
                thirdLargestA = secLargestA;
                secLargestA = a.get(i);
            } else if (a.get(i) > thirdLargestA) {
                thirdLargestA = a.get(i);
            }

            if (a.get(i) < smallestA) {
                secSmallestA = smallestA;
                smallestA = a.get(i);
            } else if (a.get(i) < secSmallestA) {
                secSmallestA = a.get(i);
            }
        }

        for (int i = 0; i < b.size(); i++) {
            if (b.get(i) < smallestB) {
                secSmallestB = smallestB;
                smallestB = b.get(i);
            } else if (b.get(i) < secSmallestB) {
                secSmallestB = b.get(i);
            }
        }

        for (int i = 0; i < c.size(); i++) {
            if (c.get(i) < smallestC) {
                smallestC = c.get(i);
            }
        }

        //Case 1 (A, A, A)
        if (a.size() >= 3 && largestA + secLargestA + thirdLargestA > 1 && largestA + secLargestA + thirdLargestA < 2) {
            return 1;
        }

        //Case 2 (A, A, B)
        if (a.size() >= 2 && b.size() >= 1) {
            double s2 = largestA + secLargestA;
            for (int i = 0; i < b.size(); i++) {
                if (b.get(i) > 1 - s2 && b.get(i) < 2 - s2) {
                    return 1;
                }
            }
        }

        //Case 3 (A, A, C)
        if (a.size() >= 2 && c.size() >= 1) {
            double s3 = smallestA + secSmallestA + smallestC;
            if (s3 > 1 && s3 < 2) {
                return 1;
            }
        }

        //Case 4 (A, B, B)
        if (a.size() >= 1 && b.size() >= 2) {
            double s4 = smallestB + secSmallestB;
            for (int i = 0; i < a.size(); i++) {
                if (a.get(i) < 2 - s4) {
                    return 1;
                }
            }
        }

        //Case 5 (A, B, C)
        if (a.size() >= 1 && b.size() >= 1 && c.size() >= 1) {
            double s5 = smallestA + smallestB + smallestC;
            if (s5 > 1 && s5 < 2) {
                return 1;
            }
        }
        return 0;
    }

    public static int countTripletsUsingSorting(ArrayList<String> A) {

        if (A.size() < 3) {
            return 0;
        }

        ArrayList<Double> input = new ArrayList<>();
        A.forEach(i -> input.add(new Double(i)));

        input.sort(Double::compareTo);
        Double inBound = 1.0;
        Double outBound = 2.0;
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
                if (input.get(i) + input.get(j) + input.get(k) >= outBound) {
                    k--;
                } else {
                    outBoundCount += k - j;
                    j++;
                }
            }
        }


        return (outBoundCount - inBoundCount) > 0 ? 1 : 0;
    }
}

package InterviewBit.Arrays;

import java.util.ArrayList;
import java.util.List;

public class ThirdLargest {

    public static void main(String[] args) {

        ArrayList<Double> a = new ArrayList<Double>(List.of(0.6, 0.7, 0.8, 1.2, 0.4));

        double largestA = Double.MIN_VALUE, secLargestA = Double.MIN_VALUE, thirdLargestA = Double.MIN_VALUE;
        double smallestA = Double.MAX_VALUE, secSmallestA = Double.MAX_VALUE;

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

        System.out.println(largestA + " " + secLargestA + " " + thirdLargestA);
        System.out.println(smallestA + " " + secSmallestA);

    }
}

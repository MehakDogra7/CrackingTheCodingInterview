package InterviewBit.Arrays;

import java.util.ArrayList;

public class KthRowOfPascalTriangle {


    public static void main(String[] args) {

        kthRowOfPascalTriangle(3).forEach(System.out::println);
    }

    private static ArrayList<Integer> kthRowOfPascalTriangle(int A) {
        A++;
        ArrayList<Integer> temp = new ArrayList<>();
        ArrayList<Integer> previousRow = new ArrayList<>();

        for (int i = 0; i < A; i++) {
            temp = new ArrayList<>();
            for (int j = 0; j <= i; j++) {

                if (j == 0) {
                    temp.add(1);
                    continue;
                }
                int value1 = (i - 1 < 0 || j - 1 < 0) ? 1 : previousRow.get(j - 1);
                int value2 = (i - 1 < 0 || i == j) ? 0 : previousRow.get(j);
                temp.add(value1 + value2);
            }
            previousRow = temp;
        }

        return temp;
    }

}

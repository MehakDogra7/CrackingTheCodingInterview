package InterviewBit.Math;

import java.util.ArrayList;

public class DecimalToBinary {

    public static void main(String[] args) {

        int n = 8;
        convertToBinary(n).forEach(i -> System.out.print(i + " "));
    }

    private static ArrayList<Integer> convertToBinary(int n) {

        ArrayList<Integer> result = new ArrayList<>();
        while (n > 0) {
            result.add(n % 2);
            n >>>= 1;
        }

        int i = 0, j = result.size() - 1;
        while (i < j) {
            int temp = result.get(i);
            result.set(i, result.get(j));
            result.set(j, temp);
            i++;
            j--;
        }
        return result;
    }
}

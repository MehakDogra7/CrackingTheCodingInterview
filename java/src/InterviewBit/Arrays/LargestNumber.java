package InterviewBit.Arrays;

import java.util.ArrayList;
import java.util.List;

public class LargestNumber {

    public static void main(String[] args) {

        ArrayList<Integer> A = new ArrayList<>(List.of(54, 546, 548, 60));

        System.out.println(new LargestNumber().getLargestNumber(A));
    }

    private String getLargestNumber(ArrayList<Integer> A) {

        StringBuilder output = new StringBuilder();
        Integer[] input = new Integer[A.size()];
        A.toArray(input);
        input = sort(input, 0, A.size() - 1);

        for (int i = 0; i < input.length; i++) {
            output.append(input[i]);
        }

        if (output.charAt(0) == '0')
            return new String("0");

        return output.toString();
    }

    private Integer[] sort(Integer[] input, int start, int end) {

        if (start == end) {
            return new Integer[]{input[start]};
        }

        int mid = (start + end) / 2;
        Integer[] a = sort(input, start, mid);
        Integer[] b = sort(input, mid + 1, end);

        return merge(a, b);
    }

    private Integer[] merge(Integer[] a, Integer[] b) {
        Integer[] result = new Integer[a.length + b.length];
        int i = 0, j = 0, k = 0;
        while (i < a.length && j < b.length) {
            Integer compare = compare(a[i], b[j]);
            switch (compare) {
                case -1:
                    result[k++] = a[i++];
                    break;
                case 1:
                    result[k++] = b[j++];
                    break;
                default: {
                    result[k++] = a[i++];
                    result[k++] = b[j++];
                    break;
                }
            }
        }
        if (i != a.length) {
            while (i < a.length) {
                result[k++] = a[i++];
            }
        }
        if (j != b.length) {
            while (j < b.length) {
                result[k++] = b[j++];
            }
        }
        return result;
    }

    private int compare(Integer a, Integer b) {
        String X = a.toString();
        String Y = b.toString();

        String m = X + Y;
        String n = Y + X;

        int i = 0, j = 0;
        while (i < m.length() && j < n.length()) {
            int c1 = Integer.parseInt(String.valueOf(m.charAt(i)));
            int c2 = Integer.parseInt(String.valueOf(n.charAt(j)));
            if (c2 > c1) {
                return 1;
            } else if (c2 < c1) {
                return -1;
            } else {
                i++;
                j++;
            }
        }
        return 0;
    }

}

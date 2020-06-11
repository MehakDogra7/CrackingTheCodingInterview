package InterviewBit.Arrays.Sorting;

public class MergeSort {

    public static void main(String[] args) {

        Integer[] a = new Integer[]{3, 3, 30, 34, 5, 9};

        a = mergeSort(a, 0, a.length - 1);
        for (Integer i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    private static Integer[] mergeSort(Integer[] input, Integer start, Integer end) {

        if (start == end) {
            return new Integer[]{input[start]};
        }

        Integer mid = (start + end) / 2;
        Integer[] a = mergeSort(input, start, mid);
        Integer[] b = mergeSort(input, mid + 1, end);

        return merge(a, b);
    }

    private static Integer[] merge(Integer[] a, Integer[] b) {
        Integer[] result = new Integer[a.length + b.length];
        int i = 0, j = 0, k = 0;
        while (i < a.length && j < b.length) {
            Integer compare = a[i].compareTo(b[j]);
            switch (compare) {
                case -1 -> result[k++] = a[i++];
                case 1 -> result[k++] = b[j++];
                default -> {
                    result[k++] = a[i++];
                    result[k++] = b[j++];
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
}

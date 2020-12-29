package Question450.SearchingAndSorting;

public class MajorityElement {

    public static void main(String[] args) {
        int[] A = {3, 2, 3};
        System.out.println(new MajorityElement().majorityElement(A));
    }

    public int majorityElement(int[] A) {
        int maxIndex = 0, count = 1;

        for (int i = 1; i < A.length; i++) {
            if (A[i] == A[maxIndex]) count++;
            else count--;

            if (count == 0) {
                maxIndex = i;
                count = 1;
            }
        }
        return A[maxIndex];
    }
}

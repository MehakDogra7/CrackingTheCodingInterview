package Question450.Array;

public class NextPermutation {
    public static void main(String[] args) {
        int[] A = {1, 1};
        new NextPermutation().nextPermutation(A);
        for (int i : A) {
            System.out.print(i + " ");
        }
    }

    public void nextPermutation(int[] nums) {
        int n = nums.length, i = n - 2;
        boolean found = false;

        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }

        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) j--;

            swap(nums, i, j);
        }
        sort(nums, i + 1, n - 1);
    }

    public void sort(int[] A, int i, int j) {
        for (; i < j; i++, j--) {
            swap(A, i, j);
        }
    }

    public void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}

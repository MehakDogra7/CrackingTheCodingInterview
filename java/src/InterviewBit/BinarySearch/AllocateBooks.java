package InterviewBit.BinarySearch;

public class AllocateBooks {

    public static void main(String[] args) {

        int[] A = {10, 20, 30, 40};
        int B = 2;
        System.out.println(new AllocateBooks().books(A, B));
        //System.out.println(new AllocateBooks().isPossible(A, 50, 2));

    }

    public int books(int[] A, int B) {

        if (B > A.length)
            return -1;

        long low = 0;
        long high = 0;
        long ans = 0;

        for (int i = 0; i < A.length; i++) {
            high += A[i];
        }

        while (low <= high) {
            long mid = low + (high - low) / 2;
            boolean isPossible = isPossible(A, mid, B);
            if (isPossible) {
                high = mid - 1;
                ans = mid;
            } else {
                low = mid + 1;
            }
        }

        return (int) ans;
    }

    public boolean isPossible(int[] A, long mid, int B) {

        int j = 0;
        long sum = 0;
        for (int i = 0; i < A.length; i++) {
            if (sum + A[i] <= mid) {
                sum += A[i];
            } else {
                j++;
                if (j >= B) {
                    return false;
                }
                i--;
                sum = 0;
            }
        }

        return true;
    }
}

package CollegeAssignments.Java.Activity1;

public class GarbageCollection {

    public static void main(String[] args) {
        noHeapIssue();
        HeapIssue();
    }

    private static void HeapIssue() {
        int N = 3000;
        int M = 100000;
        for (int i = 0; i < N; i++) {
            int[] box = new int[M];
        }
    }

    private static void noHeapIssue() {
        int N = 2500;
        int M = 100000;
        int[][] boxes = new int[N][];
        for (int i = 0; i < N; i++) {
            int[] box = new int[M];
            boxes[i] = box;
        }
    }
}

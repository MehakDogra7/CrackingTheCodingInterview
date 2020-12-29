package Question450.SearchingAndSorting;

public class CountSquares {

    public static void main(String[] args) {
        System.out.println(new CountSquares().countSquares(9));
    }

    public int countSquares(int N) {
        // code here
        if (N < 2) return 0;
        int count = 1;
        int start = 2;
        while (start * start < N) {
            start++;
            count++;
        }
        return count;
    }
}

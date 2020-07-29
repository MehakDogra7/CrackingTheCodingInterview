package InterviewBit.Backtracking;

public class MaximalString {

    public static void main(String[] args) {
        System.out.println("Ans: " + new MaximalString().solve("5799", 2));
    }

    public String solve(String A, int B) {
        if (B == 0 || A.length() == 0 || A.length() == 1) {
            return A;
        }

        int max = Integer.MIN_VALUE;
        int index = 0;
        for (int i = 0; i < A.length(); i++) {
            int curr = (A.charAt(i) - 48);
            if (max < curr) {
                max = curr;
                index = i;
            }
        }
        if (index == 0) {
            return max + solve(A.substring(1), B);
        }
        String res = "";
        for (int i = index; i < A.length(); i++) {
            if (A.charAt(i) == A.charAt(index)) {
                String temp = solve(swap(A, 0, i).substring(1), B - 1);
                if (temp.compareTo(res) > 0) {
                    res = temp;
                }
            }
        }

        return max + res;
    }

    private String swap(String A, int i, int j) {
        StringBuilder temp = new StringBuilder(A);
        temp.setCharAt(i, A.charAt(j));
        temp.setCharAt(j, A.charAt(i));
        return temp.toString();
    }
}

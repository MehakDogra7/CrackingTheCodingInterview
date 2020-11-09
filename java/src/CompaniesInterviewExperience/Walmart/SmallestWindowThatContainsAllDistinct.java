package CompaniesInterviewExperience.Walmart;

public class SmallestWindowThatContainsAllDistinct {

    public static void main(String[] args) {
        String A = "aabcbcdbca";
        System.out.println(new SmallestWindowThatContainsAllDistinct().solve(A));
    }

    private String solve(String A) {
        boolean[] visited = new boolean[256];
        int n = A.length(), distinct = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[A.charAt(i)]) {
                visited[A.charAt(i)] = true;
                distinct++;
            }
        }

        int start = 0, finalStart = -1, minLength = Integer.MAX_VALUE, counter = 0;
        int[] currCount = new int[256];

        for (int i = 0; i < n; i++) {
            currCount[A.charAt(i)]++;

            if (currCount[A.charAt(i)] == 1) counter++;

            if (counter == distinct) {
                while (currCount[A.charAt(start)] > 1) {
                    currCount[A.charAt(start)]--;
                    start++;
                }

                int currWindowLength = i - start + 1;
                if (minLength > currWindowLength) {
                    minLength = currWindowLength;
                    finalStart = start;
                }
            }
        }

        return A.substring(finalStart, finalStart + minLength);
    }
}






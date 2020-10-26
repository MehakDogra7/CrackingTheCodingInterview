package InterviewBit.GraphDSAndAlgo;

public class WordSearchBoard {

    public static void main(String[] args) {
        String[] A = {"ABCE", "SFCS", "ADEE"};

        String B = "ABCB";
        System.out.println(new WordSearchBoard().exist(A, B));
    }

    public int exist(String[] A, String B) {

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length(); j++) {
                boolean temp = dfs(A, i, j, B, 0);
                if (temp) return 1;
            }
        }

        return 0;
    }

    private boolean dfs(String[] A, int i, int j, String B, int bIndex) {
        if (bIndex >= B.length()) return true;

        if (A[i].charAt(j) != B.charAt(bIndex)) return false;

        int[][] paths = {
                {-1, 0}, {0, 1},
                {1, 0}, {0, -1}
        };

        for (int[] path : paths) {
            int neighbourRow = i + path[0], neighbourColumn = j + path[1];
            if (neighbourRow >= 0 && neighbourRow < A.length &&
                    neighbourColumn >= 0 && neighbourColumn < A[0].length()) {
                boolean temp = dfs(A, neighbourRow, neighbourColumn, B, bIndex + 1);
                if (temp) return true;
            }
        }
        return false;
    }
}
